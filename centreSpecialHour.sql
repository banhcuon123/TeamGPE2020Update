CREATE DEFINER=`root`@`localhost` PROCEDURE `centerSpecialHour`(
in in_city_id char(32),
in in_centre_id char(32),
out return_message char(100))
proc:BEGIN
	IF not EXISTS (SELECT * FROM cities WHERE city_id like in_city_id) THEN
		set return_message := "CityId does not exist";
		select return_message;
		leave proc;
	END IF;
    IF not EXISTS (SELECT * FROM sport_centres WHERE centre_id like in_centre_id) THEN
		set return_message := "CenterId does not exist";
		select return_message;
		leave proc;
	END IF;	
    if not exists (select * from sport_centres where (city_id like in_city_id and centre_id like in_centre_id)) then
		set return_message := "CenterId does not exist in cityId";
		select return_message;
		leave proc;
	end if;
	select * from special_day where (city_id like in_city_id and centre_id like in_centre_id);
END