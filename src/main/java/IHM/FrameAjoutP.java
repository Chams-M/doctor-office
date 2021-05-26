package IHM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameAjoutP extends JInternalFrame implements ActionListener  {



    public FrameAjoutP() {

        JPanel pMainPanel=new JPanel();
        JLabel labTitre = new JLabel("Gestion du Stock du Magasin");
        pMainPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        pMainPanel.add(labTitre, BorderLayout.CENTER);
        this.add(pMainPanel);
        this.setContentPane(pMainPanel);
        this.setBounds(10,10,300,300);
        this.setClosable(true);
        this.setResizable(true);
        this.setIconifiable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
