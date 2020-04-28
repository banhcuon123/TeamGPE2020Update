DROP DATABASE IF EXISTS booking_app;
CREATE DATABASE booking_app;
USE booking_app;

DROP TABLE IF EXISTS Customer;
CREATE TABLE Customer(
  customer_id char(32) NOT NULL PRIMARY KEY
);
DROP TABLE IF EXISTS Cities;
CREATE TABLE Cities(
  city_id char(32) NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS Sport_Centres;
CREATE TABLE Sport_Centres(
   centre_id char(32) NOT NULL,
   city_id char(32) NOT NULL,
   minimal_timeslot int NOT NULL DEFAULT 45,
   constraint sport_centres_fk foreign key (city_id) references cities(city_id),
   constraint sport_centres_pk primary key (centre_id, city_id)
);

DROP TABLE IF EXISTS Staff;
CREATE TABLE Staff(
    staff_id char(32) NOT NULL PRIMARY KEY,
    city_id char(32) NOT NULL,
    centre_id char(32) NOT NULL,
    constraint staff_cityID_FK foreign key (city_id) references cities(city_id),
    constraint staff_centreID_FK foreign key (centre_id) references sport_centres(centre_id)
);


DROP TABLE IF EXISTS Court;
CREATE TABLE Court(
	court_id char(32) NOT NULL PRIMARY KEY,
    city_id char(32) NOT NULL,
	centre_id char(32) NOT NULL,
	status bit DEFAULT 1, -- 0:booked, 1:available
	CONSTRAINT court_centreID_fk FOREIGN KEY (centre_id) REFERENCES Sport_Centres(centre_id),
    constraint court_cityID_fk foreign key (city_id) references Sport_Centres(city_id)
	
);

DROP TABLE IF EXISTS Holiday;
CREATE TABLE Holiday(
	city_id char (32) NOT NULL,
    holidayDate JSON NOT NULL,
    constraint holiday_city_id_fk foreign key (city_id) references Cities(city_id)
);

DROP TABLE IF EXISTS Special_day;
CREATE TABLE Special_day(
	city_id char(32) NOT NULL,
	centre_id char(32) NOT NULL,
	specialValue JSON NOT NULL,
    constraint special_day_city_id_fk foreign key (city_id) references cities(city_id),
    constraint special_day_centre_id_fk foreign key (centre_id) references sport_centres(centre_id)
);

DROP TABLE IF EXISTS Booking;
CREATE TABLE Booking(
  booking_id char(32) NOT NULL PRIMARY KEY,
  booking_date timestamp NOT NULL,
  valid_from DATETIME NOT NULL,
  valid_to DATETIME NOT NULL,
  court char(32) NOT NULL,
  city_id char(32) NOT NULL,
  centre_id char(32) NOT NULL,
  customer char(32) NOT NULL,
  status BOOLEAN default null ,
  CONSTRAINT customer_fk FOREIGN KEY (customer) REFERENCES Customer (customer_id),
  CONSTRAINT court_fk FOREIGN KEY (court) REFERENCES court(court_id),
	constraint city_id_fk foreign key (city_id) references cities(city_id),
    constraint centre_id_fk foreign key (centre_id) references sport_centres(centre_id)
);

DROP TABLE IF EXISTS Booked_Court;
CREATE TABLE Booked_Court(
  booking_id char(32) NOT NULL,
  court_id char(32) NOT NULL,
  CONSTRAINT booked_bookingID_fk
      FOREIGN KEY (booking_id) REFERENCES Booking(booking_id),
  CONSTRAINT booked_courtID_fk 
      FOREIGN KEY (court_id) REFERENCES Court(court_id),
  CONSTRAINT booked_PK PRIMARY KEY (booking_id, court_id)
);
 
DROP TABLE IF EXISTS timeslot;
CREATE TABLE timeslot(
		centre_id char(32) not null primary key,
        minimal_timeslot int not null default 45,
        maximum_timeslot int not null default 90,
        constraint timeslot_fk foreign key (centre_id) references sport_centres(centre_id)        
);
 
insert into cities(city_id) values ('city1');
insert into sport_centres(centre_id, city_id) values ('center1','city1',45,90);
insert into sport_centres(centre_id, city_id) values ('center2','city1');
insert into sport_centres(centre_id, city_id) values ('center3','city1');
insert into sport_centres(centre_id, city_id) values ('center4','city1');
insert into sport_centres(centre_id, city_id) values ('center5','city1');
insert into sport_centres(centre_id, city_id) values ('center7','city1');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center1', '["7", "1000", "2100"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center1', '["1", "1000", "1900"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center2', '["7", "0800", "2200"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center3', '["2", "1000", "2100"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center4', '["3", "0700", "1200"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center4', '["5", "1300", "2100"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center5', '["2", "0800", "2000"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center5', '["7", "0800", "2000"]');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center7', '["7", "1600", "2100"]');



