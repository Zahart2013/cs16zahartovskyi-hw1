package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.lang.Math;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++)
            if (temperatureSeries[i] < -273) throw new InputMismatchException();
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, temperatureSeries.length);
    }

    public double average() {
        if (this.temperatureSeries.length == 0) throw new IllegalArgumentException();
        double sum = 0;
        for (int i = 0; i < this.temperatureSeries.length; i++)
            sum += this.temperatureSeries[i];
        return sum / this.temperatureSeries.length;
    }

    public double deviation() {
        if (this.temperatureSeries.length == 0) throw new IllegalArgumentException();
        double sum = 0;
        double aver = this.average();
        for (int i = 0; i < this.temperatureSeries.length; i++)
            sum += Math.pow(this.temperatureSeries[i] - aver, 2);
        return Math.sqrt(sum / this.temperatureSeries.length);
    }

    public double min() {
        if (this.temperatureSeries.length == 0) throw new IllegalArgumentException();
        double mn = this.temperatureSeries[0];
        for (int i = 1; i < this.temperatureSeries.length; i++) {
            if (mn > this.temperatureSeries[i])
                mn = this.temperatureSeries[i];
        }
        return mn;
    }

    public double max() {
        if (this.temperatureSeries.length == 0) throw new IllegalArgumentException();
        double mx = this.temperatureSeries[0];
        for (int i = 1; i < this.temperatureSeries.length; i++) {
            if (mx < this.temperatureSeries[i])
                mx = this.temperatureSeries[i];
        }
        return mx;
    }

    public double findTempClosestToZero() {
        if (this.temperatureSeries.length == 0) throw new IllegalArgumentException();
        double closest = this.temperatureSeries[0];
        for (int i = 1; i < this.temperatureSeries.length; i++) {
            if (Math.abs(closest) > Math.abs(this.temperatureSeries[i]) || Math.abs(closest) == this.temperatureSeries[i])
                closest = this.temperatureSeries[i];
        }
        return closest;
    }

    public double findTempClosestToValue(double tempValue) {
        if (this.temperatureSeries.length == 0) throw new IllegalArgumentException();
        double closest = this.temperatureSeries[0];
        for (int i = 1; i < this.temperatureSeries.length; i++) {
            if (Math.abs(tempValue - closest) > Math.abs(tempValue - this.temperatureSeries[i]))
                closest = this.temperatureSeries[i];
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] restemp = new double[this.temperatureSeries.length];
        int j = 0;
        for (int i = 0; i < this.temperatureSeries.length; i++) {
            if (this.temperatureSeries[i] < tempValue) {
                restemp[j] = this.temperatureSeries[i];
                j += 1;
            }
        }
        double[] res = new double[j];
        for (int i = 0; i < j; i++)
            res[i] = restemp[i];
        return res;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] restemp = new double[this.temperatureSeries.length];
        int j = 0;
        for (int i = 0; i < this.temperatureSeries.length; i++) {
            if (this.temperatureSeries[i] > tempValue) {
                restemp[j] = this.temperatureSeries[i];
                j += 1;
            }
        }
        double[] res = new double[j];
        for (int i = 0; i < j; i++) {
            res[i] = restemp[i];
        }
        return res;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (this.temperatureSeries.length == 0) throw new IllegalArgumentException();
        return new TempSummaryStatistics(this.average(), this.deviation(), this.max(), this.min());
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
