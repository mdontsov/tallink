package com.tallink.demo.model;

import lombok.Data;
import javax.persistence.*;
import java.util.*;

@Data
@Entity(name = "Conference")
@Table(name = "conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "guest_fname")
    private String guest_fname;

    @Column(name = "guest_lname")
    private String guest_lname;

    @Column(name = "active")
    private boolean active;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "conference")
    private List<Room> room = new ArrayList<>();

    public Conference() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuest_fname() {
        return guest_fname;
    }

    public void setGuest_fname(String guest_fname) {
        this.guest_fname = guest_fname;
    }

    public String getGuest_lname() {
        return guest_lname;
    }

    public void setGuest_lname(String guest_lname) {
        this.guest_lname = guest_lname;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Room> getRoom() {
        return room;
    }

    public void setRoom(List<Room> room) {
        this.room = room;
    }

    public Conference(String name, String guest_fname, String guest_lname, boolean active) {
        this.name = name;
        this.guest_fname = guest_fname;
        this.guest_lname = guest_lname;
        this.active = active;
    }
}
