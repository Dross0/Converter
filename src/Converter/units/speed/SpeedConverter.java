package Converter.units.speed;

import Converter.IConverter;

import java.util.HashMap;

public class SpeedConverter implements IConverter {
    private static HashMap<SpeedUnit, Double> rates = new HashMap<>();
    static{
        rates.put(SpeedUnit.KILOMETER_PER_HOUR, 1.0);
        rates.put(SpeedUnit.METER_PER_SECOND, 3.6);
        rates.put(SpeedUnit.FOOT_PER_SECOND, 1.09728);
        rates.put(SpeedUnit.MILE_PER_HOUR, 1.60934);
        rates.put(SpeedUnit.MACH, 1224.0);
        rates.put(SpeedUnit.SPEED_OF_LIGHT, 1.07925285e9);
        rates.put(SpeedUnit.KNOT, 1.852);
    }

    public static double convert(double value, SpeedUnit fromUnit, SpeedUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
