package ua.training.model.entity.builder;

import ua.training.model.entity.User;

public class UserBuilder {
    private User user = new User();

    public UserBuilder() {
    }

    public UserBuilder setId(int id) {
        user.setId(id);
        return this;
    }

    public UserBuilder setUsername(String name) {
        user.setUsername(name);
        return this;
    }

    public UserBuilder setPassword(String password) {
        user.setPassword(password);
        return this;
    }

    public UserBuilder setRole(User.Role role) {
        user.setRole(role);
        return this;
    }

    public User buildUser() { return user; }
}
