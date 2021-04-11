package com.my.toyproject.ipaccess.factory;

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

	public void load(List<IpAccessUserDto> ipAccessUserDtoList){
		ipAccessFilterMap = ipAccessUserDtoList.stream()
											   .filter(IpAccessUserDto::isOpen)
											   .collect(Collectors.toUnmodifiableMap(IpAccessUserDto::getIp, Function.identity()));
	}

	public Optional<IpAccessUserDto> getIpAccessUserDto(final String key){
		return Optional.ofNullable(ipAccessFilterMap.get(key));
	}

}
