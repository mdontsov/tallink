package com.tallink.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "room_name")
    private String room_name;

    @NonNull
    @Column(name = "seats_num")
    private int numberOfSeats;

    @Column(name = "conference_id")
    private Long conference_id;

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

    public Long getConferenceId() {
        return conference_id;
    }

    public void setConferenceId(Long conference_id) {
        this.conference_id = conference_id;
    }

    public Room(@NonNull String room_name, @NonNull int numberOfSeats, Long conference_id) {
        this.room_name = room_name;
        this.numberOfSeats = numberOfSeats;
        this.conference_id = conference_id;
    }

    public Room() {

    }
}
