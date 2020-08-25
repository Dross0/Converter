package Converter.units.currency;

public class Currency {
    private String charCode;
    private int nominal;
    private double value;

    public Currency(String charCode, int nominal, double value){
        this.charCode = charCode;
        this.nominal = nominal;
        this.value = value;
    }

    public String getCharCode() {
        return charCode;
    }

    public int getNominal() {
        return nominal;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "charCode='" + charCode + '\'' +
                ", nominal=" + nominal +
                ", value=" + value +
                '}';
    }
}
