package com.example.application.events;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TimeSlotRepository extends CrudRepository<Timeslot, Long>, PagingAndSortingRepository<Timeslot, Long>{
    @Override
    List<Timeslot> findAll();
}
