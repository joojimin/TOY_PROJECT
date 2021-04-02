package com.my.toyproject.ipaccess.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class IpAccessUserDto {
	private String ip;
	private String name;
	private String hp;
	private String updateTime;
	private String registerTime;
}
