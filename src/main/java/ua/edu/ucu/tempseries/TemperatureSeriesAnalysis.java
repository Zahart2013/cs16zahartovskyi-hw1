package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;
    private int size;
    static final int MIN = -273;

    public TemperatureSeriesAnalysis() {
        throw new IllegalArgumentException();
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (int i = 0; i < temperatureSeries.length; i++) {
            if (temperatureSeries[i] < MIN) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = Arrays.copyOf(temperatureSeries, 
                                               temperatureSeries.length);
        size = temperatureSeries.length;
    }

    public double average() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += this.temperatureSeries[i];
        }
        return sum / size;
    }

    public double deviation() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        double aver = this.average();
        for (int i = 0; i < size; i++) {
            sum += Math.pow(this.temperatureSeries[i] - aver, 2);
        }
        return Math.sqrt(sum / size);
    }

    public double min() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double mn = this.temperatureSeries[0];
        for (int i = 1; i < size; i++) {
            if (mn > this.temperatureSeries[i]) {
                mn = this.temperatureSeries[i];
            }
        }
        return mn;
    }

    public double max() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double mx = this.temperatureSeries[0];
        for (int i = 1; i < size; i++) {
            if (mx < this.temperatureSeries[i]) {
                mx = this.temperatureSeries[i];
            }
        }
        return mx;
    }

    public double findTempClosestToZero() {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double closest = this.temperatureSeries[0];
        for (int i = 1; i < size; i++) {
            if ((Math.abs(closest) - Math.abs(this.temperatureSeries[i]) > 0) 
                || Math.abs(closest) == this.temperatureSeries[i]) {
                closest = this.temperatureSeries[i];
            }
        }
        return closest;
    }

    public double findTempClosestToValue(double tempValue) {
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        double closest = this.temperatureSeries[0];
        for (int i = 1; i < size; i++) {
            if (Math.abs(tempValue - closest) 
                > Math.abs(tempValue - this.temperatureSeries[i])) {
                closest = this.temperatureSeries[i];
            }
        }
        return closest;
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] restemp = new double[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (this.temperatureSeries[i] < tempValue) {
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

    public double[] findTempsGreaterThen(double tempValue) {
        double[] restemp = new double[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
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
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(this.average(),
                                         this.deviation(),
                                         this.max(),
                                         this.min());
    }

    public int addTemps(double[] temps) {
        for (int i = 0; i < temps.length; i++) {
            if (this.temperatureSeries.length == size) {
                double[] temp = new double[this.temperatureSeries.length];
                for (int j = 0; j < this.temperatureSeries.length; j++) {
                    temp[j] = this.temperatureSeries[j];
                }
                this.temperatureSeries = new double[size*2];
                for (int j = 0; j < size; j++) {
                    this.temperatureSeries[j] = temp[j];
                }
            }
            this.temperatureSeries[size] = temps[i];
            size += 1;
        }
        return size;
    }
}
