package Converter.units.energy;


import Converter.IConverter;

import java.util.HashMap;

public class EnergyConverter implements IConverter {
    private static HashMap<EnergyUnit, Double> rates = new HashMap<>();
    static{
        rates.put(EnergyUnit.JOULE, 1.0);
        rates.put(EnergyUnit.KILOJOULE, 1000.0);
        rates.put(EnergyUnit.CALORIES, 4.184);
        rates.put(EnergyUnit.KILOCALORIES, 4184.0);
        rates.put(EnergyUnit.KILOWATT_PER_HOUR, 3600000.0);
        rates.put(EnergyUnit.BTU, 1055.06);
        rates.put(EnergyUnit.ERG, 0.0000001);
    }

    public static double convert(double value, EnergyUnit fromUnit, EnergyUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
