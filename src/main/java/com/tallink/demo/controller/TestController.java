package com.tallink.demo.controller;

import com.tallink.demo.model.Conference;
import com.tallink.demo.model.Event;
import com.tallink.demo.model.Guest;
import com.tallink.demo.model.Room;
import com.tallink.demo.repository.ConferenceRepository;
import com.tallink.demo.repository.EventRepository;
import com.tallink.demo.repository.GuestRepository;
import com.tallink.demo.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Autowired
    EventRepository eventRepository;

    @PostMapping(value = "conference/create")
    public Conference createConference(@RequestBody Conference conference) {
        return conferenceRepository.save(new Conference(conference.getConferenceName()));
    }

    @PostMapping(value = "guest/create")
    public Guest createGuest(@RequestBody Guest guest) {
        return guestRepository.save(new Guest(guest.getFullName(), guest.getBirthDate()));
    }

    @PostMapping(value = "event/create")
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(new Event(event.getGuestFullName(), event.getConferenceName()));
    }

    @GetMapping(value = "conference")
    public Set<Conference> findConferences() {
        return conferenceRepository.findConferences();
    }

    @GetMapping(value = "guest")
    public Set<Guest> findGuests() {
        return guestRepository.findGuests();
    }

    @GetMapping(value = "event")
    public Set<Event> findEvents() {
        return eventRepository.findEvents();
    }

    @PutMapping(value = "event/removeGuest/{f_name}")
    public void removeGuest(@PathVariable("f_name") String guestFullName) {
        eventRepository.removeGuest(guestFullName);
    }

    @DeleteMapping(value = "event/deleteConference/{c_name}")
    public void deleteConference(@PathVariable("c_name") String conferenceName) {
        eventRepository.deleteConference(conferenceName);
    }

    @PostMapping(value = "event/registerEvent")
    public void registerEvent(@RequestBody Event event) {
        eventRepository.registerEvemt(event.getGuestFullName(), event.getConferenceName());
    }

    @DeleteMapping(value = "guest/deleteAll")
    public void deleteAllGuests() {
        guestRepository.deleteAllGuests();
    }

    /***********************************************************************************/
//    @PatchMapping(value = "conference/addGuest")
//    public void addGuest(@RequestBody Conference conference) {
//        conferenceRepository.addGuest(conference.getGuestFullName(), conference.getConferenceName());
//    }
    @PatchMapping(value = "guest/update")
    public void update(@RequestBody Guest guest) {
        guestRepository.updateGuestName(guest.getFullName());
    }

//    @PatchMapping(value = "guest/create")
//    public void createNew(@RequestBody Guest guest) {
//        guestRepository.createGuest(guest.getFullName(), String.valueOf(guest.getBirthDate()));
//    }

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

    @DeleteMapping(value = "conference/deleteAll")
    public void deleteAllConferences() {
        conferenceRepository.deleteAllConferences();
    }

    @GetMapping(value = "room/find")
    public Set<Room> findRooms() {
        return roomRepository.findRooms();
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
}
