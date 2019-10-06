# Les Amis De L'escalade
Site communautaire au tour de l'escalade
Projet en cours d'élaboration.
Ce site vous permettrait de consulter les sites d'escalades répertorier par la communauté, de pouvoir loué un Topos afin de vous préparer correctement avant une sortie, vous auriez aussi un espace personnel. 

#Déploiement

1 - Vérifier que vous avez bien Java 8 au minimum d'installé.

2 - Crée une base de donnée :
    Nom = db_lade
    DataSource URL = jdbc:postgresql://localhost:5432/db_lade
    utilisateur ID = admin_db_lade 
    MDP = 12345ABCDE
    
3 - Alimenter la base de donnée avec le fichier SQL:
    app/db/db_lade_backup.sql
    
4 - Executer : app/web/target/web-0.0.1-SNAPSHOT.jar
    
5 - Dans votre navigateur allez : http://localhost:8080/index

#Fake Compte Utilisateur

 compte avec le role administrateur (réserve pour les membres de l'association): 
    Pseudo : admin2
    MDP : 1234
    
 compte avec le role utilisateur:
    Pseudo: user2
    MDP : 1234
    
#Lien du projet
    Github : https://github.com/MessaoudAbdelatif/LADE
    Heroku : https://obscure-waters-92846.herokuapp.com/
 