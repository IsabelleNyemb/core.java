package baseFlotte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Jemeconnecte {
	private Employe itsMe= new Employe();// pour relier je me connecte à la classe employé et qu'il reconnaisse lors de la connexion

	private JFrame frame;
	private JTable table;

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
		this.itsMe.setMatricule(emp.getMatricule());
		this.itsMe.setNom(emp.getNom());
		this.itsMe.setPrenom(emp.getPrenom());
		this.itsMe.setFonction(emp.getFonction());
		this.itsMe.setNumTel(emp.getNumTel());
		this.itsMe.setNumPermis(emp.getNumPermis());
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
		frame.setBounds(100, 100, 663, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//System.out.println(this.itsMe.getPrenom());
		
		table = new JTable();
		table.setBounds(72, 80, 530, 130);
		frame.getContentPane().add(table);
		
		String [] columnNames = {"NumImmat", "Modele",
	               "Statut","DateEntrée", "DateSortie"};
		
		JLabel lblBienvenueDansVotre = new JLabel("Bienvenue dans votre espace");
		lblBienvenueDansVotre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblBienvenueDansVotre.setForeground(Color.GREEN);
		lblBienvenueDansVotre.setBounds(26, 16, 316, 34);
		frame.getContentPane().add(lblBienvenueDansVotre);
		
		JLabel identification = new JLabel("");
		identification.setFont(new Font("Tahoma", Font.PLAIN, 18));
		identification.setForeground(Color.RED);
		identification.setBounds(341, 24, 173, 20);
		identification.setText(this.itsMe.getNom() +  " "  + this.itsMe.getPrenom());
		frame.getContentPane().add(identification);
		
		
		
		frame.setVisible(true);
	}
}
