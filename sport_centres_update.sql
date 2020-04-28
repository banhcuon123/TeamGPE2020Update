CREATE TABLE Sport_Centres(
   centre_id char(32) NOT NULL,
   city_id char(32) NOT NULL,
   minimal_timeslot int NOT NULL DEFAULT 45,
   maximum_timeslot int NOT NULL DEFAULT 90,
   constraint sport_centres_fk foreign key (city_id) references cities(city_id),
   constraint sport_centres_pk primary key (centre_id, city_id)
);
