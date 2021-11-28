package by.bsuir.task.query.user;

import by.bsuir.task.query.CustomQuery;

import java.util.Arrays;
import java.util.List;

public class FindByUsernameAndPasswordQuery implements CustomQuery {

    private final String username;
    private final String password;

    public FindByUsernameAndPasswordQuery(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toSql() {
        return "where username = ? AND password = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Arrays.asList(username, password);
    }

}
