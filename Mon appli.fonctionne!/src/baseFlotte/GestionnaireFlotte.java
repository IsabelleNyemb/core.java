package baseFlotte;

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
import javax.swing.table.TableColumn;

import connexion.ConnexionBD;

import java.awt.Dimension;

public class GestionnaireFlotte {

	private JFrame frame;
	private JTable Vtable;
	private Vehicule [] vehicules = new Vehicule[50];

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
		frame.setBounds(100, 100, 1155, 746);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/*
		 
		 */
		/*
		 *
		 */
		String [] columnNames = {"NumImmat", "Modele",
               "Statut","DateEntrée", "DateSortie"};
		
		String [] [] data = {
			    {"Kathy", "Smith", "Snowboarding", "aarr", "rrr"},
			    {"John", "Doe","Aviron", "aarr", "rrr"},
			    {"Sue", "Black","Knitting", "aarr", "rrr"}
			    
			};
		
		Vtable = new JTable(data, columnNames);
		Vtable.setSize(new Dimension(10, 10));
		Vtable.setFillsViewportHeight(true);
		Vtable.setSelectionBackground(Color.GRAY);
		Vtable.setForeground(Color.BLACK);
		Vtable.setBackground(Color.LIGHT_GRAY);
		Vtable.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		Vtable.setBounds(337, 204, 395, 247);
		
		
		frame.getContentPane().add(Vtable);
		Vtable.setVisible(true);
		
		
		
		Connection BdConnexion= null;
		
		try {
			
            BdConnexion = ConnexionBD.getConnection();
            Statement statement = BdConnexion.createStatement();// permet d'éxécuter une requête
            ResultSet resultat = statement.executeQuery("SELECT idVehicule, NumImmat, Modele, DateEntree, DateSortie,Statut,DateCreation" + 
            		"FROM vehicule");
            System.out.println(resultat.getFetchSize());
            resultat.last();// on se place à la fin du resultset
           /* if (resultat.getRow()==0) {//getRow pour compter, si = 0 alors il n'a pas trouvé d'élément donc une ereur s'affiche
            	Error.setVisible(true);
            }
            else {
            	Success.setVisible(true);
            }
            */
            resultat.first();// on retourne au début du resultset
            //arraylist<v> tttt= new ...;
            //private ArrayList <v>vehicule= new ArrayList <String>();
            while ( resultat.next() ) { //on passe à l'étape suivante
            	String idVehicule=resultat.getString ("idVehicule");
                String numImmat = resultat.getString( "NumImmat" );
                String modele = resultat.getString( "Modele" );
                String statut = resultat.getString( "Statut" );
                String dateEntree = resultat.getString( "DateEntree" );
                String dateSortie = resultat.getString( "DateSortie" ); 
                	Vehicule v= new Vehicule ();
                	
                //vehicle n = new v(....)
                //ttt.add(n)
            }
             
 
        
        } catch (Exception e) {
        	System.out.println (e.getMessage());
			e.printStackTrace();
		} finally {
            if ( BdConnexion != null )		            
                try {		                    
                    BdConnexion.close();
                } catch ( SQLException ignore ) {
                  
                }
		
		/*
		 * 
		 */
		
		JButton btnGererAffectationVehicule = new JButton("Gerer affectation vehicule");
		btnGererAffectationVehicule.setBounds(65, 553, 273, 29);
		btnGererAffectationVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnGererAffectationVehicule.setBackground(Color.WHITE);
		frame.getContentPane().add(btnGererAffectationVehicule);
		
		JButton btnAjouterVehicule = new JButton("");
		btnAjouterVehicule.setIcon(new ImageIcon(GestionnaireFlotte.class.getResource("/icons/iconfinder_Increase_40066.png")));
		btnAjouterVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAjouterVehicule.setBounds(90, 236, 32, 29);
		btnAjouterVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnAjouterVehicule.setBackground(Color.WHITE);
		frame.getContentPane().add(btnAjouterVehicule);
		
		JButton btnSupprimerVehicule = new JButton("");
		btnSupprimerVehicule.setIcon(new ImageIcon(GestionnaireFlotte.class.getResource("/icons/seo-social-web-network-internet_262_icon-icons.com_61518.png")));
		btnSupprimerVehicule.setBounds(90, 315, 45, 29);
		btnSupprimerVehicule.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnSupprimerVehicule.setBackground(Color.WHITE);
		frame.getContentPane().add(btnSupprimerVehicule);
		
		JButton btnVoirReservation = new JButton("Voir reservation");
		btnVoirReservation.setBounds(65, 618, 273, 29);
		btnVoirReservation.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnVoirReservation.setBackground(Color.WHITE);
		frame.getContentPane().add(btnVoirReservation);
		
		JLabel lblBonjourAdmin = new JLabel("Welcome Admin");
		lblBonjourAdmin.setVerticalAlignment(SwingConstants.TOP);
		lblBonjourAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblBonjourAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 49));
		lblBonjourAdmin.setForeground(Color.BLUE);
		lblBonjourAdmin.setBounds(284, 0, 570, 75);
		frame.getContentPane().add(lblBonjourAdmin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 112, 803, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblGestionVehicule = new JLabel("Gestion Vehicules");
		lblGestionVehicule.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionVehicule.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblGestionVehicule.setForeground(Color.GREEN);
		lblGestionVehicule.setBounds(299, 140, 288, 48);
		frame.getContentPane().add(lblGestionVehicule);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(199, 509, 515, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1133, 690);
		frame.getContentPane().add(lblNewLabel);
				JButton NewButton = new JButton("New button");
				NewButton.addActionListener(null);
				
				frame.setVisible(true);
	}
	}
}
