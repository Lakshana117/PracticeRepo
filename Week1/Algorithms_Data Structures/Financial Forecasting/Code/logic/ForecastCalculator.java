package logic;

public class ForecastCalculator {

    // Recursive method
    public static double futureValueRecursive(double initialAmount, double growthRate, int year) {
        if (year == 0) return initialAmount;
        return futureValueRecursive(initialAmount, growthRate, year - 1) * (1 + growthRate);
    }

    // Memoized method
    public static double futureValueMemo(double initialAmount, double growthRate, int year, double[] memo) {
        if (year == 0) return initialAmount;
        if (memo[year] != 0) return memo[year];
        memo[year] = futureValueMemo(initialAmount, growthRate, year - 1, memo) * (1 + growthRate);
        return memo[year];
    }
}
