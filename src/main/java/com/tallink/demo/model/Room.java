package com.tallink.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "r_name", nullable = false)
    private String roomName;

    @Column(name = "seats_num", nullable = false)
    private int numberOfSeats;

    @Column(name = "c_name")
    private String conferenceName;

    public Long getId() {
        return id;
    }

    public void setId(Long row_id) {
        this.id = row_id;
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

    public Room(String roomName, int numberOfSeats, String conferenceName) {
        this.roomName = roomName;
        this.numberOfSeats = numberOfSeats;
        this.conferenceName = conferenceName;
    }

    public Room(String roomName, int numberOfSeats) {
        this.roomName = roomName;
        this.numberOfSeats = numberOfSeats;
    }

    public Room() {

    }
}
