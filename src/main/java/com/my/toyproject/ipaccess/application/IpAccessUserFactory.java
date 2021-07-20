package com.my.toyproject.ipaccess.application;

import com.my.toyproject.ipaccess.domain.IpAccessUser;
import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.List;

@Component
public class IpAccessUserFactory {

    private Map<String, IpAccessUserDto> ipAccessFilterMap;

    public void load(List<IpAccessUser> ipAccessUsers) {
        ipAccessFilterMap = ipAccessUsers.stream()
                                         .filter(IpAccessUser::isOpen)
                                         .map(this::convertToIpAccessUserDto)
                                         .collect(Collectors.toUnmodifiableMap(IpAccessUserDto::getIp,
																			   Function.identity()));
    }

    private IpAccessUserDto convertToIpAccessUserDto(IpAccessUser ipAccessUser) {
        return IpAccessUserDto.builder()
                              .ip(ipAccessUser.getIpAccessUserPK().getIp())
                              .name(ipAccessUser.getIpAccessUserPK().getName())
                              .hp(ipAccessUser.getPhoneNumber())
                              .openYN(ipAccessUser.getOpenYN())
                              .type(ipAccessUser.getType())
                              .registerTime(ipAccessUser.getRegisterTime())
                              .updateTime(ipAccessUser.getUpdateTime())
                              .build();
    }

    public Optional<IpAccessUserDto> getIpAccessUserDto(final String key) {
        return Optional.ofNullable(ipAccessFilterMap.get(key));
    }

}
