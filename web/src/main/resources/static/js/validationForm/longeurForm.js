function validateform(){
  var nom=document.longeurForm.nom.value;

  if (nom==null || nom==""){
    alert("Votre Longeur doit avoir un Nom !");
    return false;
  }
}