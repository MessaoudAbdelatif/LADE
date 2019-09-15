package dao;

import entities.Longeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface LongeurDao extends JpaRepository<Longeur, Long> {

}
