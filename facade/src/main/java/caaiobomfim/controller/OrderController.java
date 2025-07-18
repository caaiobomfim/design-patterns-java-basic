package caaiobomfim.controller;

import caaiobomfim.OrderFacade;
import caaiobomfim.dto.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody Request request) {

        orderFacade.processOrder(request);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Pedido realizado com sucesso");

        return ResponseEntity.ok(response);
    }
}