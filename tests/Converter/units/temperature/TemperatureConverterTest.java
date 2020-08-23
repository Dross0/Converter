package Converter.units.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @Test
    void convertFahrenheitToCelsius() {
        assertEquals(20, TemperatureConverter.convert(68, TemperatureUnit.FAHRENHEIT, TemperatureUnit.CELSIUS), 0.01);
        assertEquals(371.667, TemperatureConverter.convert(701, TemperatureUnit.FAHRENHEIT, TemperatureUnit.CELSIUS), 0.01);
    }

    @Test
    void convertFahrenheitToKelvin() {
        assertEquals(283.15, TemperatureConverter.convert(50, TemperatureUnit.FAHRENHEIT, TemperatureUnit.KELVIN), 0.01);
        assertEquals(329.817, TemperatureConverter.convert(134, TemperatureUnit.FAHRENHEIT, TemperatureUnit.KELVIN), 0.01);
    }

    @Test
    void convertCelsiusToKelvin() {
        assertEquals(413.15, TemperatureConverter.convert(140, TemperatureUnit.CELSIUS, TemperatureUnit.KELVIN), 0.01);
        assertEquals(309.75, TemperatureConverter.convert(36.6, TemperatureUnit.CELSIUS, TemperatureUnit.KELVIN), 0.01);
    }

    @Test
    void convertCelsiusToFahrenheit() {
        assertEquals(50, TemperatureConverter.convert(10, TemperatureUnit.CELSIUS, TemperatureUnit.FAHRENHEIT), 0.01);
        assertEquals(-10.21, TemperatureConverter.convert(-23.45, TemperatureUnit.CELSIUS, TemperatureUnit.FAHRENHEIT), 0.01);
    }

    @Test
    void convertKelvinToCelsius() {
        assertEquals(26.85, TemperatureConverter.convert(300, TemperatureUnit.KELVIN, TemperatureUnit.CELSIUS), 0.01);
        assertEquals(-0.15, TemperatureConverter.convert(273, TemperatureUnit.KELVIN, TemperatureUnit.CELSIUS), 0.01);
    }

    @Test
    void convertKelvinToFahrenheit() {
        assertEquals(40.73, TemperatureConverter.convert(278, TemperatureUnit.KELVIN, TemperatureUnit.FAHRENHEIT), 0.01);
        assertEquals(-452.47, TemperatureConverter.convert(4, TemperatureUnit.KELVIN, TemperatureUnit.FAHRENHEIT), 0.01);
    }

}