package com.tallink.demo.dto;

public class RoomDTO {

    private Long id;

    private String room_name;

    private int seats_num;

    private Long conference_id;

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

    public Long getConferenceId() {
        return conference_id;
    }

    public void setConferenceId(Long conference_id) {
        this.conference_id = conference_id;
    }

    public RoomDTO(Long id, String room_name, int seats_num, Long conference_id) {
        this.id = id;
        this.room_name = room_name;
        this.seats_num = seats_num;
        this.conference_id = conference_id;
    }

    public RoomDTO() {
        
    }
}
