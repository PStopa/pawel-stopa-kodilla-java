package com.kodilla.patterns2.facade.api;

public final class ItemDto {
    private final Long productId;
    private final double quantity;

    public ItemDto(final Long productId, final double quentity) {
        this.productId = productId;
        this.quantity = quentity;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQuantity() {
        return quantity;
    }
}
