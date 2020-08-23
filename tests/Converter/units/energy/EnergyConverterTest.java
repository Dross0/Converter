package Converter.units.energy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnergyConverterTest {
    @Test
    void convertJouleAndCalories() {
        assertEquals(1380.72, EnergyConverter.convert(330, EnergyUnit.CALORIES, EnergyUnit.JOULE), 0.01);
        assertEquals(13.1453, EnergyConverter.convert(55, EnergyUnit.JOULE, EnergyUnit.CALORIES), 0.01);
    }

    @Test
    void convertJouleAndKilocalories() {
        assertEquals(22384.4, EnergyConverter.convert(5.35, EnergyUnit.KILOCALORIES, EnergyUnit.JOULE), 0.01);
        assertEquals(3.66874, EnergyConverter.convert(15350, EnergyUnit.JOULE, EnergyUnit.KILOCALORIES), 0.01);
    }

    @Test
    void convertJouleAndKilojoule() {
        assertEquals(2356, EnergyConverter.convert(2.356, EnergyUnit.KILOJOULE, EnergyUnit.JOULE), 0.01);
        assertEquals(1.53, EnergyConverter.convert(1530, EnergyUnit.JOULE, EnergyUnit.KILOJOULE), 0.01);
    }

    @Test
    void convertJouleAndKilowattHour() {
        assertEquals(108000, EnergyConverter.convert(0.03, EnergyUnit.KILOWATT_PER_HOUR, EnergyUnit.JOULE), 0.01);
        assertEquals(1.47222, EnergyConverter.convert(5300000, EnergyUnit.JOULE, EnergyUnit.KILOWATT_PER_HOUR), 0.01);
    }

    @Test
    void convertJouleAndErg() {
        assertEquals(0.635, EnergyConverter.convert(6350000, EnergyUnit.ERG, EnergyUnit.JOULE), 0.01);
        assertEquals(350000, EnergyConverter.convert(0.035, EnergyUnit.JOULE, EnergyUnit.ERG), 0.01);
    }

    @Test
    void convertJouleAndBtu() {
        assertEquals(24266.37, EnergyConverter.convert(23, EnergyUnit.BTU, EnergyUnit.JOULE), 0.01);
        assertEquals(116.58, EnergyConverter.convert(123000, EnergyUnit.JOULE, EnergyUnit.BTU), 0.01);
    }

}