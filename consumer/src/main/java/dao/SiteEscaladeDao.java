package dao;

import entities.SiteEscalade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteEscaladeDao extends JpaRepository<SiteEscalade, String> {

}
