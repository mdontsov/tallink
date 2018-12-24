package com.tallink.demo.controller;

import com.tallink.demo.model.Conference;
import com.tallink.demo.model.Guest;
import com.tallink.demo.model.Room;
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

    @PatchMapping(value = "conference/new/{conference_name}")
    public void newConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.newConference(conferenceName);
    }

    @PatchMapping(value = "conference/add/{guest_full_name}, {conference_name}")
    public void addGuest(@PathVariable("guest_full_name") String guestFullName,
                         @PathVariable("conference_name") String conferenceName) {
        conferenceRepository.addGuest(guestFullName, conferenceName);
    }

    @PatchMapping(value = "room/add/{conference_name}, {room_name}")
    public void addConference(@PathVariable("conference_name") String conferenceName,
                              @PathVariable("room_name") String roomName) {
        roomRepository.addConference(conferenceName, roomName);
    }

    @PutMapping(value = "conference/cancel/{conference_name}")
    public void cancelConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.cancelConference(conferenceName);
    }

    @DeleteMapping(value = "conference/delete/{conference_name}")
    public void deleteConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.deleteConference(conferenceName);
    }

    @GetMapping(value = "conference/find")
    public Set<Conference> findConferences() {
        return conferenceRepository.findConferences();
    }

    @GetMapping(value = "room/find")
    public Set<Room> findRooms() {
        return roomRepository.findRooms();
    }

    @GetMapping(value = "guest/find")
    public Set<Guest> findGuests() {
        return guestRepository.findGuests();
    }

    @PostMapping(value = "guest/create/{full_name}")
    public void createNew(@PathVariable("full_name") String guestFullName) {
        guestRepository.createNew(guestFullName);
    }

    @PostMapping(value = "conference/register/{full_name}, {conference_name}")
    public void registerGuest(@PathVariable("full_name") String guestFullName,
                              @PathVariable("conference_name") String conferenceName) {
        conferenceRepository.registerGuest(guestFullName, conferenceName);
    }

    @PutMapping(value = "conference/remove/{guest_full_name}")
    public void removeGuest(@PathVariable("guest_full_name") String guestFullName) {
        conferenceRepository.removeGuest(guestFullName);
    }

    @GetMapping(value = "room/available")
    public Set<Room> findAvailableRoom() {
        return roomRepository.findAvailableRoom();
    }

    @PutMapping(value = "room/remove/{conference_name}")
    public void removeConference(@PathVariable("conference_name") String conferenceName) {
        roomRepository.removeConference(conferenceName);
    }
}
