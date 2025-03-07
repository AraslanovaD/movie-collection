package movie.collection.service;

import movie.collection.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();
    Role get(int id);
    Role save(Role role);
    void delete(int id);
}
