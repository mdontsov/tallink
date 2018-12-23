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

    @PatchMapping(value = "conference/create/{conference_name}")
    public void createNewConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.createNewConference(conferenceName);
    }

    @PatchMapping(value = "conference/addGuest/{guest_full_name}, {conference_name}")
    public void addGuestToExistingConference(@PathVariable("guest_full_name") String guestFullName,
                                             @PathVariable("conference_name") String conferenceName) {
        conferenceRepository.addGuestToExistingConference(guestFullName, conferenceName);
    }

    @PatchMapping(value = "room/newConference/{conference_name}, {room_name}")
    public void registerNewConference(@PathVariable("conference_name") String conferenceName,
                                      @PathVariable("room_name") String roomName) {
        roomRepository.addConferenceToRoom(conferenceName, roomName);
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
    public void createNewGuest(@PathVariable("full_name") String guestFullName) {
        guestRepository.createNewGuest(guestFullName);
    }

    @PostMapping(value = "conference/register/{full_name}, {conference_name}")
    public void registerGuestToConference(@PathVariable("full_name") String guestFullName,
                                          @PathVariable("conference_name") String conferenceName) {
        conferenceRepository.registerGuestToConference(guestFullName, conferenceName);
    }
}
