package com.tallink.demo.dto;

public class ConferenceDTO {

    private Long id;

    private String conferenceName;

    private boolean active;

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

    public ConferenceDTO(Long id, String conferenceName, String guestFullName) {
        this.id = id;
        this.conferenceName = conferenceName;
        this.active = true;
        this.guestFullName = guestFullName;
    }

    public ConferenceDTO(Long id, String conferenceName) {
        this.id = id;
        this.conferenceName = conferenceName;
        this.active = true;
    }

    public ConferenceDTO() {

    }
}
