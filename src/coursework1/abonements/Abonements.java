package coursework1.abonements;

import java.time.LocalDate;

public class Abonements {
    //Каждый абонемент хранит
    // дату регистрации (текущая дата) и
    // дату окончания регистрации.
    // Каждый абонемент хранит информацию о владельце.
    // Данные о владельце: имя, фамилия, год рождения.
    private final LocalDate registrationDate = LocalDate.now();
    private LocalDate endRegistrationDate;
    private final String nameOwners;
    private final String surnameOwners;
    private final int yearOfBirth;
    private final AbonementsType abonementsType;
    private String desiredPlaceOfVisit = "";

    // проверки

    public Abonements(LocalDate endRegistrationDate, String nameOwners, String surnameOwners, int yearOfBirth, AbonementsType abonementsType) {
        this.endRegistrationDate = endRegistrationDate;
        this.nameOwners = nameOwners;
        this.surnameOwners = surnameOwners;
        this.yearOfBirth = yearOfBirth;
        this.abonementsType = abonementsType;
    }

    public void visiting() {
        if (this.abonementsType== AbonementsType.ONE_TIME_SUBSCRIPTION){
            this.endRegistrationDate = LocalDate.now();
        }
    }

    public String getNameOwners() {
        return nameOwners;
    }

    public String getSurnameOwners() {
        return surnameOwners;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public LocalDate getEndRegistrationDate() {
        return endRegistrationDate;
    }

    public AbonementsType getAbonementsType() {
        return abonementsType;
    }

    public String getDesiredPlaceOfVisit() {
        return desiredPlaceOfVisit;
    }

    @Override
    public String toString() {
        return "Abonements{" +
                "registrationDate=" + registrationDate +
                ", endRegistrationDate=" + endRegistrationDate +
                ", nameOwners='" + nameOwners + '\'' +
                ", surnameOwners='" + surnameOwners + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", abonementsType=" + abonementsType +
                '}';
    }

    public void setDesiredPlaceOfVisit(String desiredPlaceOfVisit) {
        this.desiredPlaceOfVisit = desiredPlaceOfVisit;
    }

    public static Abonements getAbonement(){
        String nameOwners = Constans.NAME[(int) (Math.random()*Constans.NAME.length)];
        String surnameOwners = Constans.SURNAME[(int) (Math.random()*Constans.SURNAME.length)];
        LocalDate date = LocalDate.now();
        date = date.plusDays((int) (Math.random()*100));
        return new Abonements(date, nameOwners, surnameOwners, (int) (Math.random()*70 +15), AbonementsType.values()[(int) (Math.random()*AbonementsType.values().length)]);

    }
}
