package com.tallink.demo.dto;

public class ConferenceDTO {

    private Long id;

    private String conference_name;

    private String guest_full_name;

    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ConferenceDTO(Long id, String conference_name, String guest_full_name, boolean active) {
        this.id = id;
        this.conference_name = conference_name;
        this.guest_full_name = guest_full_name;
        this.active = active;
    }

    public ConferenceDTO() {

    }
}
