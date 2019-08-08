package dao;

import entities.Longeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongeurDao extends JpaRepository<Longeur, String> {

}
