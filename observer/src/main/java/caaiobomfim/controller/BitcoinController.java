package caaiobomfim.controller;

import caaiobomfim.dto.Bitcoin;
import caaiobomfim.service.BinanceAPI;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bitcoin")
public class BitcoinController {

    private final BinanceAPI binanceAPI;
    private final Bitcoin bitcoin = new Bitcoin();

    public BitcoinController(BinanceAPI binanceAPI){
        this.binanceAPI = binanceAPI;
    }

    @PostMapping("/update")
    public String updatePrice() {
        float latestPrice = binanceAPI.getLastPrice();
        bitcoin.setPrice(latestPrice);
        return "New price defined: " + bitcoin.getPrice();
    }
}