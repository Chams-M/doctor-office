package IHM;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    private final JMenuItem itemAjoutPatient;
    private final JDesktopPane centerPane;



    public MainFrame() {

        this.setTitle("gestion de cabinet medical");
        JPanel pMain = new JPanel();
        JMenuBar mBar = new JMenuBar();
        this.setJMenuBar(mBar);
        JMenu mPatient = new JMenu("Patient");
        mBar.add(mPatient);
        itemAjoutPatient = new JMenuItem("ajouter");
        itemAjoutPatient.addActionListener(this);
        mPatient.add(itemAjoutPatient);
        pMain.setBorder(new EmptyBorder(50, 50, 50, 50));
        //Params de la fen�tre
        centerPane = new JDesktopPane();
        pMain.add(centerPane);
        this.add(centerPane, BorderLayout.CENTER);
        this.setContentPane(centerPane);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(new Point(500,200));
        this.setSize(new Dimension(1024,728));

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        var source= actionEvent.getSource();
        if (source  == this.itemAjoutPatient) {
            JInternalFrame fr= new FrameAjoutP();
            centerPane.add(fr);
        }
    }
}
