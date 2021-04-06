package com.my.toyproject.ipaccess.service;

import com.my.toyproject.ipaccess.mapper.IpAccessMapper;
import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class IpAccessService {

	private final IpAccessMapper ipAccessMapper;
	private Map<String, IpAccessUserDto> ipAccessFilterMap;

	public IpAccessService(final IpAccessMapper ipAccessMapper){
		this.ipAccessMapper = ipAccessMapper;
		this.ipAccessFilterMap = load();
	}

	public void reload(){
		ipAccessFilterMap = load();
	}

	private Map<String, IpAccessUserDto> load(){
		return ipAccessMapper.selectAll()
							 .stream()
							 .collect(Collectors.toUnmodifiableMap(IpAccessUserDto::getIp, Function.identity()));
	}

	public boolean isAccess(final String ip){
		return ipAccessFilterMap.containsKey(ip);
	}

}
