package coursework1;

import coursework1.abonements.Abonements;

public class Application {
    public static void main(String[] args) {


        FitnessClub fitnessClub = new FitnessClub();


        int i = 0;
        while (i<20) {
            fitnessClub.addToTheList(Abonements.getAbonement());
            System.out.println(fitnessClub);
            i++;
        }
    }
}
