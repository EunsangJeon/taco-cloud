package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.model.UserDto;

public interface UserRepository extends CrudRepository<UserDto, Long> {
    UserDto findByUsername(String username);
}
