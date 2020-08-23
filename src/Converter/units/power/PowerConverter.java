package Converter.units.power;


import Converter.IConverter;

import java.util.HashMap;

public class PowerConverter implements IConverter {
    private static HashMap<PowerUnit, Double> rates = new HashMap<>();
    static{
        rates.put(PowerUnit.HORSE_POWER, 745.7);
        rates.put(PowerUnit.WATT, 1.0);
        rates.put(PowerUnit.KILOWATT, 1000.0);
        rates.put(PowerUnit.BTU_PER_HOUR, 0.293071);
        rates.put(PowerUnit.BTU_PER_SECOND, 1055.06);
        rates.put(PowerUnit.CAL, 4.184);
        rates.put(PowerUnit.KILOCAL, 4184.0);
    }

    public static double convert(double value, PowerUnit fromUnit, PowerUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
