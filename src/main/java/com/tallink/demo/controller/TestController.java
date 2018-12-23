package com.tallink.demo.controller;

import com.tallink.demo.dto.ConferenceDTO;
import com.tallink.demo.dto.RoomDTO;
import com.tallink.demo.repository.ConferenceRepository;
import com.tallink.demo.repository.GuestRepository;
import com.tallink.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
public class TestController {

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    GuestRepository guestRepository;

    @PatchMapping(value = "conference/newConference/{conference_name}")
    public void createNewConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.createNewConference(conferenceName);
    }

    @PatchMapping(value = "conference/newGuest/{guest_full_name}")
    public void registerNewGuest(@PathVariable("guest_full_name") String guestFullName) {
        guestRepository.createNewGuest(guestFullName);
    }

    @PutMapping(value = "conference/cancelConference/{conference_name}")
    public void cancelConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.cancelConference(conferenceName);
    }

    @DeleteMapping(value = "conference/deleteConference/{conference_name}")
    public void deleteConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.deleteConference(conferenceName);
    }

    @GetMapping(value = "conference/getConferences")
    public Set<ConferenceDTO> getAllConferences() {
        return conferenceRepository.getAllConferences();
    }

    @GetMapping(value = "room/getRooms")
    public Set<RoomDTO> getAllRooms() {
        return roomRepository.getAllRooms();
    }
}
