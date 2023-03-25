# JobSearchApp

L'application de recherche d'offre d'emploi permet de visualiser les CVs enregistrés dans la base de données et(ajout personnel) de réaliser des opérations CRUD sur un CV.

<h3>Fonctionnalités</h3>
♣ Affichage de la liste des CVs enregistrés dans la base de données (fonctionnalité attendue) <br>
♣ Ajout d'un nouveau CV (mon ajout)<br>
♣ Lecture d'un CV existant (mon ajout)<br>
♣ Modification d'un CV existant (mon ajout)<br>
♣ Suppression d'un CV existant (mon ajout)
  
<h3>Partie Backend</h3>
♣ La partie backend de l'application a été développée sur IntelliJ et utilise une base de données contenant une seule table 'cv' ayant les propriétés suivantes: nom, prenom, age, adresse, email, telephone, specialite, niveauEtude, experienceProfessionnelle.<br> 
♣ Les technologies utilisées pour le développement sont Spring Boot, Hibernate et MySQL.<br> 
♣ Les API ont été testées avec Postman et Swagger. XAMPP Control Panel a été utilisé pour lancer le serveur MySQL.

<h3>Partie Frontend</h3>
La partie frontend de l'application a été développée sur Android Studio. L'application dispose de 3 pages :<br>

♣ <b><i> Accueil : </i></b> affiche le nom de l'application, une description et une image. Il y a également deux boutons pour accéder aux autres pages.<br> 
♣ <b><i> Liste des CVs : </i></b> affiche la liste des CVs enregistrés dans la base de données.<br> 
♣ <b><i> Opérations CRUD : </i></b> permet de réaliser des opérations CRUD sur un CV.

<h3>Captures d'écran</h3>

![Cap0](https://user-images.githubusercontent.com/69348811/227717211-12ce1ee7-7e42-4e63-b1b2-e9f7ba21a8cb.png)


![Cap1](https://user-images.githubusercontent.com/69348811/227716928-a4f76bf3-e16a-4bea-925e-67f642460fcd.png)


![Cap2](https://user-images.githubusercontent.com/69348811/227716931-7717c132-96fb-4eb8-aa56-9fd47493c835.png)


![Cap3](https://user-images.githubusercontent.com/69348811/227716933-252969d7-b035-464f-9d60-782e8cdf5c56.png)


![Cap4](https://user-images.githubusercontent.com/69348811/227716934-7965b897-3f0c-4d8a-a68d-ee508de27c6c.png)


![Cap5](https://user-images.githubusercontent.com/69348811/227716935-114fc102-7119-4188-9cb6-580c6c771d02.png)


![Cap6](https://user-images.githubusercontent.com/69348811/227716936-d5f5a7bc-09af-4d7f-9a54-547b490fcf18.png)


![Cap7](https://user-images.githubusercontent.com/69348811/227716938-e9cd3e1d-e471-49bc-b3ad-72f6017cec70.png)


<table>
  <td> <img src='https://user-images.githubusercontent.com/69348811/227716939-06940a0d-5847-458e-94f8-7034d5aa037e.png'> </img> </td>
  <td> <img src='https://user-images.githubusercontent.com/69348811/227716940-a60df35f-66ad-453a-9cbe-ce707f26eac3.png'> </img> </td>
  <td> <img src='https://user-images.githubusercontent.com/69348811/227716941-59cb6163-b4ec-4849-96ae-49eca2623c54.png'> </img> </td>  
</table>
  
  
<h3>Installation</h3>
♣ Pour installer l'application, vous pouvez cloner le repository GitHub sur votre machine :<br>
git clone https://github.com/Bessel7/jobSearchMobileApp.git<br>
♣ Ensuite, vous pouvez importer la partie backend sur IntelliJ et la partie frontend sur Android Studio. <br>Assurez-vous de bien configurer la connexion à la base de données dans la partie backend avant de lancer l'application.

<h3>Contribuer</h3>
Si vous souhaitez contribuer à l'application, vous pouvez ouvrir une pull request sur GitHub. Nous serons ravis de recevoir vos suggestions d'amélioration ou de nouvelles fonctionnalités.

<h3>Licence</h3>
Ce projet est sous licence MIT. Vous êtes libre de le modifier et de l'utiliser à des fins commerciales ou non commerciales. Veuillez consulter le fichier LICENSE pour plus d'informations.
