package modele;

public class Currency {

    private String name;
    private Double exchangeRate = 1.00000;

    public Currency(String name, Double exchangeRate){
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public Currency(String name){
        this.name = name;
    }

    public Currency() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
