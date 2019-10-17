package ua.edu.ucu.tempseries;

import lombok.Getter;

public class TempSummaryStatistics {

    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;

    public TempSummaryStatistics() {
        throw new IllegalArgumentException();
    }

    public TempSummaryStatistics(double avgTemp,
                                 double devTemp,
                                 double maxTemp,
                                 double minTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    public double getAvgTemp() {
        return this.avgTemp;
    }

    public double getDevTemp() {
        return this.devTemp;
    }

    public double getMinTemp() {
        return this.minTemp;
    }

    public double getMaxTemp() {
        return this.maxTemp;
    }
}
