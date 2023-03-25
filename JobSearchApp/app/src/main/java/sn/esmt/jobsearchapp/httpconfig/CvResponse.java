package sn.esmt.jobsearchapp.httpconfig;

public class CvResponse {
    // CvResponse représente un objet de réponse JSON reçu par l'API.
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private String adresse;
    private String email;
    private String telephone;
    private String specialite;
    private String niveauEtude;
    private String experienceProfessionnelle;

    // Définition d'un constructeur avec paramètres
    public CvResponse(int id, String nom, String prenom, int age, String adresse, String email, String telephone, String specialite, String niveauEtude, String experienceProfessionnelle) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.specialite = specialite;
        this.niveauEtude = niveauEtude;
        this.experienceProfessionnelle = experienceProfessionnelle;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getNiveauEtude() {
        return niveauEtude;
    }

    public String getExperienceProfessionnelle() {
        return experienceProfessionnelle;
    }

    // Constructeur sans arguments
    public CvResponse() {
    }

}

