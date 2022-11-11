package coursework1.abonements;

import java.time.LocalDate;
import coursework1.abonements.SeasonTicketHolder;

public class Abonement {
    //Каждый абонемент хранит
    // дату регистрации (текущая дата) и
    // дату окончания регистрации.
    // Каждый абонемент хранит информацию о владельце.
    // Данные о владельце: имя, фамилия, год рождения.
    private final LocalDate registrationDate = LocalDate.now();
    private LocalDate endRegistrationDate;
    private final SeasonTicketHolder seasonTicketHolder;
    private final AbonementsType abonementsType;

    // проверки


    public Abonement(LocalDate endRegistrationDate, SeasonTicketHolder seasonTicketHolder, AbonementsType abonementsType) {
        this.endRegistrationDate = endRegistrationDate;
        this.abonementsType = abonementsType;
        this.seasonTicketHolder = seasonTicketHolder;
    }

    public void visiting() {
        if (this.abonementsType== AbonementsType.ONE_TIME_SUBSCRIPTION){
            this.endRegistrationDate = LocalDate.now();
        }
    }

    public SeasonTicketHolder getSeasonTicketHolder() {
        return seasonTicketHolder;
    }

    public LocalDate getEndRegistrationDate() {
        return endRegistrationDate;
    }

    public AbonementsType getAbonementsType() {
        return abonementsType;
    }


    @Override
    public String toString() {
        return "Abonement{" +
                "registrationDate=" + registrationDate +
                ", endRegistrationDate=" + endRegistrationDate +
                ", seasonTicketHolder=" + seasonTicketHolder +
                ", abonementsType=" + abonementsType +
                '}';
    }


    public static Abonement getAbonement(){
        SeasonTicketHolder.getHolder();
        LocalDate date = LocalDate.now();
        date = date.plusDays((int) (Math.random()*100));
        return new Abonement(date,SeasonTicketHolder.getHolder(), AbonementsType.values()[(int) (Math.random()*AbonementsType.values().length)]);

    }
}

