package com.example.application.domain.rooms;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoomRepository extends CrudRepository<Room, Long>, PagingAndSortingRepository<Room, Long> {
    @Override
    List<Room> findAll();

}
