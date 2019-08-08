package dao;

import entities.MembreAssociation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemebreAssociationDao extends JpaRepository<MembreAssociation, String> {

}
