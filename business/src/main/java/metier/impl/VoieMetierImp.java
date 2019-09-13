package metier.impl;

import dao.VoieDao;
import entities.Voie;
import java.util.Collection;
import metier.contract.VoieMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoieMetierImp implements VoieMetier {


  private VoieDao voieDao;

  @Autowired
  public VoieMetierImp(VoieDao voieDao) {
    this.voieDao = voieDao;
  }

  @Override
  public Voie ajouterVoie(Voie voie) {
    voieDao.save(voie);
    return voie;
  }

  @Override
  public Voie consulterUneVoie(Long id){
  Voie voieSelected = voieDao.getOne(id);
  if (voieSelected == null) {
    throw new RuntimeException("Voie Introuvable");
  }
  return voieSelected;
}

  @Override
  public Collection<Voie> afficherListeToutesVoieBySecteur() {
    return null;
  }
}
