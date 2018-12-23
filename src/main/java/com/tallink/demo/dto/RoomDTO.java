package com.tallink.demo.dto;

public class RoomDTO {

    private Long id;

    private String room_name;

    private int seats_num;

    private String conference_name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return room_name;
    }

    public void setRoomName(String room_name) {
        this.room_name = room_name;
    }

    public int getSeatsNum() {
        return seats_num;
    }

    public void setSeatsNum(int seats_num) {
        this.seats_num = seats_num;
    }

    public String getConferenceName() {
        return conference_name;
    }

    public void setConferenceName(String conference_name) {
        this.conference_name = conference_name;
    }

    public RoomDTO(Long id, String room_name, int seats_num, String conference_name) {
        this.id = id;
        this.room_name = room_name;
        this.seats_num = seats_num;
        this.conference_name = conference_name;
    }

    public RoomDTO() {

    }
}
