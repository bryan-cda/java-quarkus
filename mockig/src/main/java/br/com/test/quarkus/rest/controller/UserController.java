package br.com.test.quarkus.rest.controller;

import br.com.test.quarkus.domain.User;
import br.com.test.quarkus.repository.UserRepository;
import br.com.test.quarkus.request.CreateUserRequest;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User user){
        userRepository.save(user);
        return Response.ok(user).build();
    }
}
