package dao;

import entities.DemandeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeLocationDao extends JpaRepository<DemandeLocation, Long> {

}
