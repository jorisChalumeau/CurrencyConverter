package modele;

public class Currency {

    private final String name;
    private Double exchangeRate = 1.00000;
    private final String imagePath;

    public Currency(String name, Double exchangeRate){
        this.name = name;
        this.exchangeRate = exchangeRate;
        this.imagePath = FileManager.FLAGS_DIR_PATH+"/default.png";
    }

    public Currency(String name, Double exchangeRate, String imagePath){
        this.name = name;
        this.exchangeRate = exchangeRate;
        this.imagePath = imagePath;
    }

    public Currency(String name){
        this.name = name;
        this.imagePath = FileManager.FLAGS_DIR_PATH+"/default.png";
    }

    public String getName() {
        return name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getImagePath() {
        return imagePath;
    }
}
