package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Voie extends JpaRepository<entities.Voie, String> {

}
