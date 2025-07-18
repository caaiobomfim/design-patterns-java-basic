package caaiobomfim.service;

public class BitcoinPriceLogger implements BitcoinPriceObserver{
    @Override
    public void update(float price) {
        System.out.println("LOG: New Price: " + price);
    }
}
