package dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Usuarios;

public class UsuariosDao {

	static Logger logger = LogManager.getLogger(UsuariosDao.class);

	/*public static boolean consultarUsuario(Session s, String dni) {
		String hql = "from Usuarios u where dni = :dni";
		Usuarios u = s.createQuery(hql, Usuarios.class).setParameter("dni", dni).setMaxResults(1).uniqueResult();
		if (u != null) {
			logger.info("Se ha encontrado el usuario");
			return true;
		}
		logger.info("No se ha encontrado el usuario");
		return false;
	}

	public static Usuarios devolverUsuarioEmail(Session s, String email) {
		String hql = "from Usuarios u where email = :email";
		Usuarios u = s.createQuery(hql, Usuarios.class).setParameter("email", email).setMaxResults(1).uniqueResult();

		if (u != null) {
			logger.info("El usuario existe");
		} else {
			logger.warn("El usuario no existe");
		}

		return u;
	}*/

	public void insertarUsuario(Session s, String nombre, String password) {
		// TODO Auto-generated method stub
		String nombreRegistro = nombre;
		String passwordRegistro = password;
		/*Usuarios user = new Usuarios(nombre, password);
		s.save(user);*/
	}
}
