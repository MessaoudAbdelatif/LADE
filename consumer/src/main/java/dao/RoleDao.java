package dao;

import entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleDao extends JpaRepository<Role, Integer> {
  Role findRolesByRoleContains(String role);

}
