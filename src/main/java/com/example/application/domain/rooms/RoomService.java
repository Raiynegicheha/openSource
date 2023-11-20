package com.example.application.domain.rooms;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import org.springframework.stereotype.Service;

@Service
@BrowserCallable
@AnonymousAllowed
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    public Room save(Room room) {
        return roomRepository.save(room);
    }


    public Room findById(Long id) {
        return roomRepository.findById(id).orElseThrow();
    }


    public Iterable<Room> findAll() {
        return roomRepository.findAll();
    }


    public void deleteById(Long id) {
        roomRepository.deleteById(id);

    }
}
