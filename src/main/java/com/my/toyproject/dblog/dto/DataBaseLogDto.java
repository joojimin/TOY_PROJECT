package com.my.toyproject.dblog.dto;

import com.my.toyproject.dblog.application.DataBaseLogType;
import com.my.toyproject.dblog.domain.DataBaseLog;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Accessors(chain = true)
@Getter
@Setter
public class DataBaseLogDto {

	private DataBaseLogType type;
	private String url;
	private String request;
	private String response;
	private String etc;
	private String serverIp;
	private Integer serverPort;
	private LocalDateTime registerTime;


	public DataBaseLog toDataBaseLog() {
		return DataBaseLog.builder()
						  .type(this.type)
						  .url(this.url)
						  .request(this.request)
						  .response(this.response)
						  .etc(this.etc)
						  .serverIp(this.serverIp)
						  .serverPort(this.serverPort)
						  .registerTime(this.registerTime)
						  .build();
	}
}
