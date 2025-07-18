package caaiobomfim;

import caaiobomfim.dto.Request;
import caaiobomfim.service.InventoryManager;
import caaiobomfim.service.Notifier;
import caaiobomfim.service.PaymentProcessor;
import caaiobomfim.service.ShippingService;
import org.springframework.stereotype.Component;

@Component
public class OrderFacade {

    private final PaymentProcessor paymentProcessor;
    private final Notifier notifier;
    private final InventoryManager inventoryManager;
    private final ShippingService shippingService;

    public OrderFacade(PaymentProcessor paymentProcessor,
                       Notifier notifier,
                       InventoryManager inventoryManager,
                       ShippingService shippingService) {
        this.paymentProcessor = paymentProcessor;
        this.notifier = notifier;
        this.inventoryManager = inventoryManager;
        this.shippingService = shippingService;
    }

    public void processOrder(Request request){

        Float amount = request.amount();
        String email = request.email();
        String productId = request.productId();
        Integer quantity = request.quantity();

        paymentProcessor.processPayment(amount);
        notifier.sendConfirmation(email);
        inventoryManager.updateStock(productId, quantity);
        shippingService.initiateShipping(request);
    }
}
