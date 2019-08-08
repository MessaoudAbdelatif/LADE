package dao;

import entities.Topos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToposDao extends JpaRepository<Topos, String> {

}
