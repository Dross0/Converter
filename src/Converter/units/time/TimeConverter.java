package Converter.units.time;

import Converter.IConverter;

import java.util.HashMap;

public class TimeConverter implements IConverter {
    private static HashMap<TimeUnit, Double> rates = new HashMap<>();
    static{
        rates.put(TimeUnit.SECOND, 1.0);
        rates.put(TimeUnit.MINUTE, 60.0);
        rates.put(TimeUnit.HOUR, 3600.0);
        rates.put(TimeUnit.DAY, 86400.0);
        rates.put(TimeUnit.WEEK, 604800.0);
        rates.put(TimeUnit.MONTH, 2630000.0);
        rates.put(TimeUnit.YEAR, 31560000.0);
        rates.put(TimeUnit.MILLISECOND, 0.001);
        rates.put(TimeUnit.MICROSECOND, 0.000001);
        rates.put(TimeUnit.NANOSECOND, 1e-9);
    }

    public static double convert(double value, TimeUnit fromUnit, TimeUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
