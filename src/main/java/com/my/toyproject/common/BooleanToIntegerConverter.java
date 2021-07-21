package com.my.toyproject.common;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToIntegerConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null || !attribute) {
            return 0;
        }
        return 1;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer attribute) {
        if (attribute == null || attribute == 0) {
            return false;
        }
        return true;
    }
}
