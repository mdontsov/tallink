package com.tallink.demo.repository;

import com.tallink.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO event (c_name, g_name) VALUES ((select c_name FROM conference WHERE c_name = ? AND\n" +
            " c_name IS NOT  NULL), (SELECT DISTINCT g_name FROM guest WHERE g_name = ? AND g_name IS NOT NULL))", nativeQuery = true)
    void registerEvemt(String conferenceName, String guestFullName);

    @Query(value = "SELECT * FROM event", nativeQuery = true)
    Set<Event> findEvents();

    @Transactional
    @Modifying
    @Query(value = "UPDATE event SET g_name = NULL WHERE g_name = ?", nativeQuery = true)
    void removeGuest(String guestFullName);

    @Transactional
    @Modifying
    @Query(value = "DELETE from event WHERE c_name = ? AND c_name IS NOT NULL", nativeQuery = true)
    void deleteConference(String conferenceName);
}
