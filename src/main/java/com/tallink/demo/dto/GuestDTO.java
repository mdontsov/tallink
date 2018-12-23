package com.tallink.demo.dto;

public class GuestDTO {

    private Long id;

    private String full_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public GuestDTO(Long id, String full_name) {
        this.id = id;
        this.full_name = full_name;
    }

    public GuestDTO() {

    }
}
