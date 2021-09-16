package web.dao;


import org.springframework.stereotype.Repository;
import web.models.Role;

import java.util.List;
import java.util.Set;

public interface RoleDAO {
    Role getRoleByName(String name);

    Set<Role> getRolesFromText(String text);

    List<Role> getAllRoles();
}
