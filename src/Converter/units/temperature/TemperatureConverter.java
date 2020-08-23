package Converter.units.temperature;


import Converter.IConverter;

public class TemperatureConverter implements IConverter {
    public static double convert(double value, TemperatureUnit fromUnit, TemperatureUnit toUnit){
        Temperature temperature = new Temperature(value, fromUnit);
        switch (toUnit){
            case CELSIUS:
                return temperature.getCelsius();
            case KELVIN:
                return temperature.getKelvin();
            case FAHRENHEIT:
                return temperature.getFahrenheit();
            default:
                throw new RuntimeException();
        }
    }
}
