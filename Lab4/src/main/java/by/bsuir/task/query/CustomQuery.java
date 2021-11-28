package by.bsuir.task.query;

import java.util.List;

public interface CustomQuery {
    String toSql();

    List<Object> getParameters();
}
