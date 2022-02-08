import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker = new StepTracker();
        MonthData monthData;
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        boolean isMenu = true;
        while (isMenu) {
            menu.printMenu();
            int command = scanner.nextInt();
            switch (command) {
                case 1: {
                    while (true) {
                        System.out.println("Введите количество шагов");
                        int stepTarget = scanner.nextInt();
                        if (stepTarget > 0) {
                            stepTracker.saveStep(stepTarget);
                            break;
                        } else {
                            System.out.println("Количество шагов не може быть отрицательным!");
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Выберите месяц");
                    stepTracker.printMonth();
                    int monthNumber = scanner.nextInt();
                    monthData = stepTracker.getMonthData(monthNumber);
                    System.out.println("Введите день");
                    int day = scanner.nextInt();
                    while (true) {
                        System.out.println("Введите количество шагов");
                        int steps = scanner.nextInt();
                        if (steps > 0) {
                            monthData.saveSteps(day, steps);
                            break;
                        } else {
                            System.out.println("Количество шагов не може быть отрицательным!");
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("Выберите мясяц");
                    int monthNumber = scanner.nextInt();
                    monthData = stepTracker.monthToData.get(monthNumber - 1);
                    monthData.printStatistic(stepTracker.targetStep);
                    break;
                }
                case 0:
                    System.out.println("Выход");
                    isMenu = false;
                    break;
                default:
                    System.out.println("Такой команды нет.");
                    break;
            }
        }
    }
}
