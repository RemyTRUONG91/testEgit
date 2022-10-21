import java.sql.*;

public class main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection nom_connexion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 nom_connexion = DriverManager.getConnection("jdbc:mysql://172.16.203.204/gsbfrais?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","sio","slam");
		
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur du chargement du Pilote jbdc"+ e);
		} catch (SQLException e) {
			System.out.print("Erreur de Connexion"+ e);
		}
		/*try {
			 Statement st = nom_connexion.createStatement();
			 st.executeUpdate("INSERT INTO Etat(id,libelle)VALUES(99,'test')");
			 nom_connexion.close();
			
		} catch(SQLException e) {
			System.out.print("erreur"+ e);
		}*/
		try {
			Statement st = nom_connexion.createStatement();
			String unId;
			String nom;
			ResultSet rs = st.executeQuery("Select * from Etat");
			while(rs.next()) {
				unId = rs.getString(1);
				nom = rs.getString(2);
				System.out.println("Libelle = " + nom + "ID :" + unId);
				
			}
			rs.close();
			nom_connexion.close();
		}
		catch(SQLException e) {
			System.out.print("erreur" + e);
		}

	}
	
}
