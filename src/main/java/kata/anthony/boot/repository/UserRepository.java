package kata.anthony.boot.repository;

import kata.anthony.boot.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    void deleteById(Long id);
}
