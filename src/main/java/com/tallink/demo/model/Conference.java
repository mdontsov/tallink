package com.tallink.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "row_id")
    private Long row_id;

    @Column(name = "conference_name")
    private String conference_name;

    @Column(name = "active")
    private boolean active;

    @Column(name = "guest_full_name")
    private String guest_full_name;

    public Long getRow_id() {
        return row_id;
    }

    public void setRow_id(Long row_id) {
        this.row_id = row_id;
    }

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

    public String getFullName() {
        return guest_full_name;
    }

    public void setFullName(String guest_full_name) {
        this.guest_full_name = guest_full_name;
    }

    public Conference(String conference_name, boolean active, String guest_full_name) {
        this.conference_name = conference_name;
        this.active = active;
        this.guest_full_name = guest_full_name;
    }

    public Conference() {

    }
}
