package com.tallink.demo.dto;

public class ConferenceDTO {

    private Long row_id;

    private String conference_name;

    private boolean active;

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

    public ConferenceDTO(Long row_id, String conference_name, boolean active, String guest_full_name) {
        this.row_id = row_id;
        this.conference_name = conference_name;
        this.active = active;
        this.guest_full_name = guest_full_name;
    }

    public ConferenceDTO() {

    }
}
