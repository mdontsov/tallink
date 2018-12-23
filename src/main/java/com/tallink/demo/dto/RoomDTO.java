package com.tallink.demo.dto;

public class RoomDTO {

    private Long id;

    private String room_name;

    private int numberOfSeats;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public RoomDTO(Long id, String room_name, int numberOfSeats) {
        this.id = id;
        this.room_name = room_name;
        this.numberOfSeats = numberOfSeats;
    }

    public RoomDTO() {

    }
}
