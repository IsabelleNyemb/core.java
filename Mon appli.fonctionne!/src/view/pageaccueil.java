package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.Controller;
import model.Employe;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class pageaccueil {
		
	
	private JFrame frame;
	private JTextField CaseUserName;
	private JPasswordField CaseMDP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageaccueil window = new pageaccueil();
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
	public pageaccueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 544, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Error = new JLabel("Erreur de connexion");
		Error.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Error.setForeground(Color.RED);
		Error.setBounds(0, 59, 193, 20);
		frame.getContentPane().add(Error);
		Error.setVisible(false);
		
		JLabel Success = new JLabel("connected success");
		Success.setForeground(Color.GREEN);
		Success.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Success.setBounds(15, 41, 183, 20);
		frame.getContentPane().add(Success);
		Success.setVisible(false);		
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(137, 16, 207, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel textUserName = new JLabel("UserName");
		textUserName.setForeground(Color.BLACK);
		textUserName.setFont(new Font("Sitka Text", Font.BOLD, 18));
		textUserName.setBackground(Color.WHITE);
		textUserName.setBounds(50, 118, 105, 23);
		frame.getContentPane().add(textUserName);
		
		JLabel textMotDePasse = new JLabel("MotDePasse");
		textMotDePasse.setFont(new Font("Sitka Text", Font.BOLD, 18));
		textMotDePasse.setBackground(Color.WHITE);
		textMotDePasse.setBounds(34, 186, 120, 20);
		frame.getContentPane().add(textMotDePasse);
		
		CaseUserName = new JTextField();
		CaseUserName.setBounds(228, 115, 212, 26);
		frame.getContentPane().add(CaseUserName);
		CaseUserName.setColumns(10);
		
		CaseMDP = new JPasswordField();
		CaseMDP.setBounds(222, 186, 212, 26);
		frame.getContentPane().add(CaseMDP);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.CYAN);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Name = CaseUserName.getText();
				char[] PassWord = CaseMDP.getPassword();	
				System.out.println(Name);
				System.out.println(PassWord);
				Employe Em= Controller.getIdentifiant(Name, new String(PassWord));	
				if(Em.getIdemploye()=="") {
					Error.setVisible(true);
				}
				else {
					new Jemeconnecte(Em);
					frame.dispose();
				}								
			}
		});
		btnLogin.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnLogin.setBounds(389, 275, 89, 29);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(Color.WHITE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CaseUserName.setText("");
				CaseMDP.setText("");
				Error.setVisible(false);
				Success.setVisible(false);
			}	
						
		});
		btnReset.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnReset.setBounds(224, 275, 97, 29);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnExit.setBounds(50, 275, 81, 29);
		frame.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(61, 187, 379, -3);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 41, 478, 2);
		frame.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 182, 1, 2);
		frame.getContentPane().add(separator_2);
		
		JButton btnRegister = new JButton("Create a new account");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register();
				frame.dispose();								
			}			
			
		});
		btnRegister.setBackground(Color.LIGHT_GRAY);
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		btnRegister.setBounds(175, 400, 193, 29);
		frame.getContentPane().add(btnRegister);	
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(pageaccueil.class.getResource("/icons/JiMIZ0LpuTRpT3WzDCa4lIYOPBFSBNya5VXmnya0.jpeg")));
		lblNewLabel_1.setBounds(0, 0, 563, 509);
		frame.getContentPane().add(lblNewLabel_1);
		
		frame.setVisible(true);// la page d'accueil se ferme quand on ouvre le register
	}
	}
