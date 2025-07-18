package caaiobomfim.dto;

public record Request(
       Float amount,
       String email,
       String productId,
       Integer quantity
) {
}
