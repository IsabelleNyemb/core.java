package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.Controller;
import model.Employe;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;

public class GestionnaireFlotte {

	private JFrame frame;
	private JTextField MatriculeR;
	private JTextField NumPermisR;
	private JTextField IdReservationR;
	private JTextField NumImmatR;
	private JTextField DateReserVehR;
	private JTextField DateRetourVehR;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionnaireFlotte window = new GestionnaireFlotte();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionnaireFlotte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 255));
		frame.setBounds(100, 100, 1110, 608);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		JLabel Error = new JLabel("");
		Error.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Error.setForeground(Color.RED);
		Error.setBounds(0, 59, 193, 20);
		frame.getContentPane().add(Error);
		Error.setVisible(false);
		
		JLabel Success = new JLabel("");
		Success.setForeground(Color.GREEN);
		Success.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Success.setBounds(15, 41, 183, 20);
		frame.getContentPane().add(Success);
		Success.setVisible(false);		
		
		JTable Gtable = new JTable();
		Gtable.setColumnSelectionAllowed(true);
		Gtable.setCellSelectionEnabled(true);	
    	Gtable.setModel(new DefaultTableModel(
    			Controller.getGestionnaire(),
      			new String[] {
							"IdReservation", "IdEmploye", "Matricule","Nom","Prenom", "Fonction","NumPermis","NumImmat", "Modele", "DateReserveh", "DateRetourveh"
					}   			
				))	 ;
	
		frame.getContentPane().setLayout(null);
									
		JPanel panel = new JPanel();
		panel.setBounds(339, 16, 446, 47);
		panel.setBackground(new Color(102, 204, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setToolTipText("");
		frame.getContentPane().add(panel);
		
		JLabel lblBienvenueDansVotre = new JLabel("Bienvenue dans votre espace administrateur");
		lblBienvenueDansVotre.setForeground(new Color(0, 102, 102));
		lblBienvenueDansVotre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblBienvenueDansVotre);
		
		JPanel gestionRes = new JPanel();
		gestionRes.setBounds(43, 77, 1030, 97);
		frame.getContentPane().add(gestionRes);
		gestionRes.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(Gtable);
		scrollPane.setBounds(0, 10, 1008, 87);
		gestionRes.add(scrollPane);
		scrollPane.setViewportBorder(null);
		
		Gtable.setFillsViewportHeight(true);
		Gtable.setSelectionBackground(Color.GRAY);
		Gtable.setForeground(Color.BLACK);
		Gtable.setBackground(new Color(240, 248, 255));
		Gtable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel ListVeh = new JPanel();
		ListVeh.setBackground(new Color(204, 204, 255));
		ListVeh.setBounds(0, 237, 1088, 331);
		frame.getContentPane().add(ListVeh);
		ListVeh.setLayout(null);
		
		JLabel lblNom = new JLabel("Matricule");
		lblNom.setBounds(15, 16, 93, 23);
		lblNom.setForeground(Color.BLACK);
		lblNom.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNom.setBackground(Color.WHITE);
		ListVeh.add(lblNom);
		
		JLabel lblNumimmat = new JLabel("NumImmat");
		lblNumimmat.setForeground(Color.BLACK);
		lblNumimmat.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNumimmat.setBackground(Color.WHITE);
		lblNumimmat.setBounds(488, 16, 105, 23);
		ListVeh.add(lblNumimmat);
		
		JLabel lblDatereserveh = new JLabel("DateReserVeh");
		lblDatereserveh.setForeground(Color.BLACK);
		lblDatereserveh.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblDatereserveh.setBackground(Color.WHITE);
		lblDatereserveh.setBounds(488, 68, 134, 23);
		ListVeh.add(lblDatereserveh);
		
		JLabel lblDateretourveh = new JLabel("DateRetourVeh");
		lblDateretourveh.setForeground(Color.BLACK);
		lblDateretourveh.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblDateretourveh.setBackground(Color.WHITE);
		lblDateretourveh.setBounds(488, 127, 134, 23);
		ListVeh.add(lblDateretourveh);
		
		JLabel lblFonction = new JLabel("NumPermis");
		lblFonction.setForeground(Color.BLACK);
		lblFonction.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblFonction.setBackground(Color.WHITE);
		lblFonction.setBounds(15, 68, 105, 23);
		ListVeh.add(lblFonction);
		
		JLabel lblNumpermis = new JLabel("IdReservation");
		lblNumpermis.setForeground(Color.BLACK);
		lblNumpermis.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNumpermis.setBackground(Color.WHITE);
		lblNumpermis.setBounds(15, 127, 125, 23);
		ListVeh.add(lblNumpermis);
		
		MatriculeR = new JTextField();
		MatriculeR.setColumns(10);
		MatriculeR.setBounds(169, 13, 212, 26);
		ListVeh.add(MatriculeR);
		
		NumPermisR = new JTextField();
		NumPermisR.setColumns(10);
		NumPermisR.setBounds(169, 65, 212, 26);
		ListVeh.add(NumPermisR);
		
		IdReservationR = new JTextField();
		IdReservationR.setColumns(10);
		IdReservationR.setBounds(169, 124, 212, 26);
		ListVeh.add(IdReservationR);
		
		NumImmatR = new JTextField();
		NumImmatR.setColumns(10);
		NumImmatR.setBounds(685, 13, 212, 26);
		ListVeh.add(NumImmatR);
		
		DateReserVehR = new JTextField();
		DateReserVehR.setColumns(10);
		DateReserVehR.setBounds(685, 68, 212, 26);
		ListVeh.add(DateReserVehR);
		
		DateRetourVehR = new JTextField();
		DateRetourVehR.setColumns(10);
		DateRetourVehR.setBounds(685, 124, 212, 26);
		ListVeh.add(DateRetourVehR);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 255, 153));
		panel_2.setBounds(114, 206, 80, 56);
		ListVeh.add(panel_2);
		
		JButton btnAjouter = new JButton("");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Matricule = MatriculeR.getText();
				String NumPermis = NumPermisR.getText();
				String IdReservation = IdReservationR.getText();
				String NumImmat = NumImmatR.getText();
				String DateReserVeh = DateReserVehR.getText();
				String DateRetourVeh = DateRetourVehR.getText();
				Controller.AjouterR(Matricule,NumPermis,NumImmat, IdReservation, DateReserVeh, DateRetourVeh );	
				Gtable.setModel(new DefaultTableModel( //pour rafraichir la table
		    			Controller.getGestionnaire(),
		      			new String[] {
									"IdEmploye", "Matricule","Nom","Prenom", "Fonction","NumPermis","NumImmat", "Modele", "DateReserveh", "DateRetourveh"
							}   			
						))	 ;
				}							
			});
		panel_2.add(btnAjouter);
		btnAjouter.setBackground(new Color(0, 255, 51));
		btnAjouter.setIcon(new ImageIcon(GestionnaireFlotte.class.getResource("/icons/iconfinder_Increase_40066.png")));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 51));
		panel_3.setBounds(604, 219, 114, 41);
		ListVeh.add(panel_3);
		
		JButton btnUpdate = new JButton("Update");
		panel_3.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				String IdReservation = IdReservationR.getText();
				Controller.UpdateReservation(IdReservation);
				Gtable.setModel(new DefaultTableModel(
		    			Controller.getGestionnaire(),
		      			new String[] {
									"IdReservation","IdEmploye", "Matricule","Nom","Prenom", "Fonction","NumPermis","NumImmat", "Modele", "DateReserveh", "DateRetourveh"
							}   			
						));
			}
		});
		
		JButton btnSeDeconnecter = new JButton("Se deconnecter");
		btnSeDeconnecter.setBounds(887, 272, 186, 31);
		ListVeh.add(btnSeDeconnecter);
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnSeDeconnecter.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(357, 211, 80, 51);
		ListVeh.add(panel_1);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				MatriculeR.setText("");
				NumPermisR.setText("");
				IdReservationR.setText("");
				NumImmatR.setText("");
				DateReserVehR.setText("");
				DateRetourVehR.setText("");	
				Error.setVisible(false);
				Success.setVisible(false);
			}	
						
		});
		panel_1.add(btnRefresh);
		btnRefresh.setIcon(new ImageIcon(GestionnaireFlotte.class.getResource("/icons/refresh_arrow_1546.png")));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(114, 192, 795, 2);
		ListVeh.add(separator_1);
		
		JLabel lblAaaammjj = new JLabel("AAAA/MM/JJ");
		lblAaaammjj.setBackground(Color.LIGHT_GRAY);
		lblAaaammjj.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAaaammjj.setBounds(900, 74, 86, 20);
		ListVeh.add(lblAaaammjj);
		
		JLabel label = new JLabel("AAAA/MM/JJ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(900, 127, 86, 20);
		ListVeh.add(label);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(261, 211, 748, 2);
		frame.getContentPane().add(separator);
		
				frame.setVisible(true);
	}
}
