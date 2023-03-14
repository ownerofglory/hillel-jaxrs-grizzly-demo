package ua.hillel.service;

import ua.hillel.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    void addUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int id);
    List<User> searchUsers(String q, Integer maxResults);
}
