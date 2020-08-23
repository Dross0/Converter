package Converter.units.weight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightConverterTest {

    @Test
    void convertKilogramAndGram() {
        assertEquals(1.35, WeightConverter.convert(1350, WeightUnit.GRAM, WeightUnit.KILOGRAM), 0.01);
        assertEquals(5400, WeightConverter.convert(5.4, WeightUnit.KILOGRAM, WeightUnit.GRAM), 0.01);
    }

    @Test
    void convertKilogramAndPound() {
        assertEquals(256.733, WeightConverter.convert(566, WeightUnit.POUND, WeightUnit.KILOGRAM), 0.01);
        assertEquals(2989.47, WeightConverter.convert(1356, WeightUnit.KILOGRAM, WeightUnit.POUND), 0.01);
    }

    @Test
    void convertKilogramAndOunce() {
        assertEquals(1.50822, WeightConverter.convert(53.2, WeightUnit.OUNCE, WeightUnit.KILOGRAM), 0.01);
        assertEquals(44303.35, WeightConverter.convert(1256, WeightUnit.KILOGRAM, WeightUnit.OUNCE), 0.01);
    }

    @Test
    void convertKilogramAndMilligram() {
        assertEquals(0.153, WeightConverter.convert(153000, WeightUnit.MILLIGRAM, WeightUnit.KILOGRAM), 0.01);
        assertEquals(4300000, WeightConverter.convert(4.3, WeightUnit.KILOGRAM, WeightUnit.MILLIGRAM), 0.01);
    }

    @Test
    void convertKilogramAndShortTon() {
        assertEquals(3900.89, WeightConverter.convert(4.3, WeightUnit.SHORT_TON, WeightUnit.KILOGRAM), 0.01);
        assertEquals(5.8406, WeightConverter.convert(5300, WeightUnit.KILOGRAM, WeightUnit.SHORT_TON), 0.01);
    }

    @Test
    void convertKilogramAndTon() {
        assertEquals(4330, WeightConverter.convert(4.33, WeightUnit.TON, WeightUnit.KILOGRAM), 0.01);
        assertEquals(1.256, WeightConverter.convert(1256, WeightUnit.KILOGRAM, WeightUnit.TON), 0.01);
    }

    @Test
    void convertKilogramAndLongTon() {
        assertEquals(6807.53, WeightConverter.convert(6.7, WeightUnit.LONG_TON, WeightUnit.KILOGRAM), 0.01);
        assertEquals(5.80682, WeightConverter.convert(5900, WeightUnit.KILOGRAM, WeightUnit.LONG_TON), 0.01);
    }

    @Test
    void convertKilogramAndMicrogram() {
        assertEquals(0.15, WeightConverter.convert(150000000, WeightUnit.MICROGRAM, WeightUnit.KILOGRAM), 0.01);
        assertEquals(10000000, WeightConverter.convert(0.01, WeightUnit.KILOGRAM, WeightUnit.MICROGRAM), 0.01);
    }
}