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
    @Query(value = "INSERT INTO conference (conference_name, active) VALUES (?, true)",
            nativeQuery = true)
    void createNewConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET active = 'false' WHERE conference_name = ?", nativeQuery = true)
    void cancelConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM conference WHERE conference_name = ?", nativeQuery = true)
    void deleteConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET guest_full_name = (SELECT guest.full_name\n" +
            "FROM guest WHERE full_name = ?) WHERE guest_full_name IS NULL AND conference_name = ?", nativeQuery = true)
    void addGuestToConference(String guestFullName, String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM conference WHERE guest_full_name = ?", nativeQuery = true)
    void removeGuestFromConference(String guestFullName);

    @Query(value = "select * from conference", nativeQuery = true)
    Set<Conference> getAllConferences();
}
