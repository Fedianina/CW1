package coursework1.abonements;

import java.time.LocalTime;

public enum AbonementsType {

    ONE_TIME_SUBSCRIPTION(new String[]{"swimmingPool", "fitnessRoom"}, (LocalTime.of(22,00))  ),
    DAILY_SUBSCRIPTION(new String[]{"fitnessRoom", "groupClasses"},(LocalTime.of(16,00))),
    ALL_INCLUSIVE(new String[]{"swimmingPool", "fitnessRoom", "groupClasses"}, (LocalTime.of(22,00)));

    //*private boolean swimmingPool, fitnessRoom, groupClasses;
    private String [] zones;

    private LocalTime timeOn  = LocalTime.of(8,00);
    private LocalTime timeOf;


    private AbonementsType(String[] zones, LocalTime timeOf) {
        this.timeOf = timeOf;
        this.zones = zones;
    }

    public LocalTime getTimeOf() {
        return timeOf;
    }

    public String[] getZones() {
        return zones;
    }
}
