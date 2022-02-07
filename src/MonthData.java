import java.util.HashMap;

public class MonthData {
    HashMap<Integer, Integer> dayToStep = new HashMap<>();
    Converter converter = new Converter();

    public MonthData() {
        for (int i = 1; i <= 30; i++) {
            dayToStep.put(i, 0);
        }
    }

    public void saveSteps(int day, int step) {

        dayToStep.put(day, step);
    }

    public void printStatistic(int targetStep) {
        int seriesOfVictories = 0;
        int saveVictory = 0;
        int stepsPerMonth = 0;
        for (int day : dayToStep.keySet()) {
            System.out.print(day + " день" + ": " + dayToStep.get(day) + ", ");
        }
        for (int step : dayToStep.values()) {
            stepsPerMonth += step;
            if (step >= targetStep) {
                saveVictory += 1;
            } else {
                saveVictory = 0;
            }
            if (saveVictory > seriesOfVictories) {
                seriesOfVictories = saveVictory;
            }
        }
        System.out.println();
        System.out.println("Обшее количество шагов: " + stepsPerMonth);
        System.out.println("Среднее количество шагов: " + stepsPerMonth / 30);
        System.out.println("Пройденная дистанция: " + converter.stepInKm(stepsPerMonth) + "(km)");
        System.out.println("Количество сожжённых килокалорий: " + converter.stepInKcal(stepsPerMonth));
        System.out.println("Лучшая серия: " + seriesOfVictories);
    }
}
