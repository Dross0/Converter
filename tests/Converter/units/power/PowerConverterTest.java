package Converter.units.power;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PowerConverterTest {
    @Test
    void convertWattAndHorsePower() {
        assertEquals(32065.1, PowerConverter.convert(43, PowerUnit.HORSE_POWER, PowerUnit.WATT), 0.01);
        assertEquals(1.34, PowerConverter.convert(1000, PowerUnit.WATT, PowerUnit.HORSE_POWER), 0.01);
    }

    @Test
    void convertWattAndKilowatt() {
        assertEquals(43000, PowerConverter.convert(43, PowerUnit.KILOWATT, PowerUnit.WATT), 0.01);
        assertEquals(1.25, PowerConverter.convert(1250, PowerUnit.WATT, PowerUnit.KILOWATT), 0.01);
    }

    @Test
    void convertWattAndBTUPerHour() {
        assertEquals(1260.21, PowerConverter.convert(4300, PowerUnit.BTU_PER_HOUR, PowerUnit.WATT), 0.01);
        assertEquals(443.578, PowerConverter.convert(130, PowerUnit.WATT, PowerUnit.BTU_PER_HOUR), 0.01);
    }

    @Test
    void convertWattAndBTUPerSecond() {
        assertEquals(45367.57, PowerConverter.convert(43, PowerUnit.BTU_PER_SECOND, PowerUnit.WATT), 0.01);
        assertEquals(5.11821, PowerConverter.convert(5400, PowerUnit.WATT, PowerUnit.BTU_PER_SECOND), 0.01);
    }

    @Test
    void convertWattAndCalories() {
        assertEquals(104.6, PowerConverter.convert(25, PowerUnit.CAL, PowerUnit.WATT), 0.01);
        assertEquals(83.65, PowerConverter.convert(350, PowerUnit.WATT, PowerUnit.CAL), 0.01);
    }

    @Test
    void convertWattAndKilocalories() {
        assertEquals(962320, PowerConverter.convert(230, PowerUnit.KILOCAL, PowerUnit.WATT), 0.01);
        assertEquals(0.800669, PowerConverter.convert(3350, PowerUnit.WATT, PowerUnit.KILOCAL), 0.01);
    }

    @Test
    void convertHorsePowerAndCalories() {
        assertEquals(301.077, PowerConverter.convert(53660, PowerUnit.CAL, PowerUnit.HORSE_POWER), 0.01);
        assertEquals(9980.69, PowerConverter.convert(56, PowerUnit.HORSE_POWER, PowerUnit.CAL), 0.01);
    }
}