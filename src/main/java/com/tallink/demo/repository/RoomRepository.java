package com.tallink.demo.repository;

import com.tallink.demo.dto.RoomDTO;
import com.tallink.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Query projection doesn't work as expected yet
 * https://jira.spring.io/browse/DATAJPA-1003
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "SELECT * FROM room ", nativeQuery = true)
    Set<Room> findRooms();

    @Transactional
    @Modifying
    @Query(value = "UPDATE room SET conference_name = (SELECT DISTINCT conference.conference_name\n" +
            "FROM conference WHERE conference_name = ?) WHERE conference_name IS NULL AND room_name = ?",
            nativeQuery = true)
    void addConference(String conferenceName, String roomName);

    @Query(value = "SELECT * FROM room WHERE EXISTS (SELECT COUNT (conference.guest_full_name) FROM conference\n" +
            "WHERE conference.guest_full_name IS NOT NULL HAVING COUNT (conference.guest_full_name)\n" +
            " < room.seats_num)", nativeQuery = true)
    Set<Room> findAvailableRoom();

    @Transactional
    @Modifying
    @Query(value = "UPDATE room SET conference_name = NULL WHERE conference_name = ?", nativeQuery = true)
    void removeConference(String conferenceName);
}
