package Converter.units.angle;

import Converter.IConverter;


import java.util.HashMap;

public class AngleConverter implements IConverter {
    private static HashMap<AngleUnit, Double> rates = new HashMap<>();
    static{
        rates.put(AngleUnit.SECOND, 1.0);
        rates.put(AngleUnit.RADIAN, 206265.0);
        rates.put(AngleUnit.DEGREE, 3600.0);
        rates.put(AngleUnit.GRADIAN, 3240.0);
        rates.put(AngleUnit.CIRCLE, 1296000.0);
        rates.put(AngleUnit.MINUTE, 60.0);
    }

    public static double convert(double value, AngleUnit fromUnit, AngleUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
