package coursework1.abonements;

import java.time.LocalTime;

public enum AbonementsType {

    ONE_TIME_SUBSCRIPTION(true, true, false, (LocalTime.of(22,00))  ),
    DAILY_SUBSCRIPTION(false, true, true, (LocalTime.of(16,00))),
    ALL_INCLUSIVE(false, true, true, (LocalTime.of(22,00)));

    private boolean swimmingPool, fitnessRoom, groupClasses;

    private LocalTime timeOn  = LocalTime.of(8,00);
    private LocalTime timeOf;


    AbonementsType(boolean swimmingPool, boolean fitnessRoom, boolean groupClasses, LocalTime timeOf) {
        this.swimmingPool = swimmingPool;
        this.fitnessRoom = fitnessRoom;
        this.groupClasses = groupClasses;
        this.timeOf = timeOf;

    }

    public LocalTime getTimeOf() {
        return timeOf;
    }

    public boolean isSwimmingPool() {
        return swimmingPool;
    }

    public boolean isFitnessRoom() {
        return fitnessRoom;
    }

    public boolean isGroupClasses() {
        return groupClasses;
    }
}
