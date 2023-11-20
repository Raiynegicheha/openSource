package com.example.application.domain.tutors;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import org.springframework.stereotype.Service;

@Service
@BrowserCallable
@AnonymousAllowed
public class LessonService {
    private final LessonRepository lessonRepository;

    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElseThrow();
    }

    public Iterable<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }
}
