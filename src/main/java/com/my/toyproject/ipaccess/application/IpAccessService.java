package com.my.toyproject.ipaccess.application;

import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import com.my.toyproject.ipaccess.domain.IpAccessUserRepository;
import com.my.toyproject.ipaccess.domain.IpAccessType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IpAccessService {

	private final IpAccessUserRepository ipAccessUserRepository;
	private final IpAccessUserFactory ipAccessUserFactory;

	@PostConstruct
	public void postConstruct(){
		load();
	}

	public void load(){
		ipAccessUserFactory.load(ipAccessUserRepository.findAll());
	}

	public boolean isAccess(final String ip){
		Optional<IpAccessUserDto> ipAccessUserDtoOptional = ipAccessUserFactory.getIpAccessUserDto(ip);
		if(ipAccessUserDtoOptional.isEmpty()){
			return false;
		}

		return IpAccessType.canAccess(ipAccessUserDtoOptional.get().getType());
	}

	public boolean isBlock(final String ip){
		Optional<IpAccessUserDto> ipAccessUserDtoOptional = ipAccessUserFactory.getIpAccessUserDto(ip);
		if(ipAccessUserDtoOptional.isEmpty()){
			return true;
		}

		return IpAccessType.isBlock(ipAccessUserDtoOptional.get().getType());
	}
}
