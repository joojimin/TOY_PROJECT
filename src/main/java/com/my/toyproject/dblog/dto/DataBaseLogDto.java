package com.my.toyproject.dblog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Getter
@Setter
public class DataBaseLogDto {

	private Integer id;
	private String url;
	private String request;
	private String response;
	private String etc;
	private String serverIp;
	private Integer serverPort;
	private LocalDateTime registerTime;

}
