package com.my.toyproject.ipaccess.infrastructure;

import com.my.toyproject.ipaccess.domain.IpAccessType;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class IpAccessTypeToIntegerConverter implements AttributeConverter<IpAccessType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(IpAccessType attribute) {
        if (!Objects.isNull(attribute)) {
            return attribute.getCode();
        }
        return null;
    }

    @Override
    public IpAccessType convertToEntityAttribute(Integer attribute) {
        if (!Objects.isNull(attribute)) {
            return IpAccessType.valueOf(attribute);
        }
        return null;
    }
}
