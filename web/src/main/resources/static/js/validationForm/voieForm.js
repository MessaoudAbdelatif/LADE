function validateform(){
  var nom=document.voieForm.nom.value;

  if (nom==null || nom==""){
    alert("Votre  voie doit avoir un Nom !");
    return false;
  }
}