package ru.devmark.geo.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.devmark.geo.model.CityRecord;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<CityRecord> {

    @Override
    public CityRecord mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getInt("id");
        return new CityRecord(
                id,
                String.format("%s (%s)", rs.getString("name"), id),
                rs.getInt("population")
        );
    }
}