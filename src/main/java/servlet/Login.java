package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dao.UsuariosDao;
import entities.Usuarios;
import utils.HibernateUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	static Logger logger = LogManager.getLogger(Login.class);
	Session s;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			String usuario, password;
			PrintWriter out = response.getWriter();

			usuario = request.getParameter("usuario");
			password = request.getParameter("password");

			UsuariosDao u = new UsuariosDao();

			if (u.devolverUsuario(session, usuario, password)) {
				logger.info("El usuario se ha logueado correctamente.");

				// Integer rol = u.rolUsuario(session, usuario, password);
				HttpSession session1 = request.getSession(true);

				Usuarios datosUsuario = new Usuarios();
				String apellido1 = datosUsuario.getApellido1();
				String apellido2 = datosUsuario.getApellido2();
				LocalTime fecha = LocalTime.now();
				session1.setAttribute("nombre", usuario);
				session1.setAttribute("apellido1", apellido1);
				session1.setAttribute("apellido2", apellido2);
				session1.setAttribute("fecha", fecha);
				// session1.setAttribute("rol", rol);
				response.sendRedirect("menu.jsp");
				session1.setMaxInactiveInterval(0);
			} else {
				logger.info("El usuario no ha introducido las credenciales correctamente.");
				response.sendRedirect("index.html");
			}

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			logger.error("Error al consultar el usuario ingresado por login", e);

		} finally {
			if (session != null) {
				session.close();
				logger.info("Cerramos la sesion del servlet login");
			}
		}

		// Cerramos la sesion
		session.close();

		logger.info("Se acaba la ejecución del servlet login.");

	}
}
