package com.my.toyproject.ipaccess.service;

import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import com.my.toyproject.ipaccess.factory.IpAccessUserFactory;
import com.my.toyproject.ipaccess.mapper.IpAccessMapper;
import com.my.toyproject.ipaccess.type.IpAccessType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IpAccessService {

	private final IpAccessMapper ipAccessMapper;
	private final IpAccessUserFactory ipAccessUserFactory;

	@PostConstruct
	public void postConstruct(){
		load();
	}

	public void load(){
		ipAccessUserFactory.load(ipAccessMapper.selectAll());
	}

	public boolean isAccess(final String ip){
		Optional<IpAccessUserDto> ipAccessUserDtoOptional = ipAccessUserFactory.getIpAccessUserDto(ip);
		if(ipAccessUserDtoOptional.isEmpty()){
			return false;
		}

		return IpAccessType.canAccess(ipAccessUserDtoOptional.get().getIpAccessType());
	}

	public boolean isBlock(final String ip){
		Optional<IpAccessUserDto> ipAccessUserDtoOptional = ipAccessUserFactory.getIpAccessUserDto(ip);
		if(ipAccessUserDtoOptional.isEmpty()){
			return true;
		}

		return IpAccessType.isBlock(ipAccessUserDtoOptional.get().getIpAccessType());
	}
}
