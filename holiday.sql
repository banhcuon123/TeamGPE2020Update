CREATE DEFINER=`root`@`localhost` PROCEDURE `cityHoliday`(
in in_city_id char(32),
out return_message char(100))
proc:BEGIN
	IF not EXISTS (SELECT * FROM cities WHERE city_id like in_city_id) THEN
		set return_message := "CityId does not exist";
		select return_message;
		leave proc;
	END IF;
	select * from holiday where city_id like in_city_id;
END