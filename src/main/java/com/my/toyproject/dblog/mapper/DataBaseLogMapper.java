package com.my.toyproject.dblog.mapper;

import com.my.toyproject.dblog.dto.DataBaseLogDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DataBaseLogMapper {
	void insertLog(DataBaseLogDto dataBaseLogDto);
}
