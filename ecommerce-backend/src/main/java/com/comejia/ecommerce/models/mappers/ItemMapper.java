package com.comejia.ecommerce.models.mappers;

import com.comejia.ecommerce.models.dtos.responses.ItemResponseDto;
import com.comejia.ecommerce.models.entities.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemResponseDto toDto(Item item) {
        return new ItemResponseDto(
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getProduct().getPrice(),
                item.getQuantity(),
                item.getTotal()
        );
    }
}
