package rokvp.dz04.zad02;

import java.io.Serializable;

public class USBabyNameRecord {
    private final String id;
    private final String name;
    private final String year;
    private final String gender;
    private final String state;
    private final Integer count;

    public USBabyNameRecord(String id, String name, String year, String gender, String state, Integer count) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.state = state;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public String getState() {
        return state;
    }

    public Integer getCount() {
        return count;
    }
}
