package dao;

import entities.SiteEscalade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SiteEscaladeDao extends JpaRepository<SiteEscalade, Long> {

  Page<SiteEscalade> findByNomContainsIgnoreCaseOrderByNom(String sei, Pageable pageable);

  Page<SiteEscalade> findByVilleProximiteContainsIgnoreCase(String sei, Pageable pageable);

  Page<SiteEscalade> findByLieuContainsIgnoreCase(String sei, Pageable pageable);

}