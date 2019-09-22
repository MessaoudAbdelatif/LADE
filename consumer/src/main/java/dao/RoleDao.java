package dao;

import entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
  Role findRolesByRoleContains(String role);

}
