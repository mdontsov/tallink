package com.tallink.demo.repository;

import com.tallink.demo.dto.GuestDTO;
import com.tallink.demo.model.Guest;
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
public interface GuestRepository extends JpaRepository<Guest, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO guest (full_name) VALUES (?)", nativeQuery = true)
    void createNew(String conferenceName);

    @Query(value = "SELECT * FROM guest", nativeQuery = true)
    Set<Guest> findGuests();
}
