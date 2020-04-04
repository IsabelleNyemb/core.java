package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import controller.Controller;
import model.Employe;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.BoxLayout;

public class Jemeconnecte {
	private Employe itsMe= new Employe();// pour relier je me connecte à la classe employé et qu'il reconnaisse lors de la connexion

	private JFrame frame;
	private JTable ListeResa;
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jemeconnecte window = new Jemeconnecte();
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
	public Jemeconnecte(Employe emp) {
		System.out.println(emp.getPrenom());
		this.itsMe= emp;
		this.itsMe.setIdemploye(emp.getIdemploye());
		this.itsMe.setMatricule(emp.getMatricule());
		this.itsMe.setNom(emp.getNom());
		this.itsMe.setPrenom(emp.getPrenom());
		this.itsMe.setFonction(emp.getFonction());
		this.itsMe.setNumTel(emp.getNumTel());
		this.itsMe.setNumPermis(emp.getnumPermis());
		this.itsMe.setValidAdmin(emp.getValidAdmin());
		System.out.println(this.itsMe.getPrenom());
		
		initialize();
	}

	public Jemeconnecte() {
		initialize();		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(600, 600, 663, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ListeResa = new JTable();
		ListeResa.setColumnSelectionAllowed(true);
		ListeResa.setCellSelectionEnabled(true);
		ListeResa.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));	
		ListeResa.setModel(
  				new DefaultTableModel(
  			Controller.getReserver(this.itsMe.getIdemploye()),
  			new String[] {
  				"NumImmat", "Modele", "DateReserveh"
  			}
  		)
  		);
			frame.dispose();
		
		JPanel InfosBV = new JPanel();
		InfosBV.setBounds(20, 16, 606, 46);
		frame.getContentPane().add(InfosBV);				    
							
		JLabel lblBienvenueDansVotre = new JLabel("Bienvenue dans votre espace");
		InfosBV.add(lblBienvenueDansVotre);
		lblBienvenueDansVotre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenueDansVotre.setForeground(Color.GREEN);
		
		JLabel identification = new JLabel(" ");
		InfosBV.add(identification);
		identification.setFont(new Font("Tahoma", Font.PLAIN, 18));
		identification.setForeground(Color.RED);
		identification.setText(this.itsMe.getNom() +  " "  + this.itsMe.getPrenom());
		
		JPanel ResasEmp = new JPanel();
		ResasEmp.setBounds(20, 78, 606, 179);
		frame.getContentPane().add(ResasEmp);
		
		JScrollPane scrollPane = new JScrollPane(ListeResa);
		scrollPane.setViewportBorder(null);
		ResasEmp.add(scrollPane);
		
		JButton btnSeDeconnecter = new JButton("Se deconnecter");
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnSeDeconnecter.setBounds(239, 312, 154, 29);
		frame.getContentPane().add(btnSeDeconnecter);
		
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GestionnaireFlotte();
				frame.setVisible(false);
			}
		});
		btnAdmin.setBackground(new Color(204, 255, 255));
		btnAdmin.setForeground(Color.BLACK);
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdmin.setBounds(528, 271, 98, 29);
		frame.getContentPane().add(btnAdmin);
		btnAdmin.setVisible(false);
		if (this.itsMe.getValidAdmin()==1) {
			btnAdmin.setVisible(true);
		}
										
		frame.setVisible(true);
		}
}


