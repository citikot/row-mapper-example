package ru.devmark.geo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.devmark.geo.model.City;
import ru.devmark.geo.model.CityRecord;
import ru.devmark.geo.repository.CityRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityRepository repository;

    public CityController(CityRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/params")
    public List<Map<String, Object>> getParamMaps() {
        return repository.getParamMaps();
    }

    @GetMapping("/beans")
    public List<City> getAllBeans() {
        return repository.getAllBeansOrderedByName();
    }

    @GetMapping("/records")
    public List<CityRecord> getAllRecords() {
        return repository.getAllRecordsOrderedByName();
    }

    @GetMapping("/names")
    public List<String> getAllNames() {
        return repository.getAllNames();
    }

    @GetMapping("/custom")
    public List<CityRecord> getCustomRecordsOrderedByName() {
        return repository.getCustomRecordsOrderedByName();
    }
}
