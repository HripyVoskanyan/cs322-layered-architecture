package am.cs322;

import am.cs322.model.UserDTO;

public interface UserService {

    public UserDTO createUser(String firstName, String lastName);

}