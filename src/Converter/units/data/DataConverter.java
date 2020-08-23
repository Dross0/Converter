package Converter.units.data;

import Converter.IConverter;

import java.util.HashMap;

public class DataConverter implements IConverter {
    private static HashMap<DataUnit, Double> rates = new HashMap<>();
    static{
        rates.put(DataUnit.MEGABIT, 1.0);
        rates.put(DataUnit.BIT, 0.000001);
        rates.put(DataUnit.KILOBIT, 0.001);
        rates.put(DataUnit.GIGABIT, 1000.0);
        rates.put(DataUnit.BYTE, 0.000008);
        rates.put(DataUnit.KILOBYTE, 0.008);
        rates.put(DataUnit.MEGABYTE, 8.0);
        rates.put(DataUnit.GIGABYTE, 8000.0);
        rates.put(DataUnit.TERABYTE, 8000000.0);
    }

    public static double convert(double value, DataUnit fromUnit, DataUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
