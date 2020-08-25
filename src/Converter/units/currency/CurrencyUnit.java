package Converter.units.currency;

import Converter.IUnit;

public enum CurrencyUnit implements IUnit {
    RUB("RUB"), // Russian Ruble
    AUD("AUD"), // Australian Dollar
    AZN("AZN"), // Azerbaijan Manat
    GBP("GBP"), // British Pound Sterling
    AMD("AMD"), // Armenia Dram
    BYN("BYN"), // Belarussian Ruble
    BGN("BGN"), // Bulgarian lev
    BRL("BRL"), // Brazil Real
    HUF("HUF"), // Hungarian Forint
    HKD("HKD"), // Hong Kong Dollar
    DKK("DKK"), // Danish Krone
    USD("USD"), // US Dollar
    EUR("EUR"), // Euro
    INR("INR"), // Indian Rupee
    KZT("KZT"), // Kazakhstan Tenge
    CAD("CAD"), // Canadian Dollar
    KGS("KGS"), // Kyrgyzstan Som
    CNY("CNY"), // China Yuan
    MDL("MDL"), // Moldova Lei
    NOK("NOK"), // Norwegian Krone
    PLN("PLN"), // Polish Zloty
    RON("RON"), // Romanian Leu
    XDR("XDR"), // SDR
    SGD("SGD"), // Singapore Dollar
    TJS("TJS"), // Tajikistan Ruble
    TRY("TRY"), // Turkish Lira
    TMT("TMT"), // New Turkmenistan Manat
    UZS("UZS"), // Uzbekistan Sum
    UAH("UAH"), // Ukrainian Hryvnia
    CZK("CZK"), // Czech Koruna
    SEK("SEK"), // Swedish Krona
    CHF("CHF"), // Swiss Franc
    ZAR("ZAR"), // S.African Rand
    KRW("KRW"), // South Korean Won
    JPY("JPY"); // Japanese Yen

    private final String charCode;

    CurrencyUnit(String charCode){
        this.charCode = charCode;
    }


    public String getCharCode() {
        return charCode;
    }
}
