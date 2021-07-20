package com.my.toyproject.ipaccess.dto;

import com.my.toyproject.ipaccess.domain.IpAccessType;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@ToString
public class IpAccessUserDto {
	private String ip;
	private String name;
	private String hp;
	private Boolean openYN;
	private IpAccessType type;
	private LocalDateTime updateTime;
	private LocalDateTime registerTime;


	@Builder
	public IpAccessUserDto(String ip, String name, String hp, Boolean openYN,
						   IpAccessType type, LocalDateTime updateTime,
						   LocalDateTime registerTime) {
		this.ip = ip;
		this.name = name;
		this.hp = hp;
		this.openYN = openYN;
		this.type = type;
		this.updateTime = updateTime;
		this.registerTime = registerTime;
	}
}
