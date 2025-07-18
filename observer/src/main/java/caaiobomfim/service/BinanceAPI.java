package caaiobomfim.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BinanceAPI {

    public float getLastPrice() {
        Random random = new Random();
        return random.nextFloat() * 100000;
    }
}
