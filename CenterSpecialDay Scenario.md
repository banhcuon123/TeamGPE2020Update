# Center's Opening hour Data

### Weekdays simplify

	- Mon   2
	- Tue   3
	- Wed   4
	- Thu   5
	- Fri   6
	- Sat   7
	- Sun   1

### City

	- city1   (center1) (center2)
	- city2   (center3)
	- city3   (center4) (center5) (center6)
	- city4   (center7)
	- city5   no center

### Center special day
	
	- city1:   center1:   Sat, 10:00 - 21:00
				          Sun, 10:00 - 19:00
	           center2:   Sat, 08:00 - 22:00
	- city2:   center3:   Mon, 10:00 - 21:00
	- city3:   center4:   Tue, 07:00 - 12:00
			              Thu, 13:00 - 21:00
			   center5:   Mon, 08:00 - 20:00
			              Sat, 08:00 - 20:00
	- city4:   center7:   Sat, 16:00 - 21:00
___

/* city1, center1 */

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center1', '{"t2": "", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "1000-2100", "t1": "1000-1900"}');
___

/* city1, center2 */

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center2', '{"t2": "", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "0800-2200", "t1": ""}');
___

/* city2, center3

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city2', 'center3', '{"t2": "1000-2100", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "", "t1": ""}');
___

/* city3, center4 */

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city3', 'center4', '{"t2": "", "t3": "0700-1200", "t4": "", "t5": "1300-2100", "t6": "", "t7": "", "t1": ""}');
___

/* city3, center5 */

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city3', 'center5', '{"t2": "0800-2000", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "0800-2000", "t1": ""}');
___

/* city 4, center 7 */

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city4', 'center7', '{"t2": "", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "1600-2100", "t1": ""}');
___
...
___
# Full code

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center1', '{"t2": "", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "1000-2100", "t1": "1000-1900"}');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city1', 'center2', '{"t2": "", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "0800-2200", "t1": ""}');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city2', 'center3', '{"t2": "1000-2100", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "", "t1": ""}');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city3', 'center4', '{"t2": "", "t3": "0700-1200", "t4": "", "t5": "1300-2100", "t6": "", "t7": "", "t1": ""}');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city3', 'center5', '{"t2": "0800-2000", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "0800-2000", "t1": ""}');

INSERT INTO Special_day (city_id, centre_id, specialValue) VALUES ('city4', 'center7', '{"t2": "", "t3": "", "t4": "", "t5": "", "t6": "", "t7": "1600-2100", "t1": ""}');