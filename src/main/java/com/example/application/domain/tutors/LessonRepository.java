package com.example.application.domain.tutors;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Long>, PagingAndSortingRepository<Lesson, Long> {
    @Override
    List<Lesson> findAll();
}
