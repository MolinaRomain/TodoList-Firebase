# TodoList-Firebase
> Projet pour Ynov : Développement Mobile 
> 
> Réalisé par : `BONNIN François & MOLINA Romain`
  
<img src="https://i.goopics.net/w5d38a.png" height="100px">

## Outils et technologies
* **Android Studio :** développer en Java
* **Firebase :** Afin de préserver les données et d'y avoir accès n'importe où

## Structure de l'application
Concernant l'inscription et la connexion nous avons deux fichiers :

* Register
* Login

Dans Firebase nous avons uniquement autorisé la connection par adresse mail.
Une fois l'enregistrement effectué, vous serez automatiquement redirigé vers votre liste.
> Afin de ne pas quitter accidentellement l'application, nous avons ajouté une boite de dialogue préventive lorsque nous appuyons sur le bouton _retour_

## Votre liste
Votre liste contient toutes vos tâches, vous pouvez créer, modifier et supprimer une tâche.
La liste sera automatiquement mise à jour sur Firebase.

## Une tâche
Une tâche est composée de deux parties :

* Le titre de la tâche
* La description de la tache pour plus de détail

Exemple :

> Titre : faire les courses
> 
> Description : Topinambour, daïkon, oignon rocambole, jalapenos...

## Design et réalisation de l'application
Le design de l'application s'est inspiré du [design system Pegasus](https://pegasusdesignsystem.com), le logo a aussi été créé sur Figma par François.
