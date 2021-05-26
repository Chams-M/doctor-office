import DAO.PatientDAO;
import OO.Patient;

public class Main {
    public static void main(String[] args) {
//        MainFrame mainFrame=new MainFrame();
        var patientDAO = new PatientDAO();
        System.out.println(patientDAO.rechercherTous());


    }
}
