package OO;

import java.util.ArrayList;
import java.util.List;

public class Patient {

    private Integer code;

    private String nom;

    private String prenom;

    private String adresse;

    private String tel;

    private List<Consultation> listeConsultations=new ArrayList<>();

    public Patient() {
    }

    public Patient(Integer code, String nom, String prenom, String adresse, String tel) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer value) {
        this.code = value;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String value) {
        this.nom = value;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String value) {
        this.prenom = value;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String value) {
        this.adresse = value;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String value) {
        this.tel = value;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
