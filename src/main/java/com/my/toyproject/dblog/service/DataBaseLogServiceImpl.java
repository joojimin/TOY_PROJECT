package com.my.toyproject.dblog.service;

import com.my.toyproject.dblog.domain.DataBaseLog;
import com.my.toyproject.dblog.domain.DataBaseLogRepository;
import com.my.toyproject.dblog.dto.DataBaseLogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DataBaseLogServiceImpl implements DataBaseLogService {

	private final DataBaseLogRepository dataBaseLogRepository;

	@Override
	public void insertLog(DataBaseLogDto dataBaseLogDto) {
		dataBaseLogRepository.save(dataBaseLogDto.toDataBaseLog());
	}
}
