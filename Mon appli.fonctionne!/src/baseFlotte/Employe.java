package baseFlotte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Employe {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employe window = new Employe();
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
	public Employe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnConsulterVehicule = new JButton("Consulter Vehicule");
		btnConsulterVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConsulterVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnConsulterVehicule.setBackground(Color.WHITE);
		btnConsulterVehicule.setBounds(84, 121, 270, 29);
		frame.getContentPane().add(btnConsulterVehicule);
		
		JButton btnFaireDemandeVehicule = new JButton("Signaler probleme vehicule");
		btnFaireDemandeVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFaireDemandeVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnFaireDemandeVehicule.setBackground(Color.WHITE);
		btnFaireDemandeVehicule.setBounds(85, 217, 282, 29);
		frame.getContentPane().add(btnFaireDemandeVehicule);
		
		JLabel lblBienvenueDansVotre = new JLabel("Bienvenue dans votre espace");
		lblBienvenueDansVotre.setBounds(26, 16, 244, 34);
		frame.getContentPane().add(lblBienvenueDansVotre);
	}
}
