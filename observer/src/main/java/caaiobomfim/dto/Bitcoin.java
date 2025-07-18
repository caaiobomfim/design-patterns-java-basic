package caaiobomfim.dto;

public class Bitcoin {

    private float price = 0;

    public Bitcoin() {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        if (this.price != newPrice){
            this.price = newPrice;
        }
    }
}
