package com.tallink.demo.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "seats_number")
    private int numberOfSeats;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "conference_room", joinColumns = @JoinColumn(name = "room_id"),
//            inverseJoinColumns = @JoinColumn(name = "conference_id"))
//    private List<Conference> conference = new ArrayList<>();

    public Room() {

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

//    public List<Conference> getConference() {
//        return conference;
//    }
//
//    public void setConference(List<Conference> conference) {
//        this.conference = conference;
//    }

    public Room(@NonNull String room_name, @NonNull int numberOfSeats) {
        this.room_name = room_name;
        this.numberOfSeats = numberOfSeats;
    }
}
