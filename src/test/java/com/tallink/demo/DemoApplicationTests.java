package com.tallink.demo;

import com.tallink.demo.model.Conference;
import com.tallink.demo.model.Event;
import com.tallink.demo.model.Guest;
import com.tallink.demo.model.Room;
import com.tallink.demo.repository.ConferenceRepository;
import com.tallink.demo.repository.EventRepository;
import com.tallink.demo.repository.GuestRepository;
import com.tallink.demo.repository.RoomRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Configuration
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@Transactional
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class DemoApplicationTests {

	private Conference conference;
	private Guest guest;
	private Room room;
	private Event event;

	@Mock
	private ConferenceRepository conferenceRepository;

	@Mock
	private GuestRepository guestRepository;

	@Mock
	private RoomRepository roomRepository;

	@Mock
	private EventRepository eventRepository;



	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		conference = new Conference();
		guest = new Guest();
		room = new Room();
		event = new Event();
	}

	@Test
	public void newConferenceTest() {
		conference.setConferenceName("Tallink");
		conference.setActive(true);
		conferenceRepository.save(new Conference(conference.getConferenceName()));
		assertNotNull(conference.getConferenceName());
	}

	@Test
	public void cancelConferenceTest() {
		conference.setConferenceName("Tallink");
		conference.setActive(true);
		conferenceRepository.save(new Conference(conference.getConferenceName()));
		conferenceRepository.cancelConference(conference.getConferenceName());
	}

	@Test
	public void roomAvailabilityTest() {

	}

	@Test
	public void addParticipantToConferenceTest() {

	}

	@Test
	public void removeParticipantFromConferenceTest() {

	}

}

