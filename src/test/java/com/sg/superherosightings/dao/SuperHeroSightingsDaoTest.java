/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.model.Location;
import com.sg.superherosightings.model.Organization;
import com.sg.superherosightings.model.Person;
import com.sg.superherosightings.model.Sighting;
import com.sg.superherosightings.model.Superpower;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author tgraves
 */
public class SuperHeroSightingsDaoTest {

    private SuperHeroSightingsDao dao;

    public SuperHeroSightingsDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("SuperHeroSightingsDao", SuperHeroSightingsDao.class);

        List<Sighting> sightings = dao.getAllSightings();
        for (Sighting currentSighting : sightings) {
            dao.removeSighting(currentSighting.getSightingId());
        }

        List<Person> persons = dao.getAllPersons();
        for (Person currentPerson : persons) {
            dao.removePerson(currentPerson.getPersonId());
        }

        List<Organization> organizations = dao.getAllOrganizations();
        for (Organization currentOrganization : organizations) {
            dao.removeOrganization(currentOrganization.getOrganizationId());
        }

        List<Location> locations = dao.getAllLocations();
        for (Location currentLocation : locations) {
            dao.removeLocation(currentLocation.getLocationId());
        }

        List<Superpower> superpowers = dao.getAllSuperpowers();
        for (Superpower currentSuperpower : superpowers) {
            dao.removeSuperpower(currentSuperpower.getSuperpowerId());
        }
    }

    @After
    public void tearDown() {
    }

    // SUPERPOWER TESTS
    // =================
    @Test
    public void addGetSuperpower() {
        Superpower power = new Superpower();
        power.setName("Flying");
        power.setDescription("Can fly");
        dao.addSuperpower(power);
        // dao should assign an id
        Superpower fromDao = dao.getSuperpower(power.getSuperpowerId());
        assertEquals(power, fromDao);
    }

    @Test
    public void removeSuperpower() {
        Superpower power = new Superpower();
        power.setName("Flying");
        power.setDescription("Can fly");
        dao.addSuperpower(power);
        // dao should assign an id
        Superpower fromDao = dao.getSuperpower(power.getSuperpowerId());
        assertEquals(power, fromDao);

        dao.removeSuperpower(power.getSuperpowerId());
        assertNull(dao.getSuperpower(power.getSuperpowerId()));
    }

    @Test
    public void updateSuperpower() {
        Superpower power = new Superpower();
        power.setName("Flying");
        power.setDescription("Can fly");
        dao.addSuperpower(power);
        // dao should assign an id
        Superpower fromDao = dao.getSuperpower(power.getSuperpowerId());
        assertEquals(power, fromDao);
        // update and check to see if update went through
        power.setName("Flight");
        dao.updateSuperpower(power);
        assertNotEquals(power, fromDao);

        fromDao = dao.getSuperpower(power.getSuperpowerId());
        assertEquals(power, fromDao);
    }

    @Test
    public void getAllSuperpowers() {
        Superpower power = new Superpower();
        power.setName("Flying");
        power.setDescription("Can fly");
        dao.addSuperpower(power);

        Superpower power2 = new Superpower();
        power2.setName("Teleportation");
        power.setDescription("Can teleport");
        dao.addSuperpower(power2);

        // dao should assign an id
        assertEquals(2, dao.getAllSuperpowers().size());
        dao.removeSuperpower(power.getSuperpowerId());
        assertNull(dao.getSuperpower(power.getSuperpowerId()));
        assertEquals(1, dao.getAllSuperpowers().size());
    }

    // LOCATION TESTS
    // ==============
    @Test
    public void addGetLocation() {
        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.7589);
        dao.addLocation(location);
        // dao should assign an id
        Location fromDao = dao.getLocation(location.getLocationId());
        assertEquals(location, fromDao);
    }

    @Test
    public void removeLocation() {
        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.7589);
        dao.addLocation(location);
        // dao should assign an id
        Location fromDao = dao.getLocation(location.getLocationId());
        assertEquals(location, fromDao);

        dao.removeLocation(location.getLocationId());
        assertNull(dao.getLocation(location.getLocationId()));
    }

    @Test
    public void updateLocation() {
        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.7589);
        dao.addLocation(location);
        // dao should assign an id
        Location fromDao = dao.getLocation(location.getLocationId());
        assertEquals(location, fromDao);
        // update and check to see if update went through
        location.setName("Churchill Downs");
        location.setState("KY");
        dao.updateLocation(location);
        assertNotEquals(location, fromDao);

        fromDao = dao.getLocation(location.getLocationId());
        assertEquals(location, fromDao);
    }

    @Test
    public void getAllLocations() {
        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.7589);
        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("Churchill Downs");
        location2.setDescription("Horse racing track");
        location2.setStreet("700 Central Ave");
        location2.setCity("Louisville");
        location2.setState("KY");
        location2.setCountry("USA");
        location2.setLongitude(-85.770038);
        location2.setLatitude(38.202973);
        dao.addLocation(location2);

        // dao should assign an id
        assertEquals(2, dao.getAllLocations().size());
        dao.removeLocation(location.getLocationId());
        assertNull(dao.getLocation(location.getLocationId()));
        assertEquals(1, dao.getAllLocations().size());
    }

    @Test
    public void getLocationsByPersonId() {
        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.758888);
        dao.addLocation(location);

        Location location2 = new Location();
        location2.setName("Churchill Downs");
        location2.setDescription("Horse racing track");
        location2.setStreet("700 Central Ave");
        location2.setCity("Louisville");
        location2.setState("KY");
        location2.setCountry("USA");
        location2.setLongitude(-85.770038);
        location2.setLatitude(38.202973);
        dao.addLocation(location2);

        Superpower power = new Superpower();
        power.setName("Flying");
        dao.addSuperpower(power);
        List<Superpower> powerList = new ArrayList();
        powerList.add(power);

        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        person.setSuperpowers(powerList);
        dao.addPerson(person);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        // associate person with location
        Sighting sighting = new Sighting();
        sighting.setLocation(location);
        sighting.setDate(LocalDate.parse("2010-01-01", DateTimeFormatter.ISO_DATE));
        sighting.setPersons(personList);
        dao.addSighting(sighting);

        Sighting sighting2 = new Sighting();
        sighting2.setLocation(location2);
        sighting2.setDate(LocalDate.parse("2010-01-02", DateTimeFormatter.ISO_DATE));
        sighting2.setPersons(personList);
        dao.addSighting(sighting2);

        // dao should assign an id
        assertEquals(2, dao.getLocationsByPersonId(person.getPersonId()).size());
    }

    // PERSON TESTS
    // ============
    @Test
    public void addGetPerson() {
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        // dao should assign an id
        Person fromDao = dao.getPerson(person.getPersonId());
        assertEquals(person, fromDao);
    }

    @Test
    public void removePerson() {
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        // dao should assign an id
        Person fromDao = dao.getPerson(person.getPersonId());
        assertEquals(person, fromDao);

        dao.removePerson(person.getPersonId());
        assertNull(dao.getPerson(person.getPersonId()));
    }

    @Test
    public void updatePerson() {
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        // dao should assign an id
        Person fromDao = dao.getPerson(person.getPersonId());
        assertEquals(person, fromDao);
        // update and check to see if update went through
        person.setName("Max Eisenhardt");
        dao.updatePerson(person);
        assertNotEquals(person, fromDao);

        fromDao = dao.getPerson(person.getPersonId());
        assertEquals(person, fromDao);
    }

    @Test
    public void getAllPersons() {
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        // dao should assign an id
        assertEquals(2, dao.getAllPersons().size());
        dao.removePerson(person.getPersonId());
        assertNull(dao.getPerson(person.getPersonId()));
        assertEquals(1, dao.getAllPersons().size());
    }

    @Test
    public void getPersonsByLocationId() {
        // create location for sighting
        Location location = new Location();
        location.setName("Xavier's School for Gifted Youngsters");
        location.setDescription("School for X-Men");
        location.setStreet("1407 Graymalkin Lane");
        location.setCity("Salem Center");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(1);
        location.setLatitude(1);
        dao.addLocation(location);

        // create persons for sighting
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        Sighting sighting = new Sighting();
        sighting.setLocation(location);
        sighting.setPersons(personList);
        sighting.setDate(LocalDate.parse("2018-10-16", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting);

        // Should return Magneto and Charles
        assertEquals(2, dao.getPersonsByLocationId(location.getLocationId()).size());
        assertEquals(personList, dao.getPersonsByLocationId(location.getLocationId()));

        // location2 for sighting2
        Location location2 = new Location();
        location2.setName("Churchill Downs");
        location2.setDescription("Horse racing track");
        location2.setStreet("700 Central Ave");
        location2.setCity("Louisville");
        location2.setState("KY");
        location2.setCountry("USA");
        location2.setLongitude(-85.770038);
        location2.setLatitude(38.202973);
        dao.addLocation(location2);

        // remove Magneto from personList
        personList.remove(0);

        Sighting sighting2 = new Sighting();
        sighting2.setLocation(location2);
        sighting2.setPersons(personList);
        sighting2.setDate(LocalDate.parse("2018-05-05", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting2);

        // Should return only Charles
        assertEquals(1, dao.getPersonsByLocationId(location2.getLocationId()).size());
        assertEquals(personList, dao.getPersonsByLocationId(location2.getLocationId()));
        assertEquals(person2, dao.getPersonsByLocationId(location2.getLocationId()).get(0));
    }

    @Test
    public void getPersonsByOrganizationId() {
        // create location for organization
        Location location = new Location();
        location.setName("Xavier's School for Gifted Youngsters");
        location.setDescription("School for X-Men");
        location.setStreet("1407 Graymalkin Lane");
        location.setCity("Salem Center");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(1);
        location.setLatitude(1);
        dao.addLocation(location);

        // create persons for organization
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        Organization organization = new Organization();
        organization.setName("X-Men");
        organization.setDescription("Do gooders");
        organization.setPhone("555-5555");
        organization.setEmail("xmen@xmen.com");
        organization.setLocation(location);
        organization.setMembers(personList);
        dao.addOrganization(organization);

        assertEquals(2, dao.getPersonsByOrganizationId(organization.getOrganizationId()).size());
        assertEquals(personList, dao.getPersonsByOrganizationId(organization.getOrganizationId()));
    }

    // ORGANIZATION TESTS
    // ==================
    @Test
    public void addGetOrganization() {
        // create location for organization
        Location location = new Location();
        location.setName("Xavier's School for Gifted Youngsters");
        location.setDescription("School for X-Men");
        location.setStreet("1407 Graymalkin Lane");
        location.setCity("Salem Center");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(1);
        location.setLatitude(1);
        dao.addLocation(location);

        // create persons for organization
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        Organization organization = new Organization();
        organization.setName("X-Men");
        organization.setDescription("Do gooders");
        organization.setPhone("555-5555");
        organization.setEmail("xmen@xmen.com");
        organization.setLocation(location);
        organization.setMembers(personList);
        dao.addOrganization(organization);
        // dao should assign an id
        Organization fromDao = dao.getOrganization(organization.getOrganizationId());
        assertEquals(organization, fromDao);
    }

    @Test
    public void removeOrganization() {
        // create location for organization
        Location location = new Location();
        location.setName("Xavier's School for Gifted Youngsters");
        location.setDescription("School for X-Men");
        location.setStreet("1407 Graymalkin Lane");
        location.setCity("Salem Center");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(1);
        location.setLatitude(1);
        dao.addLocation(location);

        // create persons for organization
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        Organization organization = new Organization();
        organization.setName("X-Men");
        organization.setDescription("Do gooders");
        organization.setPhone("555-5555");
        organization.setEmail("xmen@xmen.com");
        organization.setLocation(location);
        organization.setMembers(personList);
        dao.addOrganization(organization);
        // dao should assign an id
        Organization fromDao = dao.getOrganization(organization.getOrganizationId());
        assertEquals(organization, fromDao);

        dao.removeOrganization(organization.getOrganizationId());
        assertNull(dao.getOrganization(organization.getOrganizationId()));
    }

    @Test
    public void updateOrganization() {
        // create location for organization
        Location location = new Location();
        location.setName("Xavier's School for Gifted Youngsters");
        location.setDescription("School for X-Men");
        location.setStreet("1407 Graymalkin Lane");
        location.setCity("Salem Center");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(1);
        location.setLatitude(1);
        dao.addLocation(location);

        // create persons for organization
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        Organization organization = new Organization();
        organization.setName("X-Men");
        organization.setDescription("Do gooders");
        organization.setPhone("555-5555");
        organization.setEmail("xmen@xmen.com");
        organization.setLocation(location);
        organization.setMembers(personList);
        dao.addOrganization(organization);
        // dao should assign an id
        Organization fromDao = dao.getOrganization(organization.getOrganizationId());
        assertEquals(organization, fromDao);

        // Change name, description, and location on organization and have
        // dao update organization
        Location location2 = new Location();
        location2.setName("Genosha");
        location2.setLongitude(2);
        location2.setLatitude(2);
        dao.addLocation(location2);

        organization.setName("Brotherhood of Mutants");
        organization.setDescription("Do badders");
        organization.setLocation(location2);
        dao.updateOrganization(organization);
        assertNotEquals(organization, fromDao);

        fromDao = dao.getOrganization(organization.getOrganizationId());
        assertEquals(organization, fromDao);
    }

    @Test
    public void getAllOrganizations() {
        // create location for organization
        Location location = new Location();
        location.setName("Xavier's School for Gifted Youngsters");
        location.setDescription("School for X-Men");
        location.setStreet("1407 Graymalkin Lane");
        location.setCity("Salem Center");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(1);
        location.setLatitude(1);
        dao.addLocation(location);

        // create persons for organization
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        Organization organization = new Organization();
        organization.setName("X-Men");
        organization.setDescription("Do gooders");
        organization.setPhone("555-5555");
        organization.setEmail("xmen@xmen.com");
        organization.setLocation(location);
        organization.setMembers(personList);
        dao.addOrganization(organization);

        // create location for organization2     
        Location location2 = new Location();
        location2.setName("Genosha");
        location2.setLongitude(2);
        location2.setLatitude(2);
        dao.addLocation(location2);

        // remove Xavier from persons for organization2
        personList.remove(1);

        Organization organization2 = new Organization();
        organization2.setName("Brotherhood of Mutants");
        organization2.setDescription("Do badders");
        organization2.setPhone("777-7777");
        organization2.setEmail("mutants@brotherhood.com");
        organization2.setLocation(location2);
        organization2.setMembers(personList);
        dao.addOrganization(organization2);

        assertEquals(2, dao.getAllLocations().size());
        List<Organization> organizationList = dao.getAllOrganizations();
        dao.removeOrganization(organization2.getOrganizationId());
        assertEquals(1, dao.getAllOrganizations().size());
    }

    @Test
    public void getOrganizationsByPersonId() {
        // create location for organization
        Location location = new Location();
        location.setName("Xavier's School for Gifted Youngsters");
        location.setDescription("School for X-Men");
        location.setStreet("1407 Graymalkin Lane");
        location.setCity("Salem Center");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(1);
        location.setLatitude(1);
        dao.addLocation(location);

        // create persons for organization
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);

        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);

        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person2);

        Organization organization = new Organization();
        organization.setName("X-Men");
        organization.setDescription("Do gooders");
        organization.setPhone("555-5555");
        organization.setEmail("xmen@xmen.com");
        organization.setLocation(location);
        organization.setMembers(personList);
        dao.addOrganization(organization);
        // dao should assign an id
        Organization fromDao = dao.getOrganization(organization.getOrganizationId());
        assertEquals(organization, fromDao);

        // returns a list with only one organization so index is 0
        assertEquals(1, dao.getOrganizationsByPersonId(person.getPersonId()).size());
        assertEquals(organization, dao.getOrganizationsByPersonId(person.getPersonId()).get(0));
        assertEquals(organization, dao.getOrganizationsByPersonId(person2.getPersonId()).get(0));

    }

    // SIGHTING TESTS
    // ==============
    @Test
    public void addGetSighting() {
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.758888);
        dao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setPersons(personList);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting);
        // dao should assign an id
        Sighting fromDao = dao.getSighting(sighting.getSightingId());
        assertEquals(sighting, fromDao);
    }

    @Test
    public void removeSighting() {
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.758888);
        dao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setPersons(personList);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting);
        // dao should assign an id
        Sighting fromDao = dao.getSighting(sighting.getSightingId());
        assertEquals(sighting, fromDao);

        dao.removeSighting(sighting.getSightingId());
        assertNull(dao.getSighting(sighting.getSightingId()));
    }

    @Test
    public void updateSighting() {
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.758888);
        dao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setPersons(personList);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting);
        // dao should assign an id
        Sighting fromDao = dao.getSighting(sighting.getSightingId());
        assertEquals(sighting, fromDao);

        // update and check to see if update went through
        Location location2 = new Location();
        location2.setName("Genosha");
        location2.setLongitude(2);
        location2.setLatitude(2);
        dao.addLocation(location2);
        sighting.setLocation(location2);
        dao.updateSighting(sighting);
        assertNotEquals(sighting, fromDao);

        fromDao = dao.getSighting(sighting.getSightingId());
        assertEquals(sighting, fromDao);
    }

    @Test
    public void getAllSightings() {
        // person for sighting
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        // location for sighting
        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.758888);
        dao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setPersons(personList);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting);

        // person2 for sighting2
        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);
        personList.add(person2);

        // location2 for sighting2
        Location location2 = new Location();
        location2.setName("Churchill Downs");
        location2.setDescription("Horse racing track");
        location2.setStreet("700 Central Ave");
        location2.setCity("Louisville");
        location2.setState("KY");
        location2.setCountry("USA");
        location2.setLongitude(-85.770038);
        location2.setLatitude(38.202973);
        dao.addLocation(location2);

        Sighting sighting2 = new Sighting();
        sighting2.setPersons(personList);
        sighting2.setLocation(location2);
        sighting2.setDate(LocalDate.parse("2018-05-05", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting2);

        assertEquals(2, dao.getAllSightings().size());
        dao.removeSighting(sighting2.getSightingId());
        List<Sighting> sightingList = dao.getAllSightings();
        assertEquals(1, dao.getAllSightings().size());
    }

    @Test
    public void getSightingsByDate() {
        // person for sighting
        Person person = new Person();
        person.setName("Magneto");
        person.setDescription("Controls magnets");
        // person doesn't have powers
        person.setSuperpowers(new ArrayList<>());
        dao.addPerson(person);
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        // location for sighting
        Location location = new Location();
        location.setName("Times Square");
        location.setDescription("The Crossroads of the World");
        location.setStreet("Broadway");
        location.setCity("New York City");
        location.setState("NY");
        location.setCountry("USA");
        location.setLongitude(-73.985197);
        location.setLatitude(40.758888);
        dao.addLocation(location);

        Sighting sighting = new Sighting();
        sighting.setPersons(personList);
        sighting.setLocation(location);
        sighting.setDate(LocalDate.parse("2018-05-05", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting);

        // person2 for sighting2
        Person person2 = new Person();
        person2.setName("Charles Xavier");
        person2.setDescription("X-Men leader");
        // create powers for person and add to database
        List<Superpower> powerList = new ArrayList<>();
        Superpower telekinesis = new Superpower();
        telekinesis.setName("Telekinesis");
        telekinesis.setDescription("Can use mind to physically affect objects");
        dao.addSuperpower(telekinesis);
        powerList.add(telekinesis);
        Superpower telepathy = new Superpower();
        telepathy.setName("Telepathy");
        telepathy.setDescription("Can communicate with mind");
        dao.addSuperpower(telepathy);
        powerList.add(telepathy);
        person2.setSuperpowers(powerList);
        dao.addPerson(person2);
        personList.add(person2);

        // location2 for sighting2
        Location location2 = new Location();
        location2.setName("Churchill Downs");
        location2.setDescription("Horse racing track");
        location2.setStreet("700 Central Ave");
        location2.setCity("Louisville");
        location2.setState("KY");
        location2.setCountry("USA");
        location2.setLongitude(-85.770038);
        location2.setLatitude(38.202973);
        dao.addLocation(location2);

        Sighting sighting2 = new Sighting();
        sighting2.setPersons(personList);
        sighting2.setLocation(location2);
        sighting2.setDate(LocalDate.parse("2018-05-05", DateTimeFormatter.ISO_DATE));
        dao.addSighting(sighting2);

        // both sightings have same date, should return 2 sightings
        assertEquals(2, dao.getSightingsByDate(LocalDate.parse("2018-05-05", DateTimeFormatter.ISO_DATE)).size());
    }
}
