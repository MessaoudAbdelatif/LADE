function validateform(){
  var nom=document.secteurForm.nom.value;

  if (nom==null || nom==""){
    alert("Votre secteur doit avoir un Nom !");
    return false;
  }else if(nom.length<3){
    alert("Nom doit contenir au moins 3 caractères");
    return false;
  }
}