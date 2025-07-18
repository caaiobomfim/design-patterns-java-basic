package caaiobomfim.service;

public class NewsPlatform implements BitcoinPriceObserver{
    @Override
    public void update(float price) {
        System.out.println("NEWS: New Price: " + price);
    }
}
