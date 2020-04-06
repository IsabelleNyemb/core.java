package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.xml.bind.ValidationEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Register  {

	private JFrame frame;
	private JTextField CaseNomR;
	private JTextField CasePrenomR;
	private JTextField CaseUserNameR;
	private JPasswordField CaseMDPR;
	private JPasswordField CaseMDP2R;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setSize(new Dimension(679, 589));
		
		JLabel Register = new JLabel("Page d'enregistrement");
		Register.setBounds(202, -2, 224, 60);
		Register.setForeground(Color.BLUE);
		Register.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Register.setBackground(Color.BLUE);
		frame.getContentPane().add(Register);
		
		JLabel nom = new JLabel("Nom");
		nom.setForeground(Color.BLACK);
		nom.setFont(new Font("Sitka Text", Font.BOLD, 18));
		nom.setBackground(Color.WHITE);
		nom.setBounds(91, 109, 105, 23);
		frame.getContentPane().add(nom);
		
		CaseNomR = new JTextField();
		CaseNomR.setColumns(10);
		CaseNomR.setBounds(289, 109, 224, 26);
		frame.getContentPane().add(CaseNomR);
		
		JLabel prenom = new JLabel("Prenom");
		prenom.setForeground(Color.BLACK);
		prenom.setFont(new Font("Sitka Text", Font.BOLD, 18));
		prenom.setBackground(Color.WHITE);
		prenom.setBounds(91, 167, 105, 23);
		frame.getContentPane().add(prenom);
		
		JLabel UserNameR = new JLabel("UserName");
		UserNameR.setForeground(Color.BLACK);
		UserNameR.setFont(new Font("Sitka Text", Font.BOLD, 18));
		UserNameR.setBackground(Color.WHITE);
		UserNameR.setBounds(91, 238, 105, 23);
		frame.getContentPane().add(UserNameR);
		
		CasePrenomR = new JTextField();
		CasePrenomR.setColumns(10);
		CasePrenomR.setBounds(289, 164, 224, 26);
		frame.getContentPane().add(CasePrenomR);
		
		CaseUserNameR = new JTextField();
		CaseUserNameR.setColumns(10);
		CaseUserNameR.setBounds(289, 235, 224, 26);
		frame.getContentPane().add(CaseUserNameR);
		
		JLabel Validated = new JLabel("Validated account"); // doit être placé avant le bouton pour qu'il l'active
		Validated.setForeground(Color.GREEN);
		Validated.setBackground(Color.WHITE);
		Validated.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		Validated.setBounds(0, 0, 208, 20);
		frame.getContentPane().add(Validated);
		Validated.setVisible(false); // pour cacher le message validated à l'initialisation de la page
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Nom = CaseNomR.getText();
				String Prenom = CasePrenomR.getText();
				String UserName = CaseUserNameR.getText();
				char[] PassWordR = CaseMDPR.getPassword();
				char[] PassWordR2 = CaseMDP2R.getPassword();
					System.out.println(Nom);
					System.out.println(Prenom);
					System.out.println(UserName);
					System.out.println(new String (PassWordR));
					System.out.println(new String (PassWordR2));
					Validated.setVisible(true);		
			
			}
				
			});
		
		btnCreate.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnCreate.setBackground(Color.CYAN);
		btnCreate.setBounds(476, 446, 105, 29);
		frame.getContentPane().add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); // on ferme register
				new pageaccueil(); //la page d'accueil s'ouvre après fermeture de register
			
			}
			
		});
		btnCancel.setFont(new Font("Sitka Text", Font.BOLD, 18));
		btnCancel.setBackground(Color.RED);
		btnCancel.setBounds(105, 446, 103, 29);
		frame.getContentPane().add(btnCancel);
		
		JLabel MDPReg = new JLabel("MotDePasse");
		MDPReg.setFont(new Font("Sitka Text", Font.BOLD, 18));
		MDPReg.setBackground(Color.WHITE);
		MDPReg.setBounds(88, 289, 120, 20);
		frame.getContentPane().add(MDPReg);
		
		JLabel MPD2Reg = new JLabel("Confirmer MDP");
		MPD2Reg.setFont(new Font("Sitka Text", Font.BOLD, 18));
		MPD2Reg.setBackground(Color.WHITE);
		MPD2Reg.setBounds(91, 348, 151, 20);
		frame.getContentPane().add(MPD2Reg);
		
		CaseMDPR = new JPasswordField();
		CaseMDPR.setBounds(289, 285, 224, 26);
		frame.getContentPane().add(CaseMDPR);
		
		CaseMDP2R = new JPasswordField();
		CaseMDP2R.setBounds(289, 344, 224, 26);
		frame.getContentPane().add(CaseMDP2R);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/icons/00rwOTBCG9wGtuLysGi7UEh8oGSSK4Q3T2sZ2aeS.jpeg")));
		lblNewLabel.setBounds(0, -1, 673, 550);
		frame.getContentPane().add(lblNewLabel);
				
		frame.setVisible(true); // la page register devient visible quand tout s'éxécute
	}
}

