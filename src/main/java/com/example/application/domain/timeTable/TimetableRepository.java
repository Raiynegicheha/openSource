package com.example.application.domain.timeTable;

import com.example.application.domain.rooms.RoomRepository;
import com.example.application.domain.tutors.Lesson;
import com.example.application.domain.tutors.LessonRepository;
import com.example.application.events.TimeSlotRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TimetableRepository {
    // There is only one time table, so there is only timeTableId (= problemId).
    public static final Long SINGLETON_TIME_TABLE_ID = 1L;


    private final TimeSlotRepository timeslotRepository;

    private final RoomRepository roomRepository;

    private final LessonRepository lessonRepository;

    public TimeTable findById(Long id) {
        if (!SINGLETON_TIME_TABLE_ID.equals(id)) {
            throw new IllegalStateException("There is no timeTable with id (" + id + ").");
        }
        // Occurs in a single transaction, so each initialized lesson references the same timeslot/room instance
        // that is contained by the timeTable's timeslotList/roomList.
        return new TimeTable(
                timeslotRepository.findAll(),
                roomRepository.findAll(),
                lessonRepository.findAll());
    }

    public void save(TimeTable timeTable) {
        for (Lesson lesson : timeTable.getLessonList()) {
            // TODO this is awfully naive: optimistic locking causes issues if called by the SolverManager
            lessonRepository.findById(lesson.getId()).ifPresent(attachedLesson -> {
                attachedLesson.setTimeslot(lesson.getTimeslot());
                attachedLesson.setRoom(lesson.getRoom());
            });
        }
    }
}
