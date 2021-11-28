package by.bsuir.task.query;

import by.bsuir.task.query.CustomQuery;

import java.util.Collections;
import java.util.List;

public class FindByIdQuery implements CustomQuery {

    private final Integer id;

    public FindByIdQuery(Integer id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return "where id = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(id);
    }
}
