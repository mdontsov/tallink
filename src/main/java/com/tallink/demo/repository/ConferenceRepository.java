package com.tallink.demo.repository;

import com.tallink.demo.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Query projection doesn't work as expected yet
 * https://jira.spring.io/browse/DATAJPA-1003
 */

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO conference (name, active) VALUES (?, true)", nativeQuery = true)
    void createNewConference(String name);

    @Query(value = "UPDATE conference SET active = 'false' WHERE name = ?", nativeQuery = true)
    void cancelConference();

    @Query(value = "DELETE FROM conference WHERE name = ?", nativeQuery = true)
    void deleteConference();

    @Query(value = "INSERT INTO conference (guest_fname, guest_lname) VALUES (?, ?) WHERE name = ?", nativeQuery = true)
    void addGuestToConference();

    @Query(value = "DELETE FROM conference WHERE guest_fname = ? AND guest_lname = ?", nativeQuery = true)
    void removeGuestFromConference();

    @Query(value = "select * from conference", nativeQuery = true)
    List<Conference> getAllConferences();
}
