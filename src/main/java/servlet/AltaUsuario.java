package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.UsuariosDao;
import utils.HibernateUtil;

/**
 * Servlet implementation class AltaUsuario
 */
@WebServlet("/AltaUsuario")
public class AltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = LogManager.getLogger(AltaUsuario.class);
	Session s;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AltaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
			String nombre = request.getParameter("usuario");
			String password = request.getParameter("password");
			UsuariosDao usuario = new UsuariosDao();
			//HttpSession session = request.getSession(true);
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			Transaction trans = session.beginTransaction();
			usuario.insertarUsuario(session, nombre, password);
			trans.commit();
	}

}
