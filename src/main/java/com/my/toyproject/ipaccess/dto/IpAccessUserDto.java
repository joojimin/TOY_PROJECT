package com.my.toyproject.ipaccess.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@ToString
public class IpAccessUserDto {
	private String ip;
	private String name;
	private String hp;
	private String openYN;
	private String updateTime;
	private String registerTime;
}
