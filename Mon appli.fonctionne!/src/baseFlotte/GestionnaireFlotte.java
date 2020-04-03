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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import connexion.ConnexionBD;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GestionnaireFlotte {

	private JFrame frame;
	private JTable Gtable;
	

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
		frame.getContentPane().setLayout(null);
		Connection BdConnexion= null;
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 204, 255));
		panel.setForeground(new Color(0, 0, 0));
		panel.setToolTipText("");
		panel.setBounds(15, 10, 446, 47);
		frame.getContentPane().add(panel);
		
		JLabel lblBienvenueDansVotre = new JLabel("Bienvenue dans votre espace administrateur");
		lblBienvenueDansVotre.setForeground(new Color(0, 102, 102));
		lblBienvenueDansVotre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblBienvenueDansVotre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 204, 255));
		panel_1.setBounds(0, 457, 834, 67);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAjouter.setBounds(57, 16, 121, 29);
		panel_1.add(btnAjouter);
		
		JButton btnSuppimer = new JButton("Suppimer");
		btnSuppimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSuppimer.setBounds(346, 16, 130, 29);
		panel_1.add(btnSuppimer);
		
		JButton btnSeDeconnecter = new JButton("Se deconnecter");
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnSeDeconnecter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSeDeconnecter.setBounds(604, 16, 182, 29);
		panel_1.add(btnSeDeconnecter);
		
		JPanel gestionRes = new JPanel();
		gestionRes.setBounds(116, 120, 500, 184);
		frame.getContentPane().add(gestionRes);
		
		JScrollPane scrollPane = new JScrollPane(Gtable);
		scrollPane.setViewportBorder(null);
		gestionRes.add(scrollPane);
		
		Gtable = new JTable(data, columnNames);		
		gestionRes.add(Gtable);
		Gtable.setFillsViewportHeight(true);
		Gtable.setSelectionBackground(Color.GRAY);
		Gtable.setForeground(Color.BLACK);
		Gtable.setBackground(Color.LIGHT_GRAY);
		Gtable.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
		Gtable.setVisible(true);
			
		
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

            }
            String [][] tab = new String [3][6];
            if(resultat.next()){
            	tab [0][1]= resultat.getString ("NomEmploye");
            	tab [0][2]= resultat.getString ("NumImmat");
            	tab [0][3]= resultat.getString("Modele");
            	tab [0][4]= resultat.getString("DateReserveh");
            	tab [0][5]= resultat.getString("DateRetourveh");
            	tab [0][6]= resultat.getString ("Statut");
            }
            
    				new DefaultTableModel(
    			tab,
    			new String[] {
    					"NomEmploye","NumImmat", "Modele", "DateReserveh", "DateRetourveh", "Statut"
    			}
    		)
    		;
                     
        } catch (Exception e) {
        	System.out.println (e.getMessage());
			e.printStackTrace();
		} finally {
            if ( BdConnexion != null )		            
                try {		                    
                    BdConnexion.close();
                } catch ( SQLException ignore ) {
                  
                }
		
				frame.setVisible(true);
	}
	}
}
