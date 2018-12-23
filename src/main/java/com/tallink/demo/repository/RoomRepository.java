package com.tallink.demo.repository;

import com.tallink.demo.dto.RoomDTO;
import com.tallink.demo.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Query projection doesn't work as expected yet
 * https://jira.spring.io/browse/DATAJPA-1003
 */


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query(value = "select * from room ", nativeQuery = true)
    Set<Room> getAllRooms();
}
