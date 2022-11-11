package coursework1;

import coursework1.abonements.Abonement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;


public class FitnessClub {
    // бассейн, тренажерка, групповые занятия;
    //В каждой зоне (бассейн, тренажерный зал, групповые занятия) одновременно может быть зарегистрировано 20 абонементов.
    //
    //Когда фитнес клуб закрывается, клиенты покидают его (заполнить массив null элементами).
    //
    //Когда клиент приходит в фитнес клуб, он сообщает желаемую зону и показывает абонемент. Поэтому перед добавлением в один из массивов, необходимо проверить можно ли по данному абонементу пройти в желаемую зону, если посетитель не может пройти, необходимо сообщить ему причину.
    //
    //Посетитель не может пройти:
    //
    //если абонемент просрочен,
    //если он пытается пройти в зону, которая не разрешена по его абонементу,
    //если в зоне нет свободных мест.
    boolean openClose = true;

   private Abonement[] swimmingPool = new Abonement[20];
    private Abonement[] fitnessRoom = new Abonement[20];
    private Abonement[] groupClasses = new Abonement[20];
    //String [] purposeOfTheVisit = new String []{"swimming", "fitness", "group"};


    private Abonement[] getSwimmingPool() {
        return swimmingPool;
    }

    private Abonement[] getFitnessRoom() {
        return fitnessRoom;
    }

    private Abonement[] getGroupClasses() {
        return groupClasses;
    }

    @Override
    public String toString() {
        return "FitnessClub{" +
                ", swimmingPool=" + Arrays.toString(swimmingPool) +
                ", fitnessRoom=" + Arrays.toString(fitnessRoom) +
                ", groupClasses=" + Arrays.toString(groupClasses) +
                '}';
    }

    //проверка на время рабооты центра
    private boolean isOpenClose() {
        if (openClose) {
            if (LocalTime.now().isBefore(LocalTime.of(7, 59, 59)) && LocalTime.now().isAfter(LocalTime.of(22, 00, 00))) {
                System.out.println("Фитнес центр закрыт. Посещения возможны ежедневно с 8 утра до 10 вечера");
                return false;
            }
            return true;
        }
        return false;
    }

    //проверка на просроченность абонемента
    private boolean checkDataAbonement(Abonement abonement) {
        System.out.println("Добрый день, позвольте проверить срок действия Вашего абонемента");
        if (isOpenClose()) {
            if (abonement.getEndRegistrationDate().isAfter(LocalDate.now())) {
                System.out.println("Срок дейстия Вашего абонемента в порядке");
                return true;
            }
            System.out.println("Ваш абонемент просрочен");
            return false;
        }
        return false;
    }

    // проверка на соответствие времени посещения

    private boolean checkTime(Abonement abonement) {
        if (checkDataAbonement(abonement)) {
            if (LocalTime.now().isBefore(abonement.getAbonementsType().getTimeOf())) {
                System.out.println("Вы пришли вовремя!");
                return true;
            }
            System.out.println("Время Вашего прихода не соответствует времени посещения. Время посещения по Вашему абонементу органичено " + abonement.getAbonementsType().getTimeOf());
        }
        return false;
    }

    private boolean checkAbonementType(Abonement abonement, String purpose) {
        if (checkTime(abonement)) {
            System.out.println("Проверяю тип Вашего абонемента");
            String type = abonement.getAbonementsType().name();
            System.out.println("Тип Вашего абонемента - " + type + " Для посещения вы выбрали " + purpose);

            switch (purpose) {
                case "swimmingPool" -> {
                    System.out.println("Бассейн? прекрасный выбор!");
                    for (String zone : abonement.getAbonementsType().getZones()) {
                        if (zone.equalsIgnoreCase(purpose)) {
                            System.out.println("Все в порядке, можете проходить");
                            return true;
                        }

                    }
                    System.out.println("К сожалению у Вас нет возможности посещать бассейн");
                    return false;
                }
                case "fitnessRoom" -> {
                    System.out.println("Тренажерный зал? Прекрасный выбор!");
                    for (String zone : abonement.getAbonementsType().getZones()) {
                        if (zone.equalsIgnoreCase(purpose)) {
                            System.out.println("Все в порядке, можете проходить");
                            return true;
                        }

                    }
                    System.out.println("К сожалению у Вас нет возможности посещать тренажерный зал");
                    return false;
                }
                case "groupClasses" -> {
                    System.out.println("Групповые занятия? Прекрасный выбор!");
                    for (String zone : abonement.getAbonementsType().getZones()) {
                        if (zone.equalsIgnoreCase(purpose)) {
                            System.out.println("Все в порядке, можете проходить");
                            return true;
                        }

                    }
                    System.out.println("К сожалению у Вас нет возможности посещать групповые занятия");
                    return false;
                }
            }
        }
        return false;
    }

    //проверка свободной ячейке в массиве

    public void hello (Abonement abonement, String purpose) {
        if (checkAbonementType(abonement, purpose)) {
          addToTheList(abonement, purpose);
            }
        }
    private void addToTheList(Abonement abonement, String purpose) {
        switch (purpose) {
            case "swimmingPool" -> {
                for (int i = 0; i < swimmingPool.length; i++) {
                    if (swimmingPool[i] == null) {
                        swimmingPool[i] = abonement;
                        return;
                    }
                }
                System.out.println("К сожалению свободных мест нет");
            }
            case "fitnessRoom" -> {
                for (int i = 0; i < fitnessRoom.length; i++) {
                    if (fitnessRoom[i] == null) {
                        fitnessRoom[i] = abonement;
                        return;
                    }
                }
                System.out.println("К сожалению свободных мест нет");
            }
            case "groupClasses" -> {
                for (int i = 0; i < groupClasses.length; i++) {
                    if (groupClasses[i] == null) {
                        groupClasses[i] = abonement;
                        return;
                    }
                }
                System.out.println("К сожалению свободных мест нет");
            }
        }
    }




    private void endDay (){
        openClose = false;
        for (Abonement abonement : swimmingPool) {
            abonement = null;
        }
        for (Abonement abonement : fitnessRoom) {
            abonement = null;

        }
        for (Abonement abonement : groupClasses ) {
            abonement = null;
        }
    }

    private void startDay(){
        openClose = true;
    }
}


