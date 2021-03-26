INSERT INTO state_table (state_id, state_name, state_abbreviation)
VALUES (1, 'Bahia', 'BA'),
       (2, 'São Paulo', 'SP'),
       (3, 'Minas Gerais', 'MG'),
       (4, 'Pernambuco', 'PE'),
       (5, 'Rio de Janeiro', 'RJ'),
       (6, 'Paraná', 'PR');

INSERT INTO city_table (city_id, city_name, state_id)
VALUES (1, 'Eunápolis', 1),
       (2, 'Porto Seguro', 1),
       (3, 'Itabela', 1),
       (4, 'Itabuna', 1),
       (5, 'Salvador', 1),
       (6, 'Cornélio Procópio', 6);

INSERT INTO vaccine_table (vaccine_id, vaccine_name, vaccine_origin)
VALUES (1, 'Pfizer-BioNTech', 'United States'),
       (2, 'CoronaVac', 'China'),
       (3, 'Oxford', 'England');

INSERT INTO report_table (report_id, report_date, report_total, city_id,
                          vaccine_id)
VALUES (1, '2021-03-26', 111, 1, 1),
       (2, '2021-03-27', 222, 2, 2),
       (3, '2021-03-28', 333, 3, 3),
       (4, '2021-03-29', 444, 4, 1);
