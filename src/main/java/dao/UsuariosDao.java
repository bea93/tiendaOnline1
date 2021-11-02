package dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Usuarios;

public class UsuariosDao {

	static Logger logger = LogManager.getLogger(UsuariosDao.class);
	
public boolean devolverUsuario(Session s, String nombreUsuario, String password) {
		
	List<Usuarios> listaUsuarios = s.createNativeQuery("SELECT * FROM usuarios WHERE nombre ='" + nombreUsuario + "'and clave='" + password + "'").list();
		
		if (listaUsuarios.isEmpty() ) {
			return false;
		}else {
			return true;
		}
	}
	
}
