package com.tallink.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @NonNull
    private Long row_id;

    @Id
    @NonNull
    @Column(name = "room_name")
    private String room_name;

    @NonNull
    @Column(name = "seats_num")
    private int numberOfSeats;

    @Column(name = "conference_name")
    private String conference_name;

    public Long getRowId() {
        return row_id;
    }

    public void setRowId(Long row_id) {
        this.row_id = row_id;
    }

    public String getRoomName() {
        return room_name;
    }

    public void setRoomName(String room_name) {
        this.room_name = room_name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getConferenceName() {
        return conference_name;
    }

    public void setConferenceName(String conference_name) {
        this.conference_name = conference_name;
    }

    public Room(@NonNull Long row_id, @NonNull String room_name, @NonNull int numberOfSeats, String conference_name) {
        this.row_id = row_id;
        this.room_name = room_name;
        this.numberOfSeats = numberOfSeats;
        this.conference_name = conference_name;
    }

    public Room() {

    }
}
