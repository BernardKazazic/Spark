package rokvp.dz04.zad01;

public class SensorscopeReading {
    private final String id;
    private final Integer year;
    private final Integer month;
    private final Integer day;
    private final Integer hour;
    private final Integer minute;
    private final Integer second;
    private final Double timeSinceEpoch;
    private final Double sequenceNum;
    private final Double confSamplingTime;
    private final Double dataSamplingTime;
    private final Double radioDutyCycle;
    private final Double radioTransPower;
    private final Double radioTransFrequency;
    private final Double primaryBuffVoltage;
    private final Double secondaryBuffVoltage;
    private final Double solarPanelCurrent;
    private final Double globalCurrent;
    private final Double energySource;

    public SensorscopeReading(String id, Integer year, Integer month, Integer day, Integer hour,
                              Integer minute, Integer second, Double timeSinceEpoch, Double sequenceNum,
                              Double confSamplingTime, Double dataSamplingTime, Double radioDutyCycle,
                              Double radioTransFrequency, Double radioTransPower, Double primaryBuffVoltage,
                              Double secondaryBuffVoltage, Double solarPanelCurrent, Double globalCurrent,
                              Double energySource) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.timeSinceEpoch = timeSinceEpoch;
        this.sequenceNum = sequenceNum;
        this.confSamplingTime = confSamplingTime;
        this.dataSamplingTime = dataSamplingTime;
        this.radioDutyCycle = radioDutyCycle;
        this.radioTransPower = radioTransPower;
        this.radioTransFrequency = radioTransFrequency;
        this.primaryBuffVoltage = primaryBuffVoltage;
        this.secondaryBuffVoltage = secondaryBuffVoltage;
        this.solarPanelCurrent = solarPanelCurrent;
        this.globalCurrent = globalCurrent;
        this.energySource = energySource;
    }

    public String getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public Integer getSecond() {
        return second;
    }

    public Double getTimeSinceEpoch() {
        return timeSinceEpoch;
    }

    public Double getSequenceNum() {
        return sequenceNum;
    }

    public Double getConfSamplingTime() {
        return confSamplingTime;
    }

    public Double getDataSamplingTime() {
        return dataSamplingTime;
    }

    public Double getRadioDutyCycle() {
        return radioDutyCycle;
    }

    public Double getRadioTransPower() {
        return radioTransPower;
    }

    public Double getRadioTransFrequency() {
        return radioTransFrequency;
    }

    public Double getPrimaryBuffVoltage() {
        return primaryBuffVoltage;
    }

    public Double getSecondaryBuffVoltage() {
        return secondaryBuffVoltage;
    }

    public Double getSolarPanelCurrent() {
        return solarPanelCurrent;
    }

    public Double getGlobalCurrent() {
        return globalCurrent;
    }

    public Double getEnergySource() {
        return energySource;
    }

    @Override
    public String toString() {
        return id + "," + year + "," + month  + "," + day + "," + hour + "," + minute + "," + second + "," +
                timeSinceEpoch + "," + sequenceNum + "," + confSamplingTime + "," + dataSamplingTime + "," +
                radioDutyCycle + "," + radioTransPower + "," + radioTransFrequency + "," +
                primaryBuffVoltage + "," + secondaryBuffVoltage + "," + solarPanelCurrent  + "," +
                globalCurrent  + "," + energySource + "\n";
    }
}
