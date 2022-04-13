package rokvp.dz04.zad01;

import java.util.Calendar;
import java.util.Comparator;

public class DateComparator implements Comparator<SensorscopeReading> {

    @Override
    public int compare(SensorscopeReading o1, SensorscopeReading o2) {
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        date1.set(o1.getYear(), o1.getMonth(), o1.getDay(), o1.getHour(), o1.getMinute(), o1.getSecond());
        date2.set(o2.getYear(), o2.getMonth(), o2.getDay(), o2.getHour(), o2.getMinute(), o2.getSecond());
        return date1.compareTo(date2);
    }
}
