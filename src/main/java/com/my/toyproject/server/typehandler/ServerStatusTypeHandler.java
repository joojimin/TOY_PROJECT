package com.my.toyproject.server.typehandler;

import com.my.toyproject.server.type.ServerStatusType;
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
public class ServerStatusTypeHandler extends BaseTypeHandler<ServerStatusType> {

	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, ServerStatusType serverStatusType, JdbcType jdbcType) throws SQLException {
		preparedStatement.setInt(i, serverStatusType.getCode());
	}

	@Override
	public ServerStatusType getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return ServerStatusType.valueOf(resultSet.getInt(s));
	}

	@Override
	public ServerStatusType getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return ServerStatusType.valueOf(resultSet.getInt(i));
	}

	@Override
	public ServerStatusType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return ServerStatusType.valueOf(callableStatement.getInt(i));
	}
}
