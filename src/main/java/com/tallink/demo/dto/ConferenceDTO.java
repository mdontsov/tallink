package com.tallink.demo.dto;

public class ConferenceDTO {

    private Long id;

    private String conference_name;

    private boolean active;

    private Long guest_id;

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

    public Long getGuestId() {
        return guest_id;
    }

    public void setGuestId(Long guest_id) {
        this.guest_id = guest_id;
    }

    public ConferenceDTO(Long id, String conference_name, boolean active, Long guest_id) {
        this.id = id;
        this.conference_name = conference_name;
        this.active = active;
        this.guest_id = guest_id;
    }

    public ConferenceDTO() {

    }
}
