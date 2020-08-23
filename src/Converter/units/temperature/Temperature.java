package Converter.units.temperature;

public class Temperature {
    private double celsius;
    private double fahrenheit;
    private double kelvin;

    public Temperature(double value, TemperatureUnit unit){
        setCelsius(value, unit);
        setFahrenheitFromCelsius(value);
        setKelvinFromCelsius(value);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public double getKelvin() {
        return kelvin;
    }

    private void setKelvinFromCelsius(double value) {
        this.kelvin = this.celsius + 273.15;
    }

    private void setFahrenheitFromCelsius(double value) {
        this.fahrenheit = (this.celsius * 9 / 5) + 32;
    }

    private void setCelsius(double value, TemperatureUnit unit){
        if (unit == TemperatureUnit.CELSIUS){
            this.celsius = value;
        }
        else if (unit == TemperatureUnit.FAHRENHEIT){
            this.celsius = (value - 32) * 5 / 9;
        }
        else if (unit ==TemperatureUnit.KELVIN){
            this.celsius = value - 273.15;
        }
    }
}
