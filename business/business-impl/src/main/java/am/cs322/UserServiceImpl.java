package am.cs322;

import am.cs322.model.User;
import am.cs322.model.UserDTO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDTO createUser(String firstName, String lastName) {
        User createdUser = userRepository.save(new User(firstName, lastName));
        return new UserDTO(createdUser.getFirstName() + " " + createdUser.getLastName());
    }
}