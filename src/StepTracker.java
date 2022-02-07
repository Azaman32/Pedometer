import java.util.*;

public class StepTracker {
    HashMap<Integer, MonthData> monthToData = new HashMap<>();
    int targetStep = 10000;

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void saveStep(int step) {
        targetStep = step;
    }

    public MonthData getMonthData(int number) {
        return monthToData.get(number - 1);
    }

    public void printMonth() {
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