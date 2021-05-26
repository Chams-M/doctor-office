package DAO;

import OO.Consultation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultationDAO implements IDAO<Consultation> {

    @Override
    public Consultation Ajouter(Consultation consultation) {
        try{
            Connection c = DbConnection.getConnection();
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("insert into consultation ( date, type, remarques, code_patient) values (?,?,?,?);",PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDate(1,consultation.getDate());
            ps.setString(2, consultation.getType());
            ps.setString(3,consultation.getRemarques());
            ps.setInt(4,consultation.getPatient().getCode());
            int res = ps.executeUpdate();

            if (res != 0) {
                c.commit();
                var rs= ps.getGeneratedKeys();
                rs.next();
                consultation.setCode(rs.getInt(1));
                return consultation;
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public Boolean Supprimer(int id) {
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                PreparedStatement ps = c.prepareStatement("delete from consultation where code=?;");
                ps.setInt(1, id);
                int res = ps.executeUpdate();
                if (res != 0) {
                    c.commit();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Consultation Modifier(Consultation consultation) {
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                PreparedStatement ps = c.prepareStatement("update consultation set date=?, type=?, remarques=? where code=?;");
                ps.setInt(4, consultation.getCode());
                ps.setDate(1, consultation.getDate());
                ps.setString(2, consultation.getType());
                ps.setString(3, consultation.getRemarques());
                int res = ps.executeUpdate();
                if (res != 0) {
                    c.commit();
                    return consultation;
                }
            }
            catch (Exception e) { e.printStackTrace();  }
        }

        return null;
    }

    @Override
    public Consultation RechercherParId(int id) {
        Consultation consultation = null;
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement("select * from consultation where code=?;");
                ps.setInt(1, id);
                ResultSet res = ps.executeQuery();
                if (res.next()) {
                    consultation = new Consultation(res.getInt(1), res.getDate(2), res.getString(3), res.getString(4));
                    var patientDAO = new PatientDAO();
                    consultation.setPatient(patientDAO.RechercherParId(res.getInt(5)));
                }
            } catch (Exception e) { e.printStackTrace(); }
        }
        return consultation;
    }

    @Override
    public List<Consultation> rechercherTous() {
        List<Consultation> consultations = new ArrayList<>();
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                Statement s = c.createStatement();
                ResultSet res = s.executeQuery("select * from consultation;");
                while (res.next()){
                    var consultation = new Consultation(res.getInt(1), res.getDate(2), res.getString(3), res.getString(4));
                    consultations.add(consultation);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return consultations;
    }

}
