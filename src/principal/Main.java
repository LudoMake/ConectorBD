package principal;

import java.sql.Connection;

import utilidades.ConexionDB;

public class Main {

	public static void main(String[] args) {
		ConexionDB conexionDB = new ConexionDB();

		System.out.println("Conectando a la base de datos tienda...");

		Connection con = conexionDB.getConexion();
		System.out.println("Liberando la conexion");

		// operaciones contra la base de datos...
		conexionDB.desconectar();

	}

}
