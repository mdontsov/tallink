package com.tallink.demo.controller;

import com.tallink.demo.model.Conference;
import com.tallink.demo.model.Guest;
import com.tallink.demo.model.Room;
import com.tallink.demo.repository.ConferenceRepository;
import com.tallink.demo.repository.GuestRepository;
import com.tallink.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TestController {

    @PersistenceContext
    protected EntityManager manager;

    @Autowired
    ConferenceRepository conferenceRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    GuestRepository guestRepository;

    @PatchMapping(value = "conference/create")
    Conference createConference(@RequestBody Conference conference) {
        conference.setGuestFullName("Conference Host");
        return conferenceRepository.save(new Conference(conference.getConferenceName(),
                conference.getGuestFullName()));
    }

    @PatchMapping(value = "conference/addGuest")
    public void addGuest(@RequestBody Conference conference) {
        conferenceRepository.addGuest(conference.getGuestFullName(), conference.getConferenceName());
    }

    @PatchMapping(value = "guest/update")
    public void update(@RequestBody Guest guest) {
        guestRepository.updateGuestName(guest.getFullName());
    }

    @PostMapping(value = "guest/create")
    public void createNew(@RequestBody Guest guest) {
        guestRepository.createGuest(guest.getFullName());
    }

    @PatchMapping(value = "room/add")
    public void addConference(@RequestBody Room room) {
        roomRepository.addConference(room.getConferenceName(), room.getRoomName());
    }

    @PutMapping(value = "conference/cancel")
    public void cancelConference(@RequestBody Conference conference) {
        conferenceRepository.cancelConference(conference.getConferenceName());
    }

    @PutMapping(value = "conference/cancel/{conference_name}")
    public void cancelConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.cancelConference(conferenceName);
    }

    @PutMapping(value = "conference/activate/{conference_name}")
    public void activateConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.activateConference(conferenceName);
    }

    @PutMapping(value = "conference/disable")
    public void disableConference(@RequestBody Conference conference) {
        conferenceRepository.disableConference(conference.getConferenceName());
    }

    @PutMapping(value = "conference/update")
    public void updateConferenceName(@RequestBody Conference conference, String newConferenceName) {
        conferenceRepository.updateConferenceName(newConferenceName, conference.getConferenceName());
    }

    @PutMapping(value = "conference/update/{conference_name}")
    public void updateConferenceNameByRequest(@RequestBody Conference conference,
                                              @PathVariable("conference_name") String conferenceName) {
        conferenceRepository.updateConferenceName(conference.getConferenceName(), conferenceName);
    }

    @DeleteMapping(value = "conference/delete")
    public void deleteConference(@RequestBody Conference conference) {
        conferenceRepository.deleteConference(conference.getConferenceName());
    }

    @DeleteMapping(value = "conference/delete/{conference_name}")
    public void deleteConference(@PathVariable("conference_name") String conferenceName) {
        conferenceRepository.deleteConference(conferenceName);
    }

    @DeleteMapping(value = "conference/deleteAll")
    public void deleteAllConferences() {
        conferenceRepository.deleteAllConferences();
    }

    @GetMapping(value = "conference")
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

    @PatchMapping(value = "conference/registerGuest")
    public void registerGuest(@RequestBody Conference conference) {
        conferenceRepository.registerGuest(conference.getGuestFullName(), conference.getConferenceName());
    }

    @PutMapping(value = "conference/remove/{guest_full_name}")
    public void removeGuest(@PathVariable("guest_full_name") String guestFullName) {
        conferenceRepository.removeGuest(guestFullName);
    }

    @GetMapping(value = "room/findAvailable")
    public Set<Room> findAvailableRoom(@RequestParam String conferenceName) {
        return roomRepository.findAvailableRoomByConferenceName(conferenceName);
    }

    @PutMapping(value = "room/remove")
    public void removeConference(@RequestBody Room room) {
        roomRepository.removeConference(room.getConferenceName(), room.getRoomName());
    }

    @GetMapping(value = "conference/getName")
    Set<Conference> getConferenceName() {
        return conferenceRepository.getName();
    }

    @GetMapping(value = "conferenceList")
    List<String> getConferenceList() {
        TypedQuery<String> query = manager.createQuery("SELECT DISTINCT conferenceName FROM Conference", String.class);
        return query.getResultList();
    }
}
