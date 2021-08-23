package web.dao;

import web.models.Role;
import web.models.User;

import java.util.List;
import java.util.Set;

public interface UserDao {

    Role getRoleByName(String name);

    Set<Role> getRolesFromText(String text);

    List<User> getAllUsers();

    User getUser(long id);

    User getUserByLogin(String login);

    void addUser(User user);

    void deleteUser(Long id);

    void updateUser(User user);

    List<Role> getAllRoles();

    User getUserById(Long id);
}
