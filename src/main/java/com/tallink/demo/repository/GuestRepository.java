package com.tallink.demo.repository;

import com.tallink.demo.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO guest (full_name) VALUES (?)",
            nativeQuery = true)
    void createNewGuest(String conferenceName);
}
