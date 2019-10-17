package ua.edu.ucu.tempseries;

import lombok.Getter;

public class TempSummaryStatistics {
    @Getter
    private double avgTemp;
    @Getter
    private double devTemp;
    @Getter
    private double minTemp;
    @Getter
    private double maxTemp;

    public TempSummaryStatistics(double avgTemp, double devTemp, double maxTemp, double minTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }
}
