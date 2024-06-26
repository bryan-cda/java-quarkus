package br.com.test.quarkus.repository;


import br.com.test.quarkus.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
