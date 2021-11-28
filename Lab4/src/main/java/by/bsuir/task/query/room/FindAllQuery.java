package by.bsuir.task.query.room;

import by.bsuir.task.query.CustomQuery;

import java.util.Collections;
import java.util.List;

public class FindAllQuery implements CustomQuery {

    @Override
    public String toSql() {
        return "";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}
