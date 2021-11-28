package by.bsuir.task.repository;

import by.bsuir.task.exception.DataSourceException;
import by.bsuir.task.query.CustomQuery;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface Repository<T> {

    Optional<T> query(CustomQuery customQuery) throws DataSourceException;

    List<T> queryAll(CustomQuery customQuery) throws DataSourceException;

    void save(T item) throws DataSourceException;

    String getTableName();

    Map<String, Object> getFields(T item);
}
