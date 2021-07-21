package com.my.toyproject.server.infrastructure;

import com.my.toyproject.server.domain.ServerStatusType;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ServerStatusTypeToIntegerConverter implements AttributeConverter<ServerStatusType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ServerStatusType serverStatusType) {
        return null;
    }

    @Override
    public ServerStatusType convertToEntityAttribute(Integer integer) {
        return null;
    }
}
