package by.bsuir.task.query.user;

import by.bsuir.task.domain.entity.Role;
import by.bsuir.task.query.CustomQuery;

import java.util.Collections;
import java.util.List;

public class FindByRoleQuery implements CustomQuery {

    private final Role role;

    public FindByRoleQuery(Role role) {
        this.role = role;
    }

    @Override
    public String toSql() {
        return "WHERE role = ?";
    }

    @Override
    public List<Object> getParameters() {
        return Collections.singletonList(role);
    }
}
