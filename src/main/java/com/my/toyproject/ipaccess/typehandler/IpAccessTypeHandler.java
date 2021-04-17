package com.my.toyproject.ipaccess.typehandler;

import com.my.toyproject.ipaccess.type.IpAccessType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.TINYINT)
@Component
public class IpAccessTypeHandler extends BaseTypeHandler<IpAccessType> {
	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, IpAccessType serverStatusType, JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(i, serverStatusType.getCode());
	}

	@Override
	public IpAccessType getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return IpAccessType.valueOf(resultSet.getInt(s));
	}

	@Override
	public IpAccessType getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return IpAccessType.valueOf(resultSet.getInt(i));
	}

	@Override
	public IpAccessType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return IpAccessType.valueOf(callableStatement.getInt(i));
	}
}
