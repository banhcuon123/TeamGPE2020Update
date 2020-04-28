import domain.user.ProcedureStorage;

import java.sql.Date;
import java.sql.Time;
import java.util.TreeMap;
import domain.user.ProcedureStorage;
public class Slots {

    private long MINIMAL_INTERVAL = 45*60000;
    private Time open_time = Time.valueOf("07:00:00");
    private Time close_time = Time.valueOf("21:00:00");

    public TreeMap<Time, Time> getAvailableSlots(String courtId, Date date){

        TreeMap<Time, Time> oSlots = ProcedureStorage.getOccupiedTimeSlots(date, courtId);
        TreeMap<Time, Time> aSlots = new TreeMap<Time, Time>();
        if (oSlots.isEmpty()){
            aSlots.put(open_time,close_time);
            return aSlots;
        }
        int count=0; //detect when to input first and slat slot which are different
        Time previousKey = Time.valueOf("00:00:00"); //declare start_time to the previous slot
        for (Time i: oSlots.keySet()){
            if (count == 0){
                aSlots.put(open_time, i);
                previousKey = i;
                count++;;
            }
            else{
                aSlots.put(oSlots.get(previousKey), i);
                previousKey = i;
                count++;
            }
            if (count == oSlots.keySet().size()){
                aSlots.put(oSlots.get(i), close_time);
            }

        }
        return filter(aSlots);
    }

    public TreeMap<Time, Time> filter(TreeMap<Time, Time> slots){
        TreeMap<Time, Time> tmpSlots = new TreeMap<>();
        for (Time i: slots.keySet()){
            long e =slots.get(i).getTime();
            long s =i.getTime();

            if ( e-s < MINIMAL_INTERVAL){
                tmpSlots.put(i, slots.get(i));
            }
        }
        for (Time i: tmpSlots.keySet()) {
            slots.remove(i);
        }
        return slots;
    }

}