package com.example.application.data;

import com.example.application.domain.rooms.Room;
import com.example.application.domain.rooms.RoomRepository;
import com.example.application.domain.tutors.Lesson;
import com.example.application.domain.tutors.LessonRepository;
import com.example.application.events.TimeSlotRepository;
import com.example.application.events.Timeslot;
import com.example.application.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.application.project.Project;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class DatabaseInit implements CommandLineRunner {
    private final ProjectRepository projectRepository;

    private final TimeSlotRepository timeslotRepository;
    private final RoomRepository roomRepository;
    private final LessonRepository lessonRepository;


    private DemoData demoData;
    @Override
    public void run(String... args) throws Exception {

        //generate seed data for project

        if (projectRepository.count()>0) {
            return;
        }

        for (int i=0; i<100;i++){
            Project project = new Project();
            project.setProjectName("Minet");
            project.setProjectDescription("Minet is a mining company");
            project.setProjectManager("John Doe");
            project.setProjectStatus("Active");
            project.setDepartmentName("Mining");
            project.setProjectStartDate(LocalDate.now());
            project.setProjectEndDate(LocalDate.now().plusYears(2));

            projectRepository.save(project);


                if (demoData == DemoData.NONE) {
                    return;
                }

                timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                timeslotRepository.save(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
                if (demoData == DemoData.LARGE) {
                    timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.WEDNESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.THURSDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
                    timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
                }

                roomRepository.save(new Room("Room A"));
                roomRepository.save(new Room("Room B"));
                roomRepository.save(new Room("Room C"));
                if (demoData == DemoData.LARGE) {
                    roomRepository.save(new Room("Room D"));
                    roomRepository.save(new Room("Room E"));
                    roomRepository.save(new Room("Room F"));
                }

                lessonRepository.save(new Lesson("Math", "A. Turing", "9th grade"));
                lessonRepository.save(new Lesson("Math", "A. Turing", "9th grade"));
                lessonRepository.save(new Lesson("Physics", "M. Curie", "9th grade"));
                lessonRepository.save(new Lesson("Chemistry", "M. Curie", "9th grade"));
                lessonRepository.save(new Lesson("Biology", "C. Darwin", "9th grade"));
                lessonRepository.save(new Lesson("History", "I. Jones", "9th grade"));
                lessonRepository.save(new Lesson("English", "I. Jones", "9th grade"));
                lessonRepository.save(new Lesson("English", "I. Jones", "9th grade"));
                lessonRepository.save(new Lesson("Spanish", "P. Cruz", "9th grade"));
                lessonRepository.save(new Lesson("Spanish", "P. Cruz", "9th grade"));
                if (demoData == DemoData.LARGE) {
                    lessonRepository.save(new Lesson("Math", "A. Turing", "9th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "9th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "9th grade"));
                    lessonRepository.save(new Lesson("ICT", "A. Turing", "9th grade"));
                    lessonRepository.save(new Lesson("Physics", "M. Curie", "9th grade"));
                    lessonRepository.save(new Lesson("Geography", "C. Darwin", "9th grade"));
                    lessonRepository.save(new Lesson("Geology", "C. Darwin", "9th grade"));
                    lessonRepository.save(new Lesson("History", "I. Jones", "9th grade"));
                    lessonRepository.save(new Lesson("English", "I. Jones", "9th grade"));
                    lessonRepository.save(new Lesson("Drama", "I. Jones", "9th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "9th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "9th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "9th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "9th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "9th grade"));
                }

                lessonRepository.save(new Lesson("Math", "A. Turing", "10th grade"));
                lessonRepository.save(new Lesson("Math", "A. Turing", "10th grade"));
                lessonRepository.save(new Lesson("Math", "A. Turing", "10th grade"));
                lessonRepository.save(new Lesson("Physics", "M. Curie", "10th grade"));
                lessonRepository.save(new Lesson("Chemistry", "M. Curie", "10th grade"));
                lessonRepository.save(new Lesson("French", "M. Curie", "10th grade"));
                lessonRepository.save(new Lesson("Geography", "C. Darwin", "10th grade"));
                lessonRepository.save(new Lesson("History", "I. Jones", "10th grade"));
                lessonRepository.save(new Lesson("English", "P. Cruz", "10th grade"));
                lessonRepository.save(new Lesson("Spanish", "P. Cruz", "10th grade"));
                if (demoData == DemoData.LARGE) {
                    lessonRepository.save(new Lesson("Math", "A. Turing", "10th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "10th grade"));
                    lessonRepository.save(new Lesson("ICT", "A. Turing", "10th grade"));
                    lessonRepository.save(new Lesson("Physics", "M. Curie", "10th grade"));
                    lessonRepository.save(new Lesson("Biology", "C. Darwin", "10th grade"));
                    lessonRepository.save(new Lesson("Geology", "C. Darwin", "10th grade"));
                    lessonRepository.save(new Lesson("History", "I. Jones", "10th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "10th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "10th grade"));
                    lessonRepository.save(new Lesson("Drama", "I. Jones", "10th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "10th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "10th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "10th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "10th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "10th grade"));

                    lessonRepository.save(new Lesson("Math", "A. Turing", "11th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "11th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "11th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "11th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "11th grade"));
                    lessonRepository.save(new Lesson("ICT", "A. Turing", "11th grade"));
                    lessonRepository.save(new Lesson("Physics", "M. Curie", "11th grade"));
                    lessonRepository.save(new Lesson("Chemistry", "M. Curie", "11th grade"));
                    lessonRepository.save(new Lesson("French", "M. Curie", "11th grade"));
                    lessonRepository.save(new Lesson("Physics", "M. Curie", "11th grade"));
                    lessonRepository.save(new Lesson("Geography", "C. Darwin", "11th grade"));
                    lessonRepository.save(new Lesson("Biology", "C. Darwin", "11th grade"));
                    lessonRepository.save(new Lesson("Geology", "C. Darwin", "11th grade"));
                    lessonRepository.save(new Lesson("History", "I. Jones", "11th grade"));
                    lessonRepository.save(new Lesson("History", "I. Jones", "11th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "11th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "11th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "11th grade"));
                    lessonRepository.save(new Lesson("Spanish", "P. Cruz", "11th grade"));
                    lessonRepository.save(new Lesson("Drama", "P. Cruz", "11th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "11th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "11th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "11th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "11th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "11th grade"));

                    lessonRepository.save(new Lesson("Math", "A. Turing", "12th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "12th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "12th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "12th grade"));
                    lessonRepository.save(new Lesson("Math", "A. Turing", "12th grade"));
                    lessonRepository.save(new Lesson("ICT", "A. Turing", "12th grade"));
                    lessonRepository.save(new Lesson("Physics", "M. Curie", "12th grade"));
                    lessonRepository.save(new Lesson("Chemistry", "M. Curie", "12th grade"));
                    lessonRepository.save(new Lesson("French", "M. Curie", "12th grade"));
                    lessonRepository.save(new Lesson("Physics", "M. Curie", "12th grade"));
                    lessonRepository.save(new Lesson("Geography", "C. Darwin", "12th grade"));
                    lessonRepository.save(new Lesson("Biology", "C. Darwin", "12th grade"));
                    lessonRepository.save(new Lesson("Geology", "C. Darwin", "12th grade"));
                    lessonRepository.save(new Lesson("History", "I. Jones", "12th grade"));
                    lessonRepository.save(new Lesson("History", "I. Jones", "12th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "12th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "12th grade"));
                    lessonRepository.save(new Lesson("English", "P. Cruz", "12th grade"));
                    lessonRepository.save(new Lesson("Spanish", "P. Cruz", "12th grade"));
                    lessonRepository.save(new Lesson("Drama", "P. Cruz", "12th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "12th grade"));
                    lessonRepository.save(new Lesson("Art", "S. Dali", "12th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "12th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "12th grade"));
                    lessonRepository.save(new Lesson("Physical education", "C. Lewis", "12th grade"));
                }
            };
        }

        public enum DemoData {
            NONE,
            SMALL,
            LARGE
        }


    }

