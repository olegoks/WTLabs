package by.bsuir.task.query.room;

import by.bsuir.task.query.CustomQuery;

import java.util.Collections;
import java.util.List;

public class FindFreeQuery implements CustomQuery {

    public FindFreeQuery() {
    }

    @Override
    public String toSql() {
        return "WHERE occupied = 'false'";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.emptyList();
    }
}
