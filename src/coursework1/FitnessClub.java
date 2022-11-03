package coursework1;

import coursework1.abonements.Abonements;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import coursework1.abonements.AbonementsType;


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

    Abonements[] swimmingPool = new Abonements[20];
    Abonements[] fitnessRoom = new Abonements[20];
    Abonements[] groupClasses = new Abonements[20];
    //String [] purposeOfTheVisit = new String []{"swimming", "fitness", "group"};


    private Abonements[] getSwimmingPool() {
        return swimmingPool;
    }

    private Abonements[] getFitnessRoom() {
        return fitnessRoom;
    }

    private Abonements[] getGroupClasses() {
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
    private boolean checkDataAbonement(Abonements abonements) {
        System.out.println("Добрый день, позвольте проверить срок действия Вашего абонемента");
        if (isOpenClose()) {
            if (abonements.getEndRegistrationDate().isAfter(LocalDate.now())) {
                System.out.println("Срок дейстия Вашего абонемента в порядке");
                return true;
            }
            System.out.println("Ваш абонемент просрочен");
            return false;
        }
        return false;
    }

    // проверка на соответствие времени посещения

    private boolean checkTime(Abonements abonements) {
        if (checkDataAbonement(abonements)) {
            if (LocalTime.now().isBefore(abonements.getAbonementsType().getTimeOf())) {
                System.out.println("Вы пришли вовремя!");
                return true;
            }
            System.out.println("Время Вашего прихода не соответствует времени посещения. Время посещения по Вашему абонементу органичено " + abonements.getAbonementsType().getTimeOf());
        }
        return false;
    }

    private boolean checkAbonementType(Abonements abonements) {
        if (checkTime(abonements)) {
            System.out.println("Проверяю тип Вашего абонемента");
            String type = abonements.getAbonementsType().name();
            System.out.println("Тип Вашего абонемента - " + type + " Какой из залов Вы хотели бы посетить?");
            int room = (int) (1 + Math.random() * 3);
            switch (room) {
                case 1 -> {
                    System.out.println("Бассейн? прекрасный выбор!");
                    abonements.setDesiredPlaceOfVisit("swimmingPool");
                    if (abonements.getAbonementsType().isSwimmingPool()) {
                        System.out.println("У Вас есть возможность посетить бассейн");
                        return true;
                    }
                    System.out.println("К сожалению у Вас нет возможности посещать бассейн");
                    return false;
                }
                case 2 -> {
                    System.out.println("Тренажеры? прекрасный выбор!");
                    abonements.setDesiredPlaceOfVisit("fitnessRoom");
                    if (abonements.getAbonementsType().isFitnessRoom()) {
                        System.out.println("У Вас есть возможность посетить тренажеры");
                        return true;
                    }
                    System.out.println("К сожалению у Вас нет возможности посещать тренажеры");
                    return false;
                }
                case 3 -> {
                    System.out.println("Групповые занятия? прекрасный выбор!");
                    abonements.setDesiredPlaceOfVisit("groupClasses");
                    if (abonements.getAbonementsType().isGroupClasses()) {
                        System.out.println("У Вас есть возможность посетить групповые занятия");
                        return true;
                    }
                    System.out.println("К сожалению у Вас нет возможности посещать групповые занятия");
                    return false;
                }
            }
        }
        return false;
    }

    //проверка свободной ячейке в массиве
    public void addToTheList(Abonements abonements) {
        if (checkAbonementType(abonements)) {
            if (abonements.getDesiredPlaceOfVisit().equalsIgnoreCase("swimmingPool")) {
                if (swimmingPool[swimmingPool.length - 1] == null) {
                    for (int i = 0; i < swimmingPool.length; i++) {
                        if (swimmingPool[i] == null) {
                            swimmingPool[i] = abonements;
                            System.out.println("Можете проходить в бассейн");
                            return;
                        }
                    }
                }
            }
        }
        if (abonements.getDesiredPlaceOfVisit().equalsIgnoreCase("fitnessRoom")) {
            if (fitnessRoom[fitnessRoom.length - 1] == null) {
                for (int i = 0; i < fitnessRoom.length; i++) {
                    if (fitnessRoom[i] == null) {
                        fitnessRoom[i] = abonements;
                        System.out.println("Можете проходить в тренажерный зал");
                        return;
                    }
                }
            }
        }

        if (abonements.getDesiredPlaceOfVisit().equalsIgnoreCase("groupClasses")) {
            if (groupClasses[groupClasses.length - 1] == null) {
                for (int i = 0; i < groupClasses.length; i++) {
                    if (groupClasses[i] == null) {
                        groupClasses[i] = abonements;
                        System.out.println("Можете проходить на групповые занятия");
                        return;
                    }
                }
            }
        }
    }
    private void endDay (){
        openClose = false;
        for (Abonements abonements : swimmingPool) {
            abonements = null;
        }
        for (Abonements abonements : fitnessRoom) {
            abonements = null;

        }
        for (Abonements abonements : groupClasses ) {
            abonements = null;
        }
    }

    private void startDay(){
        openClose = true;
    }
}


