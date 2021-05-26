package DAO;

import OO.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements IDAO<Patient>{

    @Override
    public Patient Ajouter(Patient patient) {
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                PreparedStatement ps = c.prepareStatement("insert into patient (nom, prenom, adresse, tel) values (?,?,?,?);",PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, patient.getNom());
                ps.setString(2, patient.getPrenom());
                ps.setString(3, patient.getAdresse());
                ps.setString(4, patient.getTel());
                int res = ps.executeUpdate();

                if (res != 0) {
                    c.commit();
                    var rs= ps.getGeneratedKeys();
                    rs.next();
                    patient.setCode(rs.getInt(1));
                    return patient;
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Boolean Supprimer(int code) {
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                PreparedStatement ps = c.prepareStatement("delete from patient where code=?;");
                ps.setInt(1, code);
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
    public Patient Modifier(Patient patient) {
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                c.setAutoCommit(false);
                PreparedStatement ps = c.prepareStatement("update patient set nom=?, prenom=?, adresse=?, tel=? where code=?;");
                ps.setInt(5, patient.getCode());
                ps.setString(1, patient.getNom());
                ps.setString(2, patient.getPrenom());
                ps.setString(3, patient.getAdresse());
                ps.setString(4, patient.getTel());
                int res = ps.executeUpdate();
                if (res != 0) {
                    c.commit();
                    return patient;
                }
            }
            catch (Exception e) { e.printStackTrace();  }
        }

        return null;
    }

    @Override
    public Patient RechercherParId(int id) {
        Patient p = null;
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                PreparedStatement ps = c.prepareStatement("select * from patient where code=?;");
                ps.setInt(1, id);
                ResultSet res = ps.executeQuery();
                if (res.next()) {
                    p = new Patient(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                    System.out.println(p);
                }
            } catch (Exception e) { e.printStackTrace(); }
        }
        return p;
    }
    public List<Patient> rechercherTous(){
        List<Patient> patients = new ArrayList<>();
        Connection c = DbConnection.getConnection();
        if (c != null) {
            try {
                Statement s = c.createStatement();
                ResultSet res = s.executeQuery("select * from patient;");
                while (res.next()){
                    var p = new Patient(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
                    patients.add(p);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return patients;
    }

}
