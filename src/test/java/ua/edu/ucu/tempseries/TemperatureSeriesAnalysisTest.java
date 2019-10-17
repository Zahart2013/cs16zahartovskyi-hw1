package ua.edu.ucu.tempseries;

import org.junit.Test;

import static org.junit.Assert.*;

public class TemperatureSeriesAnalysisTest {

    @Test(expected = IllegalArgumentException.class)
    public void testTemperatureSeriesGen() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0;

        // call tested method
        double actualResult = seriesAnalysis.deviation();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {10.0, 14.7, -3.1, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 6.9003623093284;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {10.0, 14.7, -3.1, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -3.1;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {10.0, 14.7, -3.1, 2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 14.7;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZero() {
        double[] temperatureSeries = {2.1, 5.5, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToZeroEqualDistance() {
        double[] temperatureSeries = {1.0, 5.5, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValue() {
        double[] temperatureSeries = {2.0, 5.5, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(3);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testClosestToValueEqualDistance() {
        double[] temperatureSeries = {2.0, 5.5, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(2.1);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessThen() {
        double[] temperatureSeries = {2.0, 5.5, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult[] = {-1.0, -2.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterThen() {
        double[] temperatureSeries = {2.0, 5.5, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult[] = {2.0, 5.5};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(1.0);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {2.0, 5.0, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expAvg = 1.0;
        double expDev = Math.sqrt(7.5);
        double expMin = -2.0;
        double expMax = 5.0;

        TempSummaryStatistics res = seriesAnalysis.summaryStatistics();

        assertEquals(expAvg, res.getAvgTemp(), 0.00001);
        assertEquals(expDev, res.getDevTemp(), 0.00001);
        assertEquals(expMin, res.getMinTemp(), 0.00001);
        assertEquals(expMax, res.getMaxTemp(), 0.00001);
    }

    @Test
    public void testAddTemps(){
        double[] temperatureSeries = {2.0, 5.0, -1.0, -2.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expRes = 6;
        double[] testArray = new double[] {4.0, 2.0};

        assertEquals(seriesAnalysis.addTemps(testArray), expRes);
    }
}
