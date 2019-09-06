package metier;

import dao.VoieDao;
import entities.Voie;
import java.util.Collection;
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
  public Collection<Voie> afficherListeToutesVoieBySecteur() {
    return null;
  }
}
