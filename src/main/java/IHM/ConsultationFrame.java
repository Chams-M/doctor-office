package IHM;

import DAO.ConsultationDAO;
import OO.Consultation;
import OO.Patient;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class ConsultationFrame extends JDialog {

    private final ConsultationDAO consultationDAO = new ConsultationDAO();
    private final JTextField txt_date;
    private final JComboBox typesComboBox;

    public ConsultationFrame(Patient patient) {
        this.setTitle("Ajouter Consultation ");
        this.setSize(600,200);
        this.setLocation(250,100);
        this.setLayout(new GridLayout(4,1,10,10));
        this.setVisible(true);


        var firstRow =new JPanel(new FlowLayout()) ;
        var secondRow =new JPanel(new FlowLayout());
        var thirdRow = new JPanel(new FlowLayout());
        var fourthRow =new JPanel(new FlowLayout());

        var lbl_nom = new JLabel("Nom : ");
        var txt_nom = new JLabel(patient.getNom()+" , ");

        var lbl_prenom = new JLabel("Prénom : ");
        var txt_prenom = new JLabel(patient.getPrenom());

        firstRow.add(lbl_nom);
        firstRow.add(txt_nom);

        firstRow.add(lbl_prenom);
        firstRow.add(txt_prenom);

        var lbl_type = new JLabel("type : ");
        String [] types={"Consultation","Controlle"};
        typesComboBox= new JComboBox(types);

        secondRow.add(lbl_type);
        secondRow.add(typesComboBox);

        var lbl_date = new JLabel("Date de consultation :");
        txt_date = new JTextField(15);

        thirdRow.add(lbl_date);
        thirdRow.add(txt_date);


        var btn_ajouter = new JButton("Ajouter");
        btn_ajouter.addActionListener(actionEvent -> {
            if(txt_date.getText().length()>0){
                try{
                    Consultation consultation= new Consultation(0,
                            new Date((new SimpleDateFormat("dd-MM-yyyy").parse(txt_date.getText()).getTime())),
                            (String)typesComboBox.getSelectedItem(),
                            ""
                    );
                    consultation.setPatient(patient);
                    consultationDAO.Ajouter(consultation);
                }catch (Exception ex){

                }
            }
        });

        fourthRow.add(btn_ajouter);
        this.add(firstRow);
        this.add(secondRow);
        this.add(thirdRow);
        this.add(fourthRow);

    }
}
