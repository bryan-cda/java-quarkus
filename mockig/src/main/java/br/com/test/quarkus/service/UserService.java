package br.com.test.quarkus.service;

import br.com.test.quarkus.domain.User;
import br.com.test.quarkus.repository.UserRepository;
import jakarta.enterprise.context.RequestScoped;

import java.util.Optional;

@RequestScoped
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Iterable<User> listUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(User user) throws Exception {
        User foundUser = userRepository.findById(user.getId()).orElseThrow(Exception::new);
        foundUser.setUserPassword(user.getUserPassword());
        foundUser.setUsername(user.getUsername());
        foundUser.setLastName(user.getLastName());
        foundUser.setFirstName(user.getFirstName());
        foundUser.setBirthday(user.getBirthday());
        return userRepository.save(foundUser);
    }
}
