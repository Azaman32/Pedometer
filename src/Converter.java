public class Converter {
    double convertStepInKm (double step){
        double stepInKm = 0;
        stepInKm = 75 * step / 1000000;
        return stepInKm;
    }
    double convertKilocalories (double step){
        double stepInCalories = 0;
        stepInCalories = step * 50 / 1000;
        return stepInCalories;
    }
}
