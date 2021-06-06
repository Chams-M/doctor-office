package IHM;

import DAO.PatientDAO;
import OO.Patient;

import javax.swing.*;
import java.awt.*;

public class PatientFrame extends JFrame {


    private final JList list_patients;
    private final JTextField search;
    private final JButton btn_search;
    private final JButton ajout;
    private final JButton modif;
    private final JButton ajout_pat;
    private final PatientDAO patientDAO=new PatientDAO();
    private final JPanel p3;
    private final JPanel p4;
    private final JButton annuler;
    private final JTextField txt_nom;
    private final JTextField txt_prenom;
    private final JTextField txt_adress;
    private final JTextField txt_tel;
    private final DefaultListModel<Patient> list_model;

    public PatientFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 600);
        this.setTitle("Cabinet chams");
        this.setLayout(null);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        JLabel nom = new JLabel("Nom:");
        nom.setSize(50, 50);
        nom.setLocation(0,10);

        txt_nom=new JTextField();
        txt_nom.setSize(180, 30);
        txt_nom.setLocation(80,20);

        JLabel prenom = new JLabel("Prénom:");
        prenom.setSize(80, 50);
        prenom.setLocation(0,10);
        txt_prenom=new JTextField();
        txt_prenom.setSize(180, 30);
        txt_prenom.setLocation(80,20);


        JLabel adress = new JLabel("Adresse:");
        adress.setSize(80, 50);
        adress.setLocation(0,10);

        txt_adress=new JTextField();
        txt_adress.setSize(180, 30);
        txt_adress.setLocation(80,20);

        JLabel tel = new JLabel("Téléphone:");
        tel.setSize(82, 50);
        tel.setLocation(0,10);

        txt_tel=new JTextField();
        txt_tel.setSize(180, 30);
        txt_tel.setLocation(80,20);

        JLabel titre=new JLabel("Gestion des Patients");
        titre.setSize(150, 50);
        titre.setLocation(500, 25);


        list_patients= new JList<>();
        list_model = new DefaultListModel<Patient>();
        list_patients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list_patients.setModel(list_model);
        list_patients.setSize(290,400);
        list_patients.setLocation(10,90);

        //ajouter tous les patients dans list_patients
        patientDAO.rechercherTous().forEach(list_model::addElement);

        list_patients.addListSelectionListener(listSelectionEvent -> {
            if (!listSelectionEvent.getValueIsAdjusting()) {
                remplirFormulairePatient();
            }
        });

        search=new JTextField();
        search.setSize(70, 30);
        search.setLocation(10, 30);

        ajout=new JButton("Ajouter Consultation");
        ajout.setSize(290, 50);
        ajout.setLocation(10, 500);
        ajout.addActionListener((actionEvent) -> {
            if(list_patients.getSelectedValue() != null){
                new ConsultationFrame((Patient) list_patients.getSelectedValue());
            }else {
                JOptionPane.showMessageDialog(this, "Selectionner un patient !!","Ajout d'un Consultation",JOptionPane.ERROR_MESSAGE);

            }

        });


        btn_search=new JButton("Chercher par code");
        btn_search.addActionListener(actionEvent -> {
            chercherPatientParCode();
        });
        btn_search.setSize(200, 30);
        btn_search.setLocation(100, 30);

        modif=new JButton("Modifier les informations");
        modif.addActionListener(actionEvent -> modifierPatient());
        modif.setPreferredSize(new Dimension(220, 50));


        ajout_pat=new JButton("Ajouter Patient");
        ajout_pat.addActionListener(actionEvent -> {
            ajouterPatient();
        });
        ajout_pat.setPreferredSize(new Dimension(150, 50));

        annuler = new JButton("Annuler");
        annuler.addActionListener(actionEvent -> {
            modifierFormulaire("","","","");
            list_patients.clearSelection();
        });

        annuler.setPreferredSize(new Dimension(100, 50));

        p1.setLayout(null);
        p1.setBounds(0, 0, 320, 600);


        p1.add(ajout);

        p1.add(list_patients);
        p1.add(search);
        p1.add(btn_search);


        p2.setLayout(null);
        p2.setBounds(320, 90, 560, 400);
        p2.setBackground(Color.white);


        p3=new JPanel();
        p3.setLayout(new FlowLayout());
        p3.setSize(500, 60);
        p3.setLocation(30, 320);
        p3.add(ajout_pat);
        p3.add(modif);
        p3.add(annuler);
        p3.setBackground(Color.white);


        p4=new JPanel(new GridLayout(2,2,0,10));
//        p4.setBorder(new EmptyBorder(10,10,10,10));
        p4.setSize(600, 150);
        p4.setLocation(0, 30);
        JPanel gridPanel1 = new JPanel(null);
        JPanel gridPanel2 = new JPanel(null);
        JPanel gridPanel3 = new JPanel(null);
        JPanel gridPanel4 = new JPanel(null);

        p4.add(gridPanel1);
        p4.add(gridPanel2);
        p4.add(gridPanel3);
        p4.add(gridPanel4);
        p4.setBackground(Color.white);

        gridPanel1.add(nom);
        gridPanel1.add(txt_nom);
        gridPanel1.setBackground(Color.white);

        gridPanel2.add(prenom);
        gridPanel2.add(txt_prenom);
        gridPanel2.setSize(300,150);
        gridPanel2.setBackground(Color.white);


        gridPanel3.add(adress);
        gridPanel3.add(txt_adress);
        gridPanel3.setBackground(Color.white);

        gridPanel4.add(tel);
        gridPanel4.add(txt_tel);
        gridPanel4.setBackground(Color.white);



        p2.add(p3);
        p2.add(p4);

        this.add(titre);

        this.add(p1);
        this.add(p2);
        this.setResizable(false);
        this.setBackground(Color.PINK);

        this.setVisible(true);
    }

    private void chercherPatientParCode() {
        try{
            int codePatient = Integer.parseInt(search.getText());
            int i =0;
            while(i<list_model.getSize()){
                var patient = list_model.getElementAt(i);
                if( patient.getCode() == codePatient ) {
                    list_patients.setSelectedIndex(i);
                    break;
                }
                i++;
            }

            if (i==list_model.getSize()){
                    throw new Exception();
            }
        }catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "veuillez saisir un code valide !","recherche de patient",JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "il n'y a pas un patient avec ce code","recherche de patient",JOptionPane.ERROR_MESSAGE);
            modifierFormulaire("","","","");
        }finally {
            search.setText("");
        }
    }

    private  void modifierPatient(){
        if(txt_nom.getText().length() > 0 && txt_prenom.getText().length() > 0 && txt_adress.getText().length() > 0 && txt_tel.getText().length()>0){
            try{
                var patient = patientDAO.Modifier(new Patient(((Patient)list_patients.getSelectedValue()).getCode(),txt_nom.getText(),txt_prenom.getText(),txt_adress.getText(),txt_tel.getText()));
                list_model.setElementAt(patient,list_patients.getSelectedIndex());
                JOptionPane.showMessageDialog(this, "mofification éffectuer avec succées","ajout de patient",JOptionPane.INFORMATION_MESSAGE);
                modifierFormulaire("","","","");
                list_patients.clearSelection();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this, "l'ajout de patient n'est pas effectué avec succes","modification de patient",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "touts les champs doivent etre remplis","ajout de patient",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ajouterPatient() {
        if(txt_nom.getText().length() > 0 && txt_prenom.getText().length() > 0 && txt_adress.getText().length() > 0 && txt_tel.getText().length()>0){
            try{
                var patient = patientDAO.Ajouter(new Patient(0,txt_nom.getText(),txt_prenom.getText(),txt_adress.getText(),txt_tel.getText()));
                list_model.addElement(patient);
                JOptionPane.showMessageDialog(this, "ajout éffectuer avec succées","ajout de patient",JOptionPane.INFORMATION_MESSAGE);
                modifierFormulaire("","","","");
                list_patients.clearSelection();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(this, "l'ajout de patient n'est pas effectué avec succes","ajout de patient",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "touts les champs doivent etre remplis","ajout de patient",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modifierFormulaire(String s ,String s1 , String s2 ,String s3 ) {
        txt_nom.setText(s);
        txt_prenom.setText(s1);
        txt_adress.setText(s2);
        txt_tel.setText(s3);
    }

    private void remplirFormulairePatient() {
        var patient = (Patient) list_patients.getSelectedValue();
        if(patient != null){
            modifierFormulaire(patient.getNom(), patient.getPrenom(), patient.getAdresse(), patient.getTel());
        }

    }

}