package web.service;



import web.models.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();

    User getUser(long id);

    User getUserByLogin(String login);

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

//    List<Role> getAllRoles();

    User getUserById(Long id);
}
