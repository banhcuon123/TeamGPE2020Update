# Holiday Data

### Holidays

	- 2020-05-01:   May Day                       (1)
	- 2020-05-08:   International Red-cross Day   (2)
	- 2020-05-15:   International Day of family   (3)
	- 2020-05-31:   World No-tobacco Day          (4)
	- 2020-01-06:   Children's Day                (5)
	- 2020-06-05:   World Environment Day         (6)

### Holidays that city closed at
	
	- city1: (1)(2)(6)
	- city2: (1)(5)(6)
	- city3: (1)(2)(3)(6)
	- city4: (1)(2)(3)(4)(5)(6)
	- city5: (4)(5)
___

/* city1 */

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city1', '{"holiday1": "20200501", "holiday2": "20200508", "holiday3": "20200605"}');
___

/* city2 */

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city2', '{"holiday1": "20200501", "holiday2": "20200106", "holiday3": "20200605"}');
___

/* city3 */

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city3', '{"holiday1": "20200501", "holiday2": "20200508", "holiday3": "20200515", "holiday4": "20200605"}');
___

/* city4 */

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city4', '{"holiday1": "20200501", "holiday2": "20200508", "holiday3": "20200515", "holiday4": "20200531", "holiday5": "20200106", "holiday6": "20200605"}');
___

/* city5 */

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city1', '{"holiday1": "20200531", "holiday2": "20200106"}');
___
...
___
# Full code

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city1', '{"holiday1": "20200501", "holiday2": "20200508", "holiday3": "20200605"}');

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city2', '{"holiday1": "20200501", "holiday2": "20200106", "holiday3": "20200605"}');

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city3', '{"holiday1": "20200501", "holiday2": "20200508", "holiday3": "20200515", "holiday4": "20200605"}');

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city4', '{"holiday1": "20200501", "holiday2": "20200508", "holiday3": "20200515", "holiday4": "20200531", "holiday5": "20200106", "holiday6": "20200605"}');

INSERT INTO cityHoliday (city_id, holidayDate) VALUES ('city1', '{"holiday1": "20200531", "holiday2": "20200106"}');