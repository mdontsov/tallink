package com.tallink.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "conference_name")
    private String conference_name;

    @Column(name = "active")
    private boolean active;

    @Column(name = "guest_id")
    private Long guest_id;

    public String getConferenceName() {
        return conference_name;
    }

    public void setConferenceName(String conference_name) {
        this.conference_name = conference_name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Long getGuestId() {
        return guest_id;
    }

    public void setGuestId(Long guest_id) {
        this.guest_id = guest_id;
    }

    public Conference(String conference_name, boolean active, Long guest_id) {
        this.conference_name = conference_name;
        this.active = active;
        this.guest_id = guest_id;
    }

    public Conference() {

    }
}
