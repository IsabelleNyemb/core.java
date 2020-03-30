package baseFlotte;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

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
		frame.setBounds(100, 100, 450, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGererAffectationVehicule = new JButton("Gerer affectation vehicule");
		btnGererAffectationVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnGererAffectationVehicule.setBackground(Color.WHITE);
		btnGererAffectationVehicule.setBounds(81, 126, 273, 29);
		frame.getContentPane().add(btnGererAffectationVehicule);
		
		JButton btnAjouterVehicule = new JButton("Ajouter Vehicule");
		btnAjouterVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnAjouterVehicule.setBackground(Color.WHITE);
		btnAjouterVehicule.setBounds(81, 218, 273, 29);
		frame.getContentPane().add(btnAjouterVehicule);
		
		JButton btnSupprimerVehicule = new JButton("Supprimer vehicule");
		btnSupprimerVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnSupprimerVehicule.setBackground(Color.WHITE);
		btnSupprimerVehicule.setBounds(81, 323, 273, 29);
		frame.getContentPane().add(btnSupprimerVehicule);
		
		JButton btnVoirReservation = new JButton("Voir reservation");
		btnVoirReservation.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnVoirReservation.setBackground(Color.WHITE);
		btnVoirReservation.setBounds(81, 420, 273, 29);
		frame.getContentPane().add(btnVoirReservation);
		
		JLabel lblBonjourAdmin = new JLabel("Welcome Admin");
		lblBonjourAdmin.setBounds(26, 16, 137, 29);
		frame.getContentPane().add(lblBonjourAdmin);
	}
}
