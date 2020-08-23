package Converter.units.square;



import Converter.IConverter;

import java.util.HashMap;

public class SquareConverter implements IConverter {
    private static HashMap<SquareUnit, Double> rates = new HashMap<>();
    static{
        rates.put(SquareUnit.SQUARE_METER, 1.0);
        rates.put(SquareUnit.SQUARE_MILLIMETER, 0.000001);
        rates.put(SquareUnit.SQUARE_CENTIMETER, 0.0001);
        rates.put(SquareUnit.SQUARE_KILOMETER, 1000000.0);
        rates.put(SquareUnit.SQUARE_MILE, 2590000.0);
        rates.put(SquareUnit.SQUARE_YARD, 0.836127);
        rates.put(SquareUnit.SQUARE_INCH, 6.45161291e-4);
        rates.put(SquareUnit.SQUARE_FOOT, 0.092903);
        rates.put(SquareUnit.ACRE, 4046.86);
        rates.put(SquareUnit.ARE, 100.0);
        rates.put(SquareUnit.HECTARE, 10000.0);
        rates.put(SquareUnit.SQUARE_DECIMETER, 0.01);
        rates.put(SquareUnit.SQUARE_MICROMETER, 1e-12);
    }

    public static double convert(double value, SquareUnit fromUnit, SquareUnit toUnit){
        double rate = rates.get(fromUnit) / rates.get(toUnit);
        return value * rate;
    }
}
