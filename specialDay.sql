DROP TABLE IF EXISTS Special_day;
CREATE TABLE Special_day(
	city_id char(32) NOT NULL,
	centre_id char(32) NOT NULL,
	specialValue JSON NOT NULL,
    constraint special_day_city_id_fk foreign key (city_id) references cities(city_id),
    constraint special_day_centre_id_fk foreign key (centre_id) references sport_centres(centre_id)
);