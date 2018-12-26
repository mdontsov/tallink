package com.tallink.demo.dto;

public class RoomDTO {

    private Long id;

    private String roomName;

    private int numberOfSeats;

    private String conferenceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public RoomDTO(Long id, String roomName, int numberOfSeats, String conferenceName) {
        this.id = id;
        this.roomName = roomName;
        this.numberOfSeats = numberOfSeats;
        this.conferenceName = conferenceName;
    }

    public RoomDTO(Long id, String roomName, int numberOfSeats) {
        this.id = id;
        this.roomName = roomName;
        this.numberOfSeats = numberOfSeats;
    }

    public RoomDTO() {

    }
}
