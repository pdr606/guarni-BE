package com.dev.guarnibe.model.enums;


import com.dev.guarnibe.exceptions.InvalidException;
import com.dev.guarnibe.model.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public enum CategoryTypes {
    DRINKS(1),
    BEVERAGE(2),
    MAIN_COURSE(3),
    STARTS(4),
    SALADS(5),
    SANDWICHES(6),
    PIZZAS(7),
    VEGETARIAN(8);

    private final int code;

    public static CategoryTypes valueOf(int code){
        for(CategoryTypes value: CategoryTypes.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new InvalidException("Invalid Code");
    }

}
