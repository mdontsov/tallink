package com.tallink.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "c_name")
    private String conferenceName;

    @Column(name = "g_name")
    private String guestFullName;

    @Column(name = "r_name")
    private String roomName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public String getGuestFullName() {
        return guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Event(String conferenceName, String guestFullName, String roomName) {
        this.conferenceName = conferenceName;
        this.guestFullName = guestFullName;
        this.roomName = roomName;
    }

    public Event(String conferenceName, String guestFullName) {
        this.conferenceName = conferenceName;
        this.guestFullName = guestFullName;
    }

    public Event() {
    }
}
