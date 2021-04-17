package com.my.toyproject.ipaccess.dto;

import com.my.toyproject.ipaccess.type.IpAccessType;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Setter
@Getter
@ToString
public class IpAccessUserDto {
	private String ip;
	private String name;
	private String hp;
	private int openYN;
	private IpAccessType type;
	private LocalDateTime updateTime;
	private LocalDateTime registerTime;

	public boolean isOpen(){
		return this.openYN == 1;
	}
}
