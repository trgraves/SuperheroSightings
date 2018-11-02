use superherosighting;

-- SUPERPOWERS
INSERT INTO superpowers (name, description) VALUES ('Superhuman Strength', 'Exert force and lift weights beyond what is physically possible for a human');
INSERT INTO superpowers (name, description) VALUES ('Spider-Sense', 'Alert to danger');
INSERT INTO superpowers (name, description) VALUES ('Healing Factor', 'Accelerated healing that regenerates damaged or destroyed tissues of body');
INSERT INTO superpowers (name, description) VALUES ('Adamantium Claws', 'Retractable claws made out of adamantium');
INSERT INTO superpowers (name, description) VALUES ('Flight', 'Move through the air using various methods');
INSERT INTO superpowers (name, description) VALUES ('Magnetism Manipulation', 'Power to manipulate magnetic fields to achieve a wide range of effects');
INSERT INTO superpowers (name, description) VALUES ('Iron Man\'s Armor', 'Powered armor that gives Iron Man superhuman strength, flight, and an array of weapons.');
INSERT INTO superpowers (name, description) VALUES ('Superhuman Speed', 'Move faster than humanly possible');
INSERT INTO superpowers (name, description) VALUES ('Superhuman Durability', 'Withstand unnaturally high levels of physical harm');
INSERT INTO superpowers (name, description) VALUES ('Mjolnir', 'Thor\'s Hammer, granting him dimensional transportation, electric manipulation, flight, and weather manipulation');
INSERT INTO superpowers (name, description) VALUES ('Superhuman Senses', 'Heightened touch, sight, hearing, smell and taste');
INSERT INTO superpowers (name, description) VALUES ('Genius-level Intellect', 'Greater capacity for cognitive thought, reason, planning and problem solving');
INSERT INTO superpowers (name, description) VALUES ('Doom\'s Armor', 'Augments Doom\'s natural physical strength to superhuman levels, arsenal of high tech weaponry, and makes him nigh-indestructible.');
INSERT INTO superpowers (name, description) VALUES ('Enery Manipulation', 'Project and absorb energy in various ways');
-- INSERT INTO superpowers (name, description) VALUES ('', '');


-- HEROES/VILLAINS
INSERT INTO persons (name, description) VALUES ('Spider-Man', 'Real Name: Peter Parker. A bite from a radioactive spider triggered a mutation in Spider-Man\'s body granting him superpowers.');
INSERT INTO persons (name, description) VALUES ('Wolverine', 'Real Name: James Howlett. Mutant with adamantium skeleton and healing powers.');
INSERT INTO persons (name, description) VALUES ('Magneto', 'Real Name: Max Eisenhardt. Mutant with power to manipulate magnetic fields.');
INSERT INTO persons (name, description) VALUES ('Iron Man', 'Real Name: Tony Stark. Genius level intellect, wears powered armor suit with various abilities.');
INSERT INTO persons (name, description) VALUES ('Thor', 'Asgardian god of thunder and who possesses the enchanted hammer Mjolnir.');
INSERT INTO persons (name, description) VALUES ('Daredevil', 'Real Name: Matt Murdock. Blinded by a radioactive substance but the exposure heightened his remaining senses beyond normal human ability.');
INSERT INTO persons (name, description) VALUES ('Kingpin', 'Real Name: Wilson Grant Fisk. Criminal mastermind and tactician, master armed/unarmed combatant, and incredibly strong and durable. ');
INSERT INTO persons (name, description) VALUES ('Doctor Doom', 'Real Name: Victor Von Doom. Supervillain and archenemy of the Fantastic Four.');
-- INSERT INTO persons (name, description) VALUES ('', '');


-- PERSONS_SUPERPOWERS
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (1, 1);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (1, 2);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (1, 9);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (1, 12);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (2, 3);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (2, 4);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (3, 5);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (3, 6);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (4, 5);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (4, 7);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (5, 8);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (5, 9);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (5, 10);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (5, 5);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (6, 11);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (8, 12);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (8, 13);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (8, 14);
INSERT INTO persons_superpowers (personID, superpowerID) VALUES (8, 1);
-- INSERT INTO persons_superpowers (personID, superpowerID) VALUES (, );

-- LOCATIONS
INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('Avengers Tower', 'Headquarters of the Avengers', 'Broadway', 'New York City', 'NY', 'US', -73.984016, 40.754932);
INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('X-Mansion', 'Xavier\'s Academy for Gifted Youngsters', '1407 Graymalkin Lane', 'Salem Center', 'NY', 'US', -73.5981827, 41.3292613);
INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('Genosha', 'Republic of Genosha', null, null, null, 'Genosha', 46.460938, 19.002846);
INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('Asgard', 'The Home of the Norse Pantheon of Gods', null, null, null, null, null, null);
INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('Hell\'s Kitchen', 'Resident Hero: Daredevil', 'Clinton and Midtown West', 'New York City', 'NY', 'US',  -73.9918181, 40.7637581);
INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('Sanctum Sanctorum', 'Residence of Doctor Strange', '177A Bleecker Street', 'New York City', 'NY', 'US', 74.002881, 40.71598);
INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('Castle Doom', 'Home of Doctor Doom', null, 'Doomstadt', null, 'Latveria', 22.828426, 45.349705);
-- INSERT INTO locations (name, description, street, city, state, country, longitude, latitude) VALUES ('', '', '', '', '', '', , );

-- ORGANIZATIONS
INSERT INTO organizations (name, description, phone, email, locationID) VALUES ('Avengers', 'Earth\'s Mightiest Heroes' , '678-136-7092' , 'avengers@avengers.com', 1);
INSERT INTO organizations (name, description, phone, email, locationID) VALUES ('X-Men', 'Fight for peace and equality between normal humans and mutants' , '555-555-5555' , 'xmen@.xmencom', 2);
INSERT INTO organizations (name, description, phone, email, locationID) VALUES ('Brotherhood of Mutants', 'Terrorist organization devoted to mutant superiority over normal humans' , '111-111-1111' , 'brotherhood@mutants.com', 3);
INSERT INTO organizations (name, description, phone, email, locationID) VALUES ('Defenders', 'New York City based street-level heroes' , '444-444-4444' , 'defenders@defenders.com', 6);
INSERT INTO organizations (name, description, phone, email, locationID) VALUES ('The Hand', 'Order of evil mystical ninjas who are heavily involved in organized crime and mercenary activities' , null , null, null);
INSERT INTO organizations (name, description, phone, email, locationID) VALUES ('Parliament of Doom', 'Members consist of Dooms from other universes' , null , null, null);
-- INSERT INTO organizations (name, description, phone, email, locationID) VALUES ('', '' , '' , '@.com', );


-- PERSONS_ORGANIZATIONS
INSERT INTO persons_organizations (personID, organizationID) VALUES (1, 1);
INSERT INTO persons_organizations (personID, organizationID) VALUES (2, 2);
INSERT INTO persons_organizations (personID, organizationID) VALUES (3, 3);
INSERT INTO persons_organizations (personID, organizationID) VALUES (4, 1);
INSERT INTO persons_organizations (personID, organizationID) VALUES (5, 1);
INSERT INTO persons_organizations (personID, organizationID) VALUES (6, 4);
INSERT INTO persons_organizations (personID, organizationID) VALUES (7, 5);
INSERT INTO persons_organizations (personID, organizationID) VALUES (8, 6);
-- INSERT INTO persons_organizations (personID, organizationID) VALUES (,);

-- SIGHTINGS
INSERT INTO sightings (locationID, date) VALUES (1, '2018-10-19');
INSERT INTO sightings (locationID, date) VALUES (2, '2018-10-19');
INSERT INTO sightings (locationID, date) VALUES (3, '2018-10-19');
INSERT INTO sightings (locationID, date) VALUES (4, '2018-10-20');
INSERT INTO sightings (locationID, date) VALUES (5, '2018-10-20');
INSERT INTO sightings (locationID, date) VALUES (7, '2018-10-20');
-- INSERT INTO sightings (locationID, date) VALUES (, '');

-- SIGHTINGS_PERSONS
INSERT INTO sightings_persons (sightingID, personID) VALUES (1, 1);
INSERT INTO sightings_persons (sightingID, personID) VALUES (2, 2);
INSERT INTO sightings_persons (sightingID, personID) VALUES (3, 3);
INSERT INTO sightings_persons (sightingID, personID) VALUES (4, 5);
INSERT INTO sightings_persons (sightingID, personID) VALUES (5, 1);
INSERT INTO sightings_persons (sightingID, personID) VALUES (5, 6);
INSERT INTO sightings_persons (sightingID, personID) VALUES (5, 7);
INSERT INTO sightings_persons (sightingID, personID) VALUES (6, 8);
INSERT INTO sightings_persons (sightingID, personID) VALUES (6, 2);
-- INSERT INTO sightings_persons (sightingID, personID) VALUES (, );
