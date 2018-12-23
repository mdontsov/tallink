package com.tallink.demo.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "seats_number")
    private int numberOfSeats;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "conference_room", joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "conference_id"))
    private List<Conference> conference = new ArrayList<>();

    public Room() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<Conference> getConference() {
        return conference;
    }

    public void setConference(List<Conference> conference) {
        this.conference = conference;
    }

    public Room(@NonNull String name, @NonNull int numberOfSeats) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
    }
}
