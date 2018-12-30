package com.tallink.demo.repository;

import com.tallink.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO event (c_name, g_name) VALUES ((select c_name FROM conference WHERE c_name = ? AND\n" +
            " c_name IS NOT  NULL), (SELECT DISTINCT g_name FROM guest WHERE g_name = ? AND g_name IS NOT NULL))", nativeQuery = true)
    void registerEvemt(String conferenceName, String guestFullName);
}
