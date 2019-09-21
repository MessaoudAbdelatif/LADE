function retapeMotDePass(){
  var motDePasse=document.registrationForm.motDePasse.value;
  var confirmationMdp=document.registrationForm.confirmationMdp.value;

  if(motDePasse==confirmationMdp){
    return true;
  }
  else{
    alert("Veuillez saisir le même mot de passe et Confirmation mot de passe !");
    return false;
  }
}