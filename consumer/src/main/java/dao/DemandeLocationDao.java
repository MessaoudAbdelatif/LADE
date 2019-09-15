package dao;

import entities.DemandeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DemandeLocationDao extends JpaRepository<DemandeLocation, Long> {

}
