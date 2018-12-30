package com.tallink.demo.repository;

import com.tallink.demo.dto.ConferenceDTO;
import com.tallink.demo.model.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

/**
 * Query projection doesn't work as expected yet
 * https://jira.spring.io/browse/DATAJPA-1003
 */

@Repository
public interface ConferenceRepository extends JpaRepository<Conference, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO conference (c_name, active) VALUES (?, true)", nativeQuery = true)
    void createConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET active = 'false' WHERE c_name = ? AND c_name\n" +
            " IS NOT NULL", nativeQuery = true)
    void cancelConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET active = 'true' WHERE c_name = ? AND c_name\n" +
            " IS NOT NULL", nativeQuery = true)
    void activateConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET c_name = ? WHERE c_name = ? AND c_name\n" +
            " IS NOT NULL", nativeQuery = true)
    void updateConferenceName(String newConferenceName, String oldConferenceName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM conference WHERE c_name = ? AND c_name IS NOT NULL", nativeQuery = true)
    void deleteConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET c_name = NULL WHERE c_name = ?", nativeQuery = true)
    void disableConference(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET f_name = (SELECT DISTINCT full_name FROM guest WHERE full_name = ?\n" +
            " AND full_name IS NOT NULL) WHERE f_name IS NULL AND c_name = (SELECT DISTINCT\n" +
            " c_name FROM conference WHERE c_name = ?)", nativeQuery = true)
    void addGuest(String guestFullName, String conferenceName);

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO conference (f_name, c_name, active) VALUES\n" +
//            " (?, ?, true)", nativeQuery = true)
//    void registerGuest(String guestFullName, String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "UPDATE conference SET f_name = NULL WHERE f_name = ?", nativeQuery = true)
    void removeGuest(String guestFullName);

    @Query(value = "SELECT * FROM conference", nativeQuery = true)
    Set<Conference> findConferences();

    @Query(value = "SELECT * FROM conference WHERE c_name = ?", nativeQuery = true)
    Optional<Conference> findConferenceByName(String conferenceName);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM conference", nativeQuery = true)
    void deleteAllConferences();

    @Query(value = "SELECT * FROM conference WHERE c_name IS NOT NULL", nativeQuery = true)
    Set<Conference> getName();
}
