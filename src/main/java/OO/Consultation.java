package OO;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class Consultation {
    private Integer code;
    private Date date;
    private String type;
    private String remarques;

    private Patient patient;

    private List<Ordonnance> listeOrdonnance=new ArrayList<>();

    public Consultation(Integer code, Date date, String type, String remarques) {
        this.code = code;
        this.date = date;
        this.type = type;
        this.remarques = remarques;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarques() {
        return remarques;
    }

    public void setRemarques(String remarques) {
        this.remarques = remarques;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
