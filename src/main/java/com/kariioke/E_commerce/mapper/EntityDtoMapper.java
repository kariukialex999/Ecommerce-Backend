package com.kariioke.E_commerce.mapper;

import com.kariioke.E_commerce.dto.*;
import com.kariioke.E_commerce.entity.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {

    //to map the user entity to the dto
    public UserDto mapUserToDtoBasic(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().name());
        userDto.setName(user.getName());
        return userDto;
    }

    //address to dto basic
    public AddressDto mapAddressDtoBasic(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setStreet(address.getStreet());
        addressDto.setCountry(address.getCountry());
        addressDto.setZipcode(address.getZipcode());
        return addressDto;
    }

    //category to dto basic
    public CategoryDto mapCategoryDtoBasic(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    // orderItem to dto basic
    public OrderItemDto mapOrderItemDtoBasic(OrderItem orderItem) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItem.getId());
        orderItemDto.setStatus(orderItem.getStatus().name());
        orderItem.setPrice(orderItem.getPrice());
        orderItem.setQuantity(orderItem.getQuantity());
        orderItem.setCreatedAt(orderItem.getCreatedAt());
        return orderItemDto;
    }

    //product to dto mapping
    public ProductDto mapProductDtoBasic(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setImageUrl(product.getImageUrl());
        return productDto;
    }

    //user to dto plus address mapping
    public UserDto mapUserDtoPlusAddress(User user) {
        UserDto userDto = mapUserToDtoBasic(user);
        if(user.getAddress() != null) {
            AddressDto addressDto = mapAddressDtoBasic(user.getAddress());
            userDto.setAddress(addressDto);
        }
        return userDto;
    }

    //orderItem to dto plus product
    public OrderItemDto mapOrderItemDtoPlusProduct(OrderItem orderItem) {
        OrderItemDto orderItemDto = mapOrderItemDtoBasic(orderItem);

        if(orderItem.getProduct() != null) {
            ProductDto productDto = mapProductDtoBasic(orderItem.getProduct());
            orderItemDto.setProduct(productDto);
        }
        return orderItemDto;
    }
    //orderItem to dto plus product and user.
    public OrderItemDto mapOrderItemDtoPlusProductAndUser(OrderItem orderItem) {
        OrderItemDto orderItemDto = mapOrderItemDtoPlusProduct(orderItem);
            if(orderItem.getUser() != null) {
                UserDto userDto = mapUserDtoPlusAddress(orderItem.getUser());
                orderItemDto.setUser(userDto);
            }
        return orderItemDto;
    }
    //user to dto plus address and orderItem history
    public UserDto mapUserToDtoPlusAddressAndOrderHistory(User user) {
        UserDto userDto = mapUserDtoPlusAddress(user);
            if(user.getOrderItemList() != null && user.getOrderItemList().isEmpty()) {
                userDto.setOrderItemList(user.getOrderItemList()
                        .stream()
                        .map(this::mapOrderItemDtoPlusProduct)
                        .collect(Collectors.toList()));
            }

            return userDto;
    }
}
