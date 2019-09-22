package dao;

import entities.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
  List<Role> findRolesByRoleContains(String role);

}
