package by.bsuir.task.query.user;

import by.bsuir.task.query.CustomQuery;

import java.util.Collections;
import java.util.List;

public class FindByUsernameQuery implements CustomQuery {

    private final String username;

    public FindByUsernameQuery(String username) {
        this.username = username;
    }

    @Override
    public String toSql() {
        return "WHERE username=?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(username);
    }
}
