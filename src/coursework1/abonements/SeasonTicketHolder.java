package coursework1.abonements;

public class SeasonTicketHolder {

    private final String nameOwners;
    private final String surnameOwners;
    private final int yearOfBirth;

    public SeasonTicketHolder(String nameOwners, String surnameOwners, int yearOfBirth) {
        this.nameOwners = nameOwners;
        this.surnameOwners = surnameOwners;
        this.yearOfBirth = yearOfBirth;
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

    public static SeasonTicketHolder getHolder () {
        String nameOwners = Constans.NAME[(int) (Math.random()*Constans.NAME.length)];
        String surnameOwners = Constans.SURNAME[(int) (Math.random()*Constans.SURNAME.length)];
        return new SeasonTicketHolder(nameOwners, surnameOwners, (int) (Math.random()*70 +15));
    }

    @Override
    public String toString() {
        return "SeasonTicketHolder{" +
                "nameOwners='" + nameOwners + '\'' +
                ", surnameOwners='" + surnameOwners + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
