package com.my.toyproject.dblog.typehandler;

import com.my.toyproject.dblog.type.DataBaseLogType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.VARCHAR)
@Component
public class DataBaseLogTypeHandler extends BaseTypeHandler<DataBaseLogType> {
	@Override
	public void setNonNullParameter(PreparedStatement preparedStatement, int i, DataBaseLogType serverStatusType, JdbcType jdbcType) throws SQLException {
		preparedStatement.setString(i, serverStatusType.getName());
	}

	@Override
	public DataBaseLogType getNullableResult(ResultSet resultSet, String s) throws SQLException {
		return DataBaseLogType.valueOf(resultSet.getString(s));
	}

	@Override
	public DataBaseLogType getNullableResult(ResultSet resultSet, int i) throws SQLException {
		return DataBaseLogType.valueOf(resultSet.getString(i));
	}

	@Override
	public DataBaseLogType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
		return DataBaseLogType.valueOf(callableStatement.getString(i));
	}
}
