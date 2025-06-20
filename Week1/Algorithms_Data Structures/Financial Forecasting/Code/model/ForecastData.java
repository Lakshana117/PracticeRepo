package model;

public class ForecastData {
    private double initialAmount;
    private double growthRate;
    private int years;

    public ForecastData(double initialAmount, double growthRate, int years) {
        this.initialAmount = initialAmount;
        this.growthRate = growthRate;
        this.years = years;
    }

    public double getInitialAmount() {
        return initialAmount;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public int getYears() {
        return years;
    }
}
