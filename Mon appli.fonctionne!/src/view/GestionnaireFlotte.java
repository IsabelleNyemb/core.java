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

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Component;

public class GestionnaireFlotte {

	private JFrame frame;
	
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
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBounds(100, 100, 836, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTable Gtable = new JTable();
		Gtable.setColumnSelectionAllowed(true);
		Gtable.setCellSelectionEnabled(true);	
    	Gtable.setModel(new DefaultTableModel(
    			Controller.getGestionnaire(),
      			new String[] {
							"NomEmploye","NumImmat", "Modele", "DateReserveh", "DateRetourveh", "Statut"
					}
				))	 ;
	
		frame.getContentPane().setLayout(null);
									
		JPanel panel = new JPanel();
		panel.setBounds(15, 16, 446, 47);
		panel.setBackground(new Color(102, 204, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setToolTipText("");
		frame.getContentPane().add(panel);
		
		JLabel lblBienvenueDansVotre = new JLabel("Bienvenue dans votre espace administrateur");
		lblBienvenueDansVotre.setForeground(new Color(0, 102, 102));
		lblBienvenueDansVotre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblBienvenueDansVotre);
		
		JPanel gestionRes = new JPanel();
		gestionRes.setBounds(25, 79, 591, 265);
		frame.getContentPane().add(gestionRes);
		gestionRes.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(Gtable);
		scrollPane.setBounds(69, 5, 452, 402);
		gestionRes.add(scrollPane);
		scrollPane.setViewportBorder(null);
		
		Gtable.setFillsViewportHeight(true);
		Gtable.setSelectionBackground(Color.GRAY);
		Gtable.setForeground(Color.BLACK);
		Gtable.setBackground(new Color(240, 248, 255));
		Gtable.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(51, 384, 446, 67);
		panel_1.setBackground(new Color(102, 204, 255));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAjouter.setBounds(57, 16, 121, 29);
		panel_1.add(btnAjouter);
		
		JButton btnSuppimer = new JButton("Supprimer");
		btnSuppimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSuppimer.setBounds(267, 16, 130, 29);
		panel_1.add(btnSuppimer);
				
		JButton btnSeDeconnecter = new JButton("Se deconnecter");
		btnSeDeconnecter.setBounds(617, 471, 182, 29);
		frame.getContentPane().add(btnSeDeconnecter);
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnSeDeconnecter.setFont(new Font("Tahoma", Font.BOLD, 18));
		
				frame.setVisible(true);
	}
}
