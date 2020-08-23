package Converter.units.length;

import Converter.IConverter;

import java.util.HashMap;

public class LengthConverter implements IConverter {
    private static HashMap<LengthUnit, Double> rates = new HashMap<>();
    static{
        rates.put(LengthUnit.METER, 1.0);
        rates.put(LengthUnit.CENTIMETER, 0.01);
        rates.put(LengthUnit.MILLIMETER, 0.001);
        rates.put(LengthUnit.DECIMETER, 0.1);
        rates.put(LengthUnit.KILOMETER, 1000.0);
        rates.put(LengthUnit.FOOT, 0.3048);
        rates.put(LengthUnit.INCH, 0.0254);
        rates.put(LengthUnit.MILE, 1609.34);
        rates.put(LengthUnit.YARD, 0.9144);
        rates.put(LengthUnit.FATHOM_USA, 1.829);
        rates.put(LengthUnit.NAUTICAL_MILE, 1852.0);
    }

    public static double convert(double value, LengthUnit fromUnit, LengthUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
