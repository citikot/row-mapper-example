package ru.devmark.geo.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.ColumnMapRowMapper;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.devmark.geo.mapper.CityRowMapper;
import ru.devmark.geo.model.City;
import ru.devmark.geo.model.CityRecord;

import java.util.List;
import java.util.Map;

@Repository
public class CityRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CityRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

public List<Map<String, Object>> getParamMaps() {
    return jdbcTemplate.query(
            "select id, name, population from city order by name",
            new ColumnMapRowMapper()
    );
}

public List<City> getAllBeansOrderedByName() {
    return jdbcTemplate.query(
            "select id, name, population from city order by name",
            new BeanPropertyRowMapper<>(City.class)
    );
}

public List<CityRecord> getAllRecordsOrderedByName() {
    return jdbcTemplate.query(
            "select id, name, population from city order by name",
            new DataClassRowMapper<>(CityRecord.class)
    );
}

    public List<String> getAllNames() {
        return jdbcTemplate.query(
                "select name from city order by name",
                new SingleColumnRowMapper<>(String.class)
        );
    }

    public List<CityRecord> getCustomRecordsOrderedByName() {
        return jdbcTemplate.query(
                "select id, name, population from city order by name",
                new CityRowMapper()
        );
    }
}
