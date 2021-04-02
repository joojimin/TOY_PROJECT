package com.my.toyproject.ipaccess.mapper;

import com.my.toyproject.ipaccess.dto.IpAccessUserDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface IpAccessMapper {
	List<IpAccessUserDto> selectAll();
}
