package com.tallink.demo.controller;

import com.tallink.demo.model.Conference;
import com.tallink.demo.model.Room;
import com.tallink.demo.repository.ConferenceRepository;
import com.tallink.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    RoomRepository roomRepository;

    @PatchMapping (value = "conference/patch")
    public void createNewConference() {
        conferenceRepository.createNewConference("TEST");
    }

    @GetMapping(value = "conference/get")
    public List<Conference> getAllConferences() {
        return conferenceRepository.getAllConferences();
    }

    @GetMapping(value = "room/get")
    public List<Room> getAllRooms() {
        return roomRepository.getAllRooms();
    }
}
