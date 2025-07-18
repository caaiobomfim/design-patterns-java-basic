package caaiobomfim;

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

    private final PaymentProcessor paymentProcessor;
    private final Notifier notifier;
    private final InventoryManager inventoryManager;
    private final ShippingService shippingService;

    public OrderController(PaymentProcessor paymentProcessor, Notifier notifier, InventoryManager inventoryManager, ShippingService shippingService) {
        this.paymentProcessor = paymentProcessor;
        this.notifier = notifier;
        this.inventoryManager = inventoryManager;
        this.shippingService = shippingService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createOrder(@RequestBody Request request) {

        Float amount = request.amount();
        String email = request.email();
        String productId = request.productId();
        Integer quantity = request.quantity();

        paymentProcessor.processPayment(amount);
        notifier.sendConfirmation(email);
        inventoryManager.updateStock(productId, quantity);
        shippingService.initiateShipping(request);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Pedido realizado com sucesso");

        return ResponseEntity.ok(response);
    }
}