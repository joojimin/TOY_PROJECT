package com.my.toyproject.server.mapper;

import com.my.toyproject.server.vo.ServerStatusVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ServerStatusMapper {
	List<ServerStatusVo> selectAll();
}
