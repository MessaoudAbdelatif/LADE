function retapeMotDePass(){
  var motDePasse=document.registrationForm.motDePasse.value;
  var passwordConfirmation=document.registrationForm.passwordConfirmation.value;

  if(motDePasse==passwordConfirmation){
    return true;
  }
  else{
    alert("Veuillez saisir le même mot de passe et Confirmation mot de passe !");
    return false;
  }
}