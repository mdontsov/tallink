package com.tallink.demo.model;

import javax.persistence.*;
import java.util.*;

@Entity(name = "Conference")
@Table(name = "conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "conference_name")
    private String conference_name;

    @Column(name = "guest_full_name")
    private String guest_full_name;

    @Column(name = "active")
    private boolean active;

//    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL,
//            mappedBy = "conference")
//    private List<Room> room = new ArrayList<>();

    public Conference() {

    }

    public String getConferenceName() {
        return conference_name;
    }

    public void setConferenceName(String conference_name) {
        this.conference_name = conference_name;
    }

    public String getFullName() {
        return guest_full_name;
    }

    public void setFullName(String guest_full_name) {
        this.guest_full_name = guest_full_name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    public List<Room> getRoom() {
//        return room;
//    }
//
//    public void setRoom(List<Room> room) {
//        this.room = room;
//    }

    public Conference(String conference_name, String guest_full_name, boolean active) {
        this.conference_name = conference_name;
        this.guest_full_name = guest_full_name;
        this.active = active;
    }
}
