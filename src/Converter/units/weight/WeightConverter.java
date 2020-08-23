package Converter.units.weight;



import Converter.IConverter;

import java.util.HashMap;

public class WeightConverter implements IConverter {
    private static HashMap<WeightUnit, Double> rates = new HashMap<>();
    static{
        rates.put(WeightUnit.KILOGRAM, 1.0);
        rates.put(WeightUnit.GRAM, 0.001);
        rates.put(WeightUnit.MILLIGRAM, 0.000001);
        rates.put(WeightUnit.MICROGRAM, 1E-9);
        rates.put(WeightUnit.POUND, 0.453592);
        rates.put(WeightUnit.OUNCE, 0.02835);
        rates.put(WeightUnit.SHORT_TON, 907.185);
        rates.put(WeightUnit.TON, 1000.0);
        rates.put(WeightUnit.LONG_TON, 1016.05);
    }

    public static double convert(double value, WeightUnit fromUnit, WeightUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
