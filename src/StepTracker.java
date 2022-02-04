import java.util.*;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<Integer, MonthData>();
     int targetStep = 10000;

    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1){
                int step = scanner.nextInt();
                stepTracker.saveStep(step);
            }else if (command == 2){
                System.out.println("Выберите месяц");
                printMonth();
                int monthNumber = scanner.nextInt();
                MonthData monthData = stepTracker.monthToData.get(monthNumber - 1);
                System.out.println("Введите день");
                int day = scanner.nextInt();
                while (true){
                    System.out.println("Введите количество шагов");
                    int step = scanner.nextInt();
                    if (step > 0){
                        monthData.saveSteps(day,step);
                        System.out.println(monthData.dayToStep);
                        break;
                    }else{
                       System.out.println("Количество шагов не може быть отрицательным!");
                    }
                }System.out.println(monthData);
            }else if (command == 3){
                System.out.println("Выберите мясяц");
                int monthNumber = scanner.nextInt();
                MonthData monthData = stepTracker.monthToData.get(monthNumber - 1);
                monthData.printStatistic();
            }else if (command == 0){
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Такой команды нет.");
            }

        }
    }
     public void saveStep (int step){
        while (true){
            if (step >= 0){
                targetStep = step;
                break;
            }else{
                System.out.println("Цель по количеству шаго за день не может быть отрицательной");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Введите цель по количеству шагов в день");
        System.out.println("2 - Введите пройденное количества шагов за день");
        System.out.println("3 - Вывод статистики за определённый месяц");
        System.out.println("0 - Выход");
    }

    public StepTracker(){
        for (int i = 0; i < 12; i++){
            monthToData.put(i, new MonthData());
        }
    }

     class MonthData {
        HashMap<Integer, Integer> dayToStep = new HashMap<>();
         Converter converter = new Converter();

        public MonthData() {
            for (int i = 1; i <= 30; i++) {
                dayToStep.put(i, 0);
            }
        }

        public void saveSteps (int day, int step){
            dayToStep.put(day, step);
        }

        public void printStatistic (){
            int seriesOfVictories = 0;
            int saveVictori = 0;
            int totalStepsInMonth = 0;
            for (int day : dayToStep.keySet()){
                System.out.print(day + " день" + ": " + dayToStep.get(day) + ", ");
            }
            for (int step : dayToStep.values()){
                totalStepsInMonth += step;
                if(step >= targetStep){
                    saveVictori += 1;
                    if(saveVictori > seriesOfVictories){
                        seriesOfVictories = saveVictori;
                    }
                }else {
                    saveVictori = 0;
                }
            }System.out.println();
             System.out.println("Обшее количество шагов: " + totalStepsInMonth);
            System.out.println("Среднее количество шагов: " + totalStepsInMonth / 30);
            System.out.println("Пройденная дистанция: " + converter.convertStepInKm(totalStepsInMonth) + "(km)");
            System.out.println("Количество сожжённых килокалорий: " + converter.convertKilocalories(totalStepsInMonth));
            System.out.println("Лучшая серия: " + seriesOfVictories);
        }

    }

    public static void printMonth(){
        System.out.println("1. Январь");
        System.out.println("2. Февраль");
        System.out.println("3. Март");
        System.out.println("4. Апрель");
        System.out.println("5. Май");
        System.out.println("6. Июнь");
        System.out.println("7. Июль");
        System.out.println("8. Август");
        System.out.println("9. Сентябрь");
        System.out.println("10. Октябрь");
        System.out.println("11. Ноябрь");
        System.out.println("12. Декабрь");
    }

}