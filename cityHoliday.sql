DROP TABLE IF EXISTS Holiday;
CREATE TABLE Holiday(
	city_id char (32) NOT NULL PRIMARY KEY,
    holidayDate JSON NOT NULL,
    constraint holiday_city_id_fk foreign key (city_id) references Cities(city_id)
);