package kata.anthony.boot.service;

import kata.anthony.boot.model.User;
import kata.anthony.boot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }
}
