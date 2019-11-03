package com.guilherme.gui.cadastro;

import com.guilherme.gui.utils.KGradientPanel;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author Guilherme
 */
public class TelaDeCadastro extends JFrame {

    private JFormattedTextField CPFField;
    private JTextField NomeField;
    private JPasswordField SenhaField;
    private JTextField SobrenomeField;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private KGradientPanel kGradientPanel1;
    private KGradientPanel kGradientPanel2;

    public TelaDeCadastro() {
        initComponents();
    }

    private void initComponents() {

        kGradientPanel1 = new KGradientPanel();
        jPanel1 = new JPanel();
        NomeField = new JTextField();
        SobrenomeField = new JTextField();
        jLabel1 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        SenhaField = new JPasswordField();
        kGradientPanel2 = new KGradientPanel();
        jLabel12 = new JLabel();
        CPFField = new JFormattedTextField();
        jLabel14 = new JLabel();
        jLabel15 = new JLabel();
        jLabel16 = new JLabel();
        jLabel2 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel13 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new Color(0, 204, 204));
        kGradientPanel1.setkGradientFocus(600);
        kGradientPanel1.setkStartColor(new Color(153, 0, 153));

        jPanel1.setBackground(new Color(255, 255, 255));

        NomeField.setFont(new Font("Segoe UI", 0, 12));
        NomeField.setForeground(new Color(102, 102, 102));
        NomeField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));
        NomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                NomeFieldActionPerformed(evt);
            }
        });

        SobrenomeField.setFont(new Font("Segoe UI", 0, 12));
        SobrenomeField.setForeground(new Color(102, 102, 102));
        SobrenomeField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Segoe UI Black", 1, 18));
        jLabel1.setForeground(new Color(102, 153, 255));
        jLabel1.setText("Crie sua conta grátis!");

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setFont(new Font("Segoe UI", 0, 10));
        jLabel3.setForeground(new Color(102, 153, 255));
        jLabel3.setText("Nome");

        jLabel4.setBackground(new Color(255, 255, 255));
        jLabel4.setFont(new Font("Segoe UI", 0, 10));
        jLabel4.setForeground(new Color(102, 153, 255));
        jLabel4.setText("Sobrenome");

        jLabel5.setBackground(new Color(255, 255, 255));
        jLabel5.setFont(new Font("Segoe UI", 0, 10));
        jLabel5.setForeground(new Color(102, 153, 255));
        jLabel5.setText("CPF");

        jLabel6.setBackground(new Color(255, 255, 255));
        jLabel6.setFont(new Font("Segoe UI", 0, 10));
        jLabel6.setForeground(new Color(102, 153, 255));
        jLabel6.setText("Senha");

        SenhaField.setFont(new Font("Segoe UI", 0, 12));
        SenhaField.setForeground(new Color(102, 102, 102));
        SenhaField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));

        kGradientPanel2.setkEndColor(new Color(12, 91, 160));
        kGradientPanel2.setkGradientFocus(200);
        kGradientPanel2.setkStartColor(new Color(153, 0, 157));

        jLabel12.setBackground(new Color(255, 255, 255));
        jLabel12.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new Color(255, 255, 255));
        jLabel12.setText("CONTINUAR");

        GroupLayout kGradientPanel2Layout = new GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(78, 78, 78))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jLabel12, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        CPFField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));
        CPFField.setForeground(new Color(102, 102, 102));
        try {
            CPFField.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel14.setBackground(new Color(255, 255, 255));
        jLabel14.setFont(new Font("Segoe UI", 0, 10));
        jLabel14.setForeground(new Color(12, 91, 160));
        jLabel14.setText("_______________________");

        jLabel15.setBackground(new Color(255, 255, 255));
        jLabel15.setFont(new Font("Segoe UI", 0, 10));
        jLabel15.setForeground(new Color(12, 91, 160));
        jLabel15.setText("_______________________");

        jLabel16.setIcon(new ImageIcon("icons8_resume_16px.png"));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(SobrenomeField, GroupLayout.Alignment.LEADING)
                    .addComponent(NomeField, GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, GroupLayout.Alignment.LEADING)
                    .addComponent(SenhaField, GroupLayout.Alignment.LEADING)
                    .addComponent(kGradientPanel2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CPFField, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(9, 9, 9)
                .addComponent(jLabel16)
                .addGap(11, 11, 11)
                .addComponent(jLabel15)
                .addGap(35, 35, 35))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addComponent(jLabel3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SobrenomeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(11, 11, 11)
                .addComponent(CPFField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SenhaField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(kGradientPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new Color(255, 255, 255));
        jLabel2.setFont(new Font("Segoe UI Black", 1, 36));
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("$ Banco do Gui $");

        jLabel7.setIcon(new ImageIcon("grap.png"));

        jLabel8.setBackground(new Color(255, 255, 255));
        jLabel8.setFont(new Font("Segoe UI", 1, 18));
        jLabel8.setForeground(new Color(255, 153, 153));
        jLabel8.setText("- Sem juros!");

        jLabel9.setBackground(new Color(255, 255, 255));
        jLabel9.setFont(new Font("Segoe UI", 1, 18));
        jLabel9.setForeground(new Color(255, 153, 204));
        jLabel9.setText("- Sem tarifas!");

        jLabel10.setBackground(new Color(255, 255, 255));
        jLabel10.setFont(new Font("Segoe UI", 1, 18));
        jLabel10.setForeground(new Color(204, 153, 255));
        jLabel10.setText("- Sem dinheiro!");

        jLabel11.setBackground(new Color(255, 255, 255));
        jLabel11.setFont(new Font("Segoe UI", 1, 18));
        jLabel11.setForeground(new Color(153, 153, 255));
        jLabel11.setText("- Sem nada!");

        jLabel13.setBackground(new Color(255, 255, 255));
        jLabel13.setFont(new Font("Segoe UI Black", 1, 14));
        jLabel13.setForeground(new Color(255, 255, 255));
        jLabel13.setText("- ############ -");

        GroupLayout kGradientPanel1Layout = new GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel13))
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 25, Short.MAX_VALUE)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void NomeFieldActionPerformed(ActionEvent evt) {
        // TODO ...
    }


    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> new TelaDeCadastro().setVisible(true));
    }

}
