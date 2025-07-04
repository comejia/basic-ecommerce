package com.comejia.ecommerce.models.mappers;

import com.comejia.ecommerce.models.dtos.ItemResponseDto;
import com.comejia.ecommerce.models.entities.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemResponseDto toDto(Item item) {
        ItemResponseDto dto = new ItemResponseDto();
        dto.setProductId(item.getProduct().getId());
        dto.setName(item.getProduct().getName());
        dto.setPrice(item.getProduct().getPrice());
        dto.setQuantity(item.getQuantity());
        dto.setSubTotal(item.getTotal());
        return dto;
    }
}
