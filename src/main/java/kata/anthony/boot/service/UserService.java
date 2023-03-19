package kata.anthony.boot.service;

import kata.anthony.boot.model.User;

import java.util.List;

public interface UserService {
    void save(User user);

    User findById(Long id);

    void delete(Long id);

    List<User> findAll();
}
