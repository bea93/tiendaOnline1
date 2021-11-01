package main.java.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import main.java.dao.RolesDao;
import main.java.utils.HibernateUtil;

/**
 * Servlet implementation class CrearRol
 */
@WebServlet("/CrearRol")
public class CrearRol extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = LogManager.getLogger(AltaUsuario.class);
	Session s;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearRol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int idRol = Integer.parseInt(request.getParameter("idRol"));
		String nombre = request.getParameter("nombreRol");
		
		if(RolesDao.insertarRol(s, idRol, nombre)) {
			out.println("<h1>Se ha creado el rol correctamente</h1>");
		}else {
			out.println("<h1>No se ha podido crear el rol correctamente</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
