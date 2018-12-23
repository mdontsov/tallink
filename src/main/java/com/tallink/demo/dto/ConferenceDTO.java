package com.tallink.demo.dto;

public class ConferenceDTO {

    private Long id;

    private String name;

    private String guestFirstName;

    private String guestLastName;

    private boolean isActive;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ConferenceDTO(Long id, String name, String guestFirstName, String guestLastName, boolean isActive) {
        this.id = id;
        this.name = name;
        this.guestFirstName = guestFirstName;
        this.guestLastName = guestLastName;
        this.isActive = isActive;
    }
}
