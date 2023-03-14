package ua.hillel.service;

import ua.hillel.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInMemoryService implements UserService {
    private List<User> users = new ArrayList<>() {{
        add(new User("John", 1));
        add(new User("Bob", 2));
        add(new User("Alice", 3));
    }};

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(int id) {
        return users.stream().filter(u -> u.getId() == id)
                .findFirst()
                .get();
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(int id, User user) {
        User exisitingUser = users.stream().filter(u -> u.getId() == id).findFirst().get();
        if (exisitingUser != null) {
            exisitingUser.setName(user.getName());
        }
    }

    @Override
    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }

    @Override
    public List<User> searchUsers(String q, Integer maxResults) {
        if (maxResults == null) {
            maxResults = Integer.MAX_VALUE;
        }
        return users.stream()
                .filter(u -> u.getName().toLowerCase().contains(q.toLowerCase()))
                .limit(maxResults)
                .collect(Collectors.toList());
    }
}
