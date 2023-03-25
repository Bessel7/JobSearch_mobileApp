package sn.esmt.jobsearch.entities;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cv")
public class CVEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 150,nullable = false)
    private String nom;
    @Column(length = 150,nullable = false)
    private String prenom;
    @Column(length = 10,nullable = false)
    private int age;
    @Column(length = 150,nullable = false)
    private String adresse;
    @Column(length = 150,nullable = false,unique = true)
    private String email;
    @Column(length = 150,nullable = false)
    private String telephone;
    @Column(length = 150,nullable = false)
    private String specialite;
    @Column(length = 150,nullable = false)
    private String niveauEtude;
    @Column(length = 150,nullable = false)
    private String experienceProfessionnelle;

}
/*
 * Les annotations Lombok @Data, @NoArgsConstructor et @AllArgsConstructor
 * génèrent respectivement les méthodes getter/setter, le constructeur sans
 * argument et le constructeur avec tous les arguments pour les propriétés
 * de la classe.
 *
 * La propriété id est annotée avec @Id et @GeneratedValue pour générer
 * automatiquement sa valeur lors de la persistance en base de données.
 *
 * La classe est annotée avec @Entity pour être reconnue comme une entité
 * persistante par JPA.
 *
 * L'annotation @Table est utilisée pour spécifier le nom de la table à
 * laquelle la classe CVEntity sera mappée.
 */