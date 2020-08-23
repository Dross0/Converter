package Converter.units.volume;

import Converter.IConverter;


import java.util.HashMap;

public class VolumeConverter implements IConverter {
    private static HashMap<VolumeUnit, Double> rates = new HashMap<>();
    static{
        rates.put(VolumeUnit.MILLILITRE, 1.0);
        rates.put(VolumeUnit.LITRE, 1000.0);
        rates.put(VolumeUnit.CUBIC_MILLIMETER, 0.001);
        rates.put(VolumeUnit.CUBIC_CENTIMETER, 1.0);
        rates.put(VolumeUnit.CUBIC_METER, 1000000.0);
        rates.put(VolumeUnit.CUBIC_FOOT, 28316.8);
        rates.put(VolumeUnit.CUBIC_INCH, 16.3871);
        rates.put(VolumeUnit.CUBIC_YARD, 764555.0);
        rates.put(VolumeUnit.GALLON_USA, 3785.41);
        rates.put(VolumeUnit.QUART, 946.351);
        rates.put(VolumeUnit.PINT, 473.176);
        rates.put(VolumeUnit.FLUID_OUNCE, 29.5735);
        rates.put(VolumeUnit.TABLESPOON, 14.7868);
        rates.put(VolumeUnit.TEASPOON, 4.92892);
        rates.put(VolumeUnit.GALLON_UK, 4546.09);
    }

    public static double convert(double value, VolumeUnit fromUnit, VolumeUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
