package com.my.toyproject.dblog.service;

import com.my.toyproject.dblog.dto.DataBaseLogDto;
import com.my.toyproject.dblog.mapper.DataBaseLogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DataBaseLogServiceImpl implements DataBaseLogService {

	private final DataBaseLogMapper dataBaseLogMapper;

	@Override
	public void insertLog(DataBaseLogDto dataBaseLogDto) {
		dataBaseLogMapper.insertLog(dataBaseLogDto);
	}
}
