package com.tallink.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "conference_name")
    private String conferenceName;

    @Column(name = "active")
    private boolean active;

    @Column(name = "guest_full_name")
    private String guestFullName;

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getGuestFullName() {
        return guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public Conference(String conferenceName, String guestFullName) {
        this.conferenceName = conferenceName;
        this.active = true;
        this.guestFullName = guestFullName;
    }

    public Conference(String conferenceName) {
        this.conferenceName = conferenceName;
        this.active = true;
    }

    public Conference() {

    }
}
