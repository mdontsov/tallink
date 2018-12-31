package com.tallink.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "g_name")
    private String guestFullName;

    @Column(name = "c_name")
    private String conferenceName;

    @Column(name = "r_name")
    private String roomName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGuestFullName() {
        return guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Event(String guestFullName, String conferenceName, String roomName) {
        this.guestFullName = guestFullName;
        this.conferenceName = conferenceName;
        this.roomName = roomName;
    }

    public Event(String guestFullName, String conferenceName) {
        this.guestFullName = guestFullName;
        this.conferenceName = conferenceName;
    }

    public Event() {
    }
}
