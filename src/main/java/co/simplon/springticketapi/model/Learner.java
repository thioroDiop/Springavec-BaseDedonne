package co.simplon.springticketapi.model;



public class Learner {

    private Long id_apprenant;
    private String nom_apprenant;
    private String prenom_apprenant;

    public Learner(Long id_apprenant, String nom_apprenant, String prenom_apprenant) {
        this.id_apprenant = id_apprenant;
        this.nom_apprenant = nom_apprenant;
        this.prenom_apprenant = prenom_apprenant;
    }

    public Long getId_apprenant() {
        return id_apprenant;
    }

    public String getNom_apprenant() {
        return nom_apprenant;
    }

    public String getPrenom_apprenant() {
        return prenom_apprenant;
    }

    public void setId_apprenant(Long id_apprenant) {
        this.id_apprenant = id_apprenant;
    }

    public void setNom_apprenant(String nom_apprenant) {
        this.nom_apprenant = nom_apprenant;
    }

    public void setPrenom_apprenant(String prenom_apprenant) {
        this.prenom_apprenant = prenom_apprenant;
    }

    // A vous de jouer
}
