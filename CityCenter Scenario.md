# City and Center Data

### City

	- city1   (center1) (center2)
	- city2   (center3)
	- city3   (center4) (center5) (center6)
	- city4   (center7)
	- city5   no center
___

/* city1 */

CALL createCity ("city1");

CALL createCityCenter ("center1", "city1");

CALL createCityCenter ("center2", "city1");
___

/* city2 */

CALL createCity ("city2");

CALL createCityCenter ("center3", "city2");
___

/* city3 */

CALL createCity ("city3");

CALL createCityCenter ("center4", "city3");

CALL createCityCenter ("center5", "city3");

CALL createCityCenter ("center6", "city3");
___

/* city4 */

CALL createCity ("city4");

CALL createCityCenter ("center7", "city4");
___

/* city5 */

CALL createCity ("city5");
___
...
___
#Full code

CALL createCity ("city1");

CALL createCityCenter ("center1", "city1");

CALL createCityCenter ("center2", "city1");

CALL createCity ("city2");

CALL createCityCenter ("center3", "city2");

CALL createCity ("city3");

CALL createCityCenter ("center4", "city3");

CALL createCityCenter ("center5", "city3");

CALL createCityCenter ("center6", "city3");

CALL createCity ("city4");

CALL createCityCenter ("center7", "city4");

CALL createCity ("city5");