package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
	// datos de la conexion
	private static String database = "tienda";
	private static String user = "tienda";
	private static String password = "1234";
	private static String url = "jdbc:mysql://localhost:3306/" + database; // esto para conectar a la bbdd

	// si o si la base de datos, usuario y password tienen que estar bien escritos
	// tal y como aparecen en mysql sino no funciona

	// objeto connection
	private Connection conexion = null; // esto para importar java.sql.connection

	public Connection getConexion() { // obtener conexion
		if (conexion != null) { // aqui pondriamos = a null si el driver esta ya registrado
			return this.conexion;
		}
		// registramos el driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // escribir perfecto lo del parentesis porque sino no funciona
			// solicitar objeto connection
			this.conexion = DriverManager.getConnection(url, user, password);
			System.out.println("Conexion realizada correctamente");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha podido registrar el driver");
			e.printStackTrace();
		} // lo ideal es hacerlo con throw en vez de try catch
		catch (SQLException e) {
			System.out.println("No se ha podido conectar" + e.getMessage());
			e.printStackTrace();
		}
		return this.conexion;
	}

	// metodo para borrar/cerrar la conexion. Ideal el throw pero usamos try catch
	public void desconectar() {
		try {
			this.conexion.close();
		} catch (SQLException e) {
			System.out.println("Error, liberando la conexion");
			e.printStackTrace();
		}
	}
}
