package Converter.units.length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LengthConverterTest {
    @Test
    void convertMillimeterAndMeter() {
        assertEquals(3.805, LengthConverter.convert(3805, LengthUnit.MILLIMETER, LengthUnit.METER), 0.01);
        assertEquals(50350, LengthConverter.convert(50.350, LengthUnit.METER, LengthUnit.MILLIMETER), 0.01);
    }

    @Test
    void convertCentimeterAndMeter() {
        assertEquals(50.13, LengthConverter.convert(5013, LengthUnit.CENTIMETER, LengthUnit.METER), 0.01);
        assertEquals(1120, LengthConverter.convert(11.2, LengthUnit.METER, LengthUnit.CENTIMETER), 0.01);
    }

    @Test
    void convertDecimeterAndMeter() {
        assertEquals(5.03, LengthConverter.convert(50.3, LengthUnit.DECIMETER, LengthUnit.METER), 0.01);
        assertEquals(102, LengthConverter.convert(10.2, LengthUnit.METER, LengthUnit.DECIMETER), 0.01);
    }

    @Test
    void convertKilometerAndMeter() {
        assertEquals(5400, LengthConverter.convert(5.4, LengthUnit.KILOMETER, LengthUnit.METER), 0.01);
        assertEquals(0.332, LengthConverter.convert(332, LengthUnit.METER, LengthUnit.KILOMETER), 0.01);
    }

    @Test
    void convertFootAndMeter() {
        assertEquals(91.44, LengthConverter.convert(300, LengthUnit.FOOT, LengthUnit.METER), 0.01);
        assertEquals(501.969, LengthConverter.convert(153, LengthUnit.METER, LengthUnit.FOOT), 0.01);
    }

    @Test
    void convertInchAndMeter() {
        assertEquals(30.48, LengthConverter.convert(1200, LengthUnit.INCH, LengthUnit.METER), 0.01);
        assertEquals(2086.61, LengthConverter.convert(53, LengthUnit.METER, LengthUnit.INCH), 0.01);
    }

    @Test
    void convertMileAndMeter() {
        assertEquals(5310.83, LengthConverter.convert(3.3, LengthUnit.MILE, LengthUnit.METER), 0.01);
        assertEquals(0.8078, LengthConverter.convert(1300, LengthUnit.METER, LengthUnit.MILE), 0.01);
    }

    @Test
    void convertYardAndMeter() {
        assertEquals(457.2, LengthConverter.convert(500, LengthUnit.YARD, LengthUnit.METER), 0.01);
        assertEquals(1445.76, LengthConverter.convert(1322, LengthUnit.METER, LengthUnit.YARD), 0.01);
    }

    @Test
    void convertFathomAndMeter() {
        assertEquals(914.5, LengthConverter.convert(500, LengthUnit.FATHOM_USA, LengthUnit.METER), 0.01);
        assertEquals(3444.51, LengthConverter.convert(6300, LengthUnit.METER, LengthUnit.FATHOM_USA), 0.01);
    }

    @Test
    void convertNauticalMileAndMeter() {
        assertEquals(933408, LengthConverter.convert(504, LengthUnit.NAUTICAL_MILE, LengthUnit.METER), 0.01);
        assertEquals(1.253, LengthConverter.convert(2322, LengthUnit.METER, LengthUnit.NAUTICAL_MILE), 0.01);
    }

    @Test
    void convertMileAndKilometer() {
        assertEquals(52.30, LengthConverter.convert(32.5, LengthUnit.MILE, LengthUnit.KILOMETER), 0.01);
        assertEquals(65.244, LengthConverter.convert(105, LengthUnit.KILOMETER, LengthUnit.MILE), 0.01);
    }

    @Test
    void convertInchAndCentimeter() {
        assertEquals(863.6, LengthConverter.convert(340, LengthUnit.INCH, LengthUnit.CENTIMETER), 0.01);
        assertEquals(100.787, LengthConverter.convert(256, LengthUnit.CENTIMETER, LengthUnit.INCH), 0.01);
    }
}