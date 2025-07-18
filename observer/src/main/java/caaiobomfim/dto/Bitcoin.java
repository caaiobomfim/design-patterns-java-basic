package caaiobomfim.dto;

import caaiobomfim.service.BitcoinPriceObserver;

import java.util.ArrayList;
import java.util.List;

public class Bitcoin {

    private float price = 0;
    private final List<BitcoinPriceObserver> observers = new ArrayList<>();

    public Bitcoin() {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        if (this.price != newPrice){
            this.price = newPrice;
            notifyObservers();
        }
    }

    public void addObserver(BitcoinPriceObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (BitcoinPriceObserver observer : observers) {
            observer.update(this.price);
        }
    }
}