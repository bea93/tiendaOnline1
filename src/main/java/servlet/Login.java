package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import dao.UsuariosDao;
import entities.Usuarios;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String usuario, password;
		PrintWriter out = response.getWriter();
		
		usuario = request.getParameter("usuario");
		password = request.getParameter("password");
		
		/*Usuarios u = UsuariosDao.devolverUsuarioEmail(s, usuario);
		
		if(u != null) {
			if(password.equals(u.getClave())){
				out.println("<h1>Se ha iniciado sesion correctamente</h1>");
				out.println("<p>Hola "+usuario+"</p>");
				out.println("<br>");
				out.println("Ultima sesion iniciada "+LocalDate.now());
			}else {
				out.println("<h1>No se ha iniciado sesion correctamente</h1>");
			}
		}else {
			logger.warn("El usuario no existe");
			out.println("<h1>No se ha iniciado sesion el usuario no existe</h1>");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private static SessionFactory buildSessionFactory() {
		String methodName = Login.class.getSimpleName() + ".buildSessionFactory()";

		final StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		try {
			Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
			SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
			return sessionFactory;
		} catch (Exception ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

}
