package coursework1;

import coursework1.abonements.Abonement;

public class Application {
    public static void main(String[] args) {


        FitnessClub fitnessClub = new FitnessClub();
        String [] purpose = new String[] {"swimmingPool", "fitnessRoom", "groupClasses"};



        int i = 0;
        while (i<20) {
            fitnessClub.hello(Abonement.getAbonement(), purpose[(int) (Math.random()*3)]);
            i++;
        }
        System.out.println(fitnessClub);
    }
}
