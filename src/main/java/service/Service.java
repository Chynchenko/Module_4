package service;

import DTO.StatisticsDTO;
import factory.Factory;
import model.Detail;
import repository.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class Service {
    private final Repository repository;
    private static Service instance;

    private Service(final Repository repository) {
        this.repository = repository;
    }

    public static Service getInstance() throws SQLException {
        if (instance == null) {
            instance = new Service(Repository.getInstance());
        }
        return instance;
    }

    public Detail createDetail() throws InterruptedException {
        Factory factory = new Factory();
        Detail detail = factory.createDetail();
        repository.save(detail);
        return detail;
    }

    public Optional<Detail> getById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Invalid id");
        } else {
            return repository.getById(id);
        }
    }

    public StatisticsDTO getStatistics() {
        return repository.getStatistics();
    }

    public List<String> getAllId() {
        return repository.getAllId();
    }
}