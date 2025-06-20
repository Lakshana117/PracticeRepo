import model.ForecastData;
import logic.ForecastCalculator;

public class Main {
    public static void main(String[] args) {
        ForecastData data = new ForecastData(1000.0, 0.05, 5);

        System.out.println("Financial Forecast using Recursion:");
        for (int i = 0; i <= data.getYears(); i++) {
            double fv = ForecastCalculator.futureValueRecursive(data.getInitialAmount(), data.getGrowthRate(), i);
            System.out.printf("Year %d: %.2f%n", i, fv);
        }

        System.out.println("\nOptimized with Memoization:");
        double[] memo = new double[data.getYears() + 1];
        for (int i = 0; i <= data.getYears(); i++) {
            double fv = ForecastCalculator.futureValueMemo(data.getInitialAmount(), data.getGrowthRate(), i, memo);
            System.out.printf("Year %d: %.2f%n", i, fv);
        }
    }
}
