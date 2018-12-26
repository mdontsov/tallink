package com.tallink.demo.repository;

import com.tallink.demo.dto.ConferenceDTO;
import com.tallink.demo.model.Conference;
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
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO conference (conference_name, active) VALUES (?, true)", nativeQuery = true)
    void createConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET active = 'false' WHERE conference_name = ? AND conference_name\n" +
            " IS NOT NULL", nativeQuery = true)
    void cancelConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET conference_name = ? WHERE conference_name = ? AND conference_name\n" +
            " IS NOT NULL", nativeQuery = true)
    void updateConferenceName(String newConferenceName, String oldConferenceName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM conference WHERE conference_name = ? AND conference_name IS NOT NULL", nativeQuery = true)
    void deleteConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET conference_name = NULL WHERE conference_name = ?", nativeQuery = true)
    void disableConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET guest_full_name = (SELECT DISTINCT full_name FROM guest WHERE full_name = ?\n" +
            " AND full_name IS NOT NULL) WHERE guest_full_name IS NULL AND conference_name = ?", nativeQuery = true)
    void addGuest(String guestFullName, String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO conference (guest_full_name, conference_name, active) VALUES\n" +
            " (?, ?, true)", nativeQuery = true)
    void registerGuest(String guestFullName, String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET guest_full_name = NULL WHERE guest_full_name = ? AND\n" +
            " conference_name = ?", nativeQuery = true)
    void removeGuest(String guestFullName, String conferenceName);

    @Query(value = "SELECT * FROM conference", nativeQuery = true)
    Set<Conference> findConferences();
}
