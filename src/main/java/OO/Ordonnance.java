package OO;

public class Ordonnance {
    private Integer code;
    private String nom;
    private Integer nbPrise;

    private Consultation consultation;

    public Ordonnance(Integer code, String nom, Integer nbPrise) {
        this.code = code;
        this.nom = nom;
        this.nbPrise = nbPrise;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbPrise() {
        return nbPrise;
    }

    public void setNbPrise(Integer nbPrise) {
        this.nbPrise = nbPrise;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
}
