-- FOR TESTING PURPOSES ONLY
-- CREATE TABLE IF NOT EXISTS country (
--     country_id SERIAL PRIMARY KEY,
--     iso CHAR(2) NOT NULL,
--     name VARCHAR(100) NOT NULL
-- );

INSERT INTO country(country_id, iso, name) VALUES(1, 'AD', 'Andorra');
INSERT INTO country(country_id, iso, name) VALUES(2, 'AE', 'United Arab Emirates');
INSERT INTO country(country_id, iso, name) VALUES(3, 'AF', 'Afghanistan');
INSERT INTO country(country_id, iso, name) VALUES(4, 'AG', 'Antigua and Barbuda');
INSERT INTO country(country_id, iso, name) VALUES(5, 'AI', 'Anguilla');
INSERT INTO country(country_id, iso, name) VALUES(6, 'AL', 'Albania');
INSERT INTO country(country_id, iso, name) VALUES(7, 'AM', 'Armenia');
INSERT INTO country(country_id, iso, name) VALUES(8, 'AO', 'Angola');
INSERT INTO country(country_id, iso, name) VALUES(9, 'AR', 'Argentina');
INSERT INTO country(country_id, iso, name) VALUES(10, 'AT', 'Austria');
INSERT INTO country(country_id, iso, name) VALUES(11, 'AU', 'Australia');
INSERT INTO country(country_id, iso, name) VALUES(12, 'BD', 'Bangladesh');
INSERT INTO country(country_id, iso, name) VALUES(13, 'BE', 'Belgium');
INSERT INTO country(country_id, iso, name) VALUES(14, 'BR', 'Brazil');
INSERT INTO country(country_id, iso, name) VALUES(15, 'CA', 'Canada');
INSERT INTO country(country_id, iso, name) VALUES(16, 'CH', 'Switzerland');
INSERT INTO country(country_id, iso, name) VALUES(17, 'CL', 'Chile');
INSERT INTO country(country_id, iso, name) VALUES(18, 'CN', 'China');
INSERT INTO country(country_id, iso, name) VALUES(19, 'CO', 'Colombia');
INSERT INTO country(country_id, iso, name) VALUES(20, 'CZ', 'Czech Republic');
INSERT INTO country(country_id, iso, name) VALUES(21, 'DE', 'Germany');
INSERT INTO country(country_id, iso, name) VALUES(22, 'DK', 'Denmark');
INSERT INTO country(country_id, iso, name) VALUES(23, 'EG', 'Egypt');
INSERT INTO country(country_id, iso, name) VALUES(24, 'ES', 'Spain');
INSERT INTO country(country_id, iso, name) VALUES(25, 'FI', 'Finland');
INSERT INTO country(country_id, iso, name) VALUES(26, 'FR', 'France');
INSERT INTO country(country_id, iso, name) VALUES(27, 'GH', 'Ghana');
INSERT INTO country(country_id, iso, name) VALUES(28, 'GB', 'United Kingdom');
INSERT INTO country(country_id, iso, name) VALUES(29, 'GR', 'Greece');
INSERT INTO country(country_id, iso, name) VALUES(30, 'HU', 'Hungary');
INSERT INTO country(country_id, iso, name) VALUES(31, 'ID', 'Indonesia');
INSERT INTO country(country_id, iso, name) VALUES(32, 'IE', 'Ireland');
INSERT INTO country(country_id, iso, name) VALUES(33, 'IL', 'Israel');
INSERT INTO country(country_id, iso, name) VALUES(34, 'IN', 'India');
INSERT INTO country(country_id, iso, name) VALUES(35, 'IT', 'Italy');
INSERT INTO country(country_id, iso, name) VALUES(36, 'JP', 'Japan');
INSERT INTO country(country_id, iso, name) VALUES(37, 'KE', 'Kenya');
INSERT INTO country(country_id, iso, name) VALUES(38, 'KR', 'South Korea');
INSERT INTO country(country_id, iso, name) VALUES(39, 'MX', 'Mexico');
INSERT INTO country(country_id, iso, name) VALUES(40, 'MY', 'Malaysia');
INSERT INTO country(country_id, iso, name) VALUES(41, 'NG', 'Nigeria');
INSERT INTO country(country_id, iso, name) VALUES(42, 'NL', 'Netherlands');
INSERT INTO country(country_id, iso, name) VALUES(43, 'NO', 'Norway');
INSERT INTO country(country_id, iso, name) VALUES(44, 'NZ', 'New Zealand');
INSERT INTO country(country_id, iso, name) VALUES(45, 'PE', 'Peru');
INSERT INTO country(country_id, iso, name) VALUES(46, 'PH', 'Philippines');
INSERT INTO country(country_id, iso, name) VALUES(47, 'PK', 'Pakistan');
INSERT INTO country(country_id, iso, name) VALUES(48, 'PL', 'Poland');
INSERT INTO country(country_id, iso, name) VALUES(49, 'PT', 'Portugal');
INSERT INTO country(country_id, iso, name) VALUES(50, 'RO', 'Romania');
INSERT INTO country(country_id, iso, name) VALUES(51, 'RU', 'Russia');
INSERT INTO country(country_id, iso, name) VALUES(52, 'SA', 'Saudi Arabia');
INSERT INTO country(country_id, iso, name) VALUES(53, 'SE', 'Sweden');
INSERT INTO country(country_id, iso, name) VALUES(54, 'SG', 'Singapore');
INSERT INTO country(country_id, iso, name) VALUES(55, 'TH', 'Thailand');
INSERT INTO country(country_id, iso, name) VALUES(56, 'TR', 'Turkey');
INSERT INTO country(country_id, iso, name) VALUES(57, 'UA', 'Ukraine');
INSERT INTO country(country_id, iso, name) VALUES(58, 'US', 'United States of America');
INSERT INTO country(country_id, iso, name) VALUES(59, 'VE', 'Venezuela');
INSERT INTO country(country_id, iso, name) VALUES(60, 'VN', 'Vietnam');
INSERT INTO country(country_id, iso, name) VALUES(61, 'ZA', 'South Africa');
SELECT setval(pg_get_serial_sequence('country', 'country_id'), (SELECT MAX(country_id) FROM country) + 1);

-- CREATE TABLE IF NOT EXISTS subdivision (
--     subdivision_id SERIAL PRIMARY KEY,
--     iso CHAR(5) PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     country_id INT NOT NULL,
--     CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES Country(country_id)
-- );

INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(1, 'NL-DR', 'Drenthe', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(2, 'NL-FL', 'Flevoland', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(3, 'NL-FR', 'Friesland', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(4, 'NL-GE', 'Gelderland', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(5, 'NL-GR', 'Groningen', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(6, 'NL-LI', 'Limburg', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(7, 'NL-NB', 'Noord-Brabant', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(8, 'NL-NH', 'Noord-Holland', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(9, 'NL-OV', 'Overijssel', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(10, 'NL-UT', 'Utrecht', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(11, 'NL-ZE', 'Zeeland', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(12, 'NL-ZH', 'Zuid-Holland', 'PROVINCE', 42);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(13, 'DE-BW', 'Baden-Württemberg', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(14, 'DE-BY', 'Bayern', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(15, 'DE-BE', 'Berlin', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(16, 'DE-BB', 'Brandenburg', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(17, 'DE-HB', 'Bremen', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(18, 'DE-HH', 'Hamburg', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(19, 'DE-HE', 'Hessen', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(20, 'DE-MV', 'Mecklenburg-Vorpommern', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(21, 'DE-NI', 'Niedersachsen', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(22, 'DE-NW', 'Nordrhein-Westfalen', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(23, 'DE-RP', 'Rheinland-Pfalz', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(24, 'DE-SL', 'Saarland', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(25, 'DE-SN', 'Sachsen', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(26, 'DE-ST', 'Sachsen-Anhalt', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(27, 'DE-SH', 'Schleswig-Holstein', 'STATE', 21);
INSERT INTO subdivision(subdivision_id, iso, name, type, country_id) VALUES(28, 'DE-TH', 'Thüringen', 'STATE', 21);
SELECT setval(pg_get_serial_sequence('subdivision', 'subdivision_id'), (SELECT MAX(subdivision_id) FROM subdivision) + 1);

-- CREATE TABLE IF NOT EXISTS city (
--     city_id SERIAL PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     subdivision_id INT,
--     country_id INT NOT NULL,
--     CONSTRAINT fk_subdivision FOREIGN KEY (subdivision_id) REFERENCES Subdivision(subdivision_id),
--     CONSTRAINT fk_country FOREIGN KEY (country_id) REFERENCES Country(country_id)
-- );

INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(1, 'Aadorp', 9, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(2, 'Aagtdorp', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(3, 'Aagtekerke', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(4, 'Aalbeek', 6, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(5, 'Aalden', 1, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(6, 'Aaldonk', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(7, 'Aalsmeer', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(8, 'Aalst (Buren)', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(9, 'Aalst (Noord-Brabant)', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(10, 'Aalst (Zaltbommel)', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(11, 'Aalsum (Noardeast-Fryslân)', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(12, 'Aalsum (Westerkwartier)', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(13, 'Aalten', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(14, 'Aam', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(15, 'Aan de Rijksweg', 6, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(16, 'Aan de Zuwe', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(17, 'Aan het Broek', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(18, 'Aardenburg', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(19, 'Aarlanderveen', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(20, 'Aarle', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(21, 'Aarle-Rixtel', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(22, 'Aartswoud', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(23, 'Aasterberg', 6, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(24, 'Abbega', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(25, 'Abbegaasterketting', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(26, 'Abbekerk', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(27, 'Abbekerkeweere', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(28, 'Abbekinderen', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(29, 'Abbenbroek', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(30, 'Abbenes', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(31, 'Abbengawier', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(32, 'Abbestede', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(33, 'Abbeweer', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(34, 'Abbewier', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(35, 'Abcoude', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(36, 'Abcoven', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(37, 'Abeltjeshuis', 9, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(38, 'Absdale', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(39, 'Abshoven', 6, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(40, 'Abtswoude', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(41, 'Achlum', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(42, 'Acht', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(43, 'Achter het Klooster', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(44, 'Achter t Hout', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(45, 'Achterberg', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(46, 'Achterbos', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(47, 'Achterbosch (Asten)', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(48, 'Achterbosch (Laarbeek)', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(49, 'Achterbroek (Noord-Brabant)', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(50, 'Achterbroek (Zuid-Holland)', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(51, 'Achterdichting (Katwoude)', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(52, 'Achterdichting (Oostzaan)', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(53, 'Achterdiep', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(54, 'Achterdijk (Noord-Brabant)', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(55, 'Achterdijk (Utrecht)', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(56, 'Achter-Drempt', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(57, 'Achtereind', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(58, 'Achterhoek (Nijkerk)', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(59, 'Achterhoek (Overijssel)', 9, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(60, 'Achter-Lindt', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(61, 'Achtersloot', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(62, 'Achterste Brug', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(63, 'Achterste Diesdonk', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(64, 'Achterste Erm', 1, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(65, 'Achterste Hees', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(66, 'Achterste Heide', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(67, 'Achterste Heikant', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(68, 'Achterste Hermalen', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(69, 'Achterste Rith', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(70, 'Achter-Thesinge', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(71, 'Achterveld (Barneveld)', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(72, 'Achterveld (Leusden)', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(73, 'Achterwetering', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(74, 'Achthoven (Leiderdorp)', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(75, 'Achthoven (Montfoort)', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(76, 'Achthoven (Vijfheerenlanden)', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(77, 'Achthuizen', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(78, 'Achtmaal', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(79, 'Achttienhoven (Utrecht)', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(80, 'Achttienhoven (Zuid-Holland)', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(81, 'Acquoy', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(82, 'Adorp', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(83, 'Aduard', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(84, 'Aduarder Voorwerk', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(85, 'Aduarderzijl', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(86, 'Aegum', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(87, 'Aekinga', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(88, 'Aerdenburg', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(89, 'Aerdenhout', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(90, 'Aerdt', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(91, 'Afferden (Gelderland)', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(92, 'Afferden (Limburg)', 6, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(93, 'Agelo', 9, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(94, 'Agodorp', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(95, 'Aijen', 6, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(96, 'Akersloot', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(97, 'Akker', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(98, 'Akkerput', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(99, 'Akkerwoude', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(100, 'Akkrum', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(101, 'Akmarijp', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(102, 'Albergen', 9, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(103, 'Alblasserdam', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(104, 'Alem', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(105, 'Alendorp', 10, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(106, 'Alinghuizen', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(107, 'Alkmaar', 8, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(108, 'Allardsoog', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(109, 'Allersma', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(110, 'Allingawier', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(111, 'Almelo', 9, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(112, 'Almen', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(113, 'Almenum', 3, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(114, 'Almere', 2, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(115, 'Almkerk', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(116, 'Alphen aan den Rijn', 12, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(117, 'Alphen (Gelderland)', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(118, 'Alphen (Noord-Brabant', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(119, 'Alphen-Oosterwijk', 7, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(120, 'Altena (Drenthe)', 1, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(121, 'Altena (Terneuzen)', 11, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(122, 'Alteveer (De Wolden)', 1, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(123, 'Alteveer (Hoogeveen)', 1, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(124, 'Alteveer (Noordenveld)', 1, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(125, 'Alteveer (Stadskanaal)', 5, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(126, 'Altforst', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(127, 'Alting', 1, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(128, 'Altweerterheide', 6, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(129, 'Alverna', 4, 42);
INSERT INTO city(city_id, name, subdivision_id, country_id) VALUES(130, 'Alvershool', 7, 42);
SELECT setval(pg_get_serial_sequence('city', 'city_id'), (SELECT MAX(city_id) FROM city) + 1);

-- CREATE TABLE IF NOT EXISTS postcode (
--     postcode_id SERIAL PRIMARY KEY,
--     code CHAR(10) NOT NULL,
--     city_id INT NOT NULL,
--     CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES City(city_id)
-- );

INSERT INTO postcode(postcode_id, code, city_id) VALUES(1, '7611BB', 1);
INSERT INTO postcode(postcode_id, code, city_id) VALUES(2, '1871AA', 2);
SELECT setval(pg_get_serial_sequence('postcode', 'postcode_id'), (SELECT MAX(postcode_id) FROM postcode) + 1);

-- CREATE TABLE IF NOT EXISTS street (
--     street_id SERIAL PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     postcode_id INT NOT NULL,
--     CONSTRAINT fk_postcode FOREIGN KEY (postcode_id) REFERENCES Postcode(postcode_id)
-- );

INSERT INTO street(street_id, name, postcode_id) VALUES(1, 'Parallelweg', 1);
INSERT INTO street(street_id, name, postcode_id) VALUES(2, 'Gerbrandtslaan', 2);
SELECT setval(pg_get_serial_sequence('street', 'street_id'), (SELECT MAX(street_id) FROM street) + 1);

-- CREATE TABLE IF NOT EXISTS address (
--   address_id SERIAL PRIMARY KEY,
--   street_id INT NOT NULL,
--   city_id INT NOT NULL
--   CONSTRAINT fk_street FOREIGN KEY (street_id) REFERENCES Street(street_id),
--   CONSTRAINT fk_city FOREIGN KEY (city_id) REFERENCES City(city_id)
-- );

INSERT INTO address(address_id, number, addition, street_id) VALUES(1, 4, '', 1);
INSERT INTO address(address_id, number, addition, street_id) VALUES(2, 8, '', 2);
SELECT setval(pg_get_serial_sequence('address', 'address_id'), (SELECT MAX(address_id) FROM address) + 1);