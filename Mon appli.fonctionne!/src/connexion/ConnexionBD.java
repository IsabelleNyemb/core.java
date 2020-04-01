package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnexionBD {
	
	
		public static void main (String[] args) throws Exception {
			getConnection();
			
		}
		
		public static Connection getConnection() throws Exception{
			try {
					String driver = "com.mysql.cj.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3307/gestionFlotte?useUnicode=true" + 
							"&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&" + 
							"serverTimezone=UTC";
					String username = "admin";
					String password = "Firenze2";
					Class.forName(driver);
					
					Connection conn = DriverManager.getConnection(url, username, password);
						//System.out.println("connected");
						return conn;
						
				}catch (Exception e) {
				//System.out.println (e);
				
					return null;
		}
			
			
			
			
			
			
			
		
		}	
			
			}


		
