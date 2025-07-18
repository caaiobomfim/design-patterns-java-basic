package caaiobomfim.service;

public class InvestorNotifier implements BitcoinPriceObserver{
    @Override
    public void update(float price) {
        System.out.println("NOTIFICATION: New Price: " + price);
    }
}
