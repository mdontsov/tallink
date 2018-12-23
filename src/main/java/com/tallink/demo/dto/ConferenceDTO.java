package com.tallink.demo.dto;

public class ConferenceDTO {

    private Long id;

    private String conference_name;

    private boolean active;

    private String guest_full_name;

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

    public ConferenceDTO(Long id, String conference_name, boolean active, String guest_full_name) {
        this.id = id;
        this.conference_name = conference_name;
        this.active = active;
        this.guest_full_name = guest_full_name;
    }

    public ConferenceDTO() {

    }
}
