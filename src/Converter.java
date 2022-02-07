public class Converter {
    double stepInKm(double step) {
        return 75 * step / 1000000;
    }

    double stepInKcal(double step) {
        return step * 50 / 1000;
    }
}
