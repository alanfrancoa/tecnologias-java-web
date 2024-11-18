package controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Empleado;
import repositories.EmpleadosRepoSingleton;
import repositories.interfaces.EmpleadoRepo;


@WebServlet("/empleados")
public class EmpleadosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpleadoRepo empleadosRepo;
       
    public EmpleadosController() {
    	this.empleadosRepo = EmpleadosRepoSingleton.getInstance();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String accion = request.getParameter("accion");
		accion = Optional.ofNullable(accion).orElse("index");
		//si la accion no me manda nada, entiendo que van al index.
		
		switch (accion) {
			case "index" -> getIndex(request, response);
			case "bienvenida" -> getBienvenida(request, response);
			case "show" -> getShow(request, response);
			case "edit" -> getEdit(request, response);
			case "create" -> getCreate(request, response);
		
		default -> response.sendError(404);
		}
		
	}

	private void getBienvenida(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.sendRedirect("views/empleados/bienvenida.jsp"); esta opc es valida, pero nos cambia la url.
		request.getRequestDispatcher("/views/empleados/bienvenida.jsp").forward(request, response);

	}

	private void getCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/views/empleados/create.jsp").forward(request, response);

	}

	private void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);		
		EmpleadoRepo repo = EmpleadosRepoSingleton.getInstance();
		
		Empleado emple = repo.findById(id);
		
		request.setAttribute("empleado", emple);
		request.getRequestDispatcher("/views/empleados/edit.jsp").forward(request, response);
		
	}

	private void getShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);	
		
		Empleado emple = empleadosRepo.findById(id);
		
		request.setAttribute("empleado", emple);
		request.getRequestDispatcher("/views/empleados/show.jsp").forward(request, response);
	}

	private void getIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//instancio el repo
		EmpleadoRepo repo = EmpleadosRepoSingleton.getInstance();
		
		//me traigo el listado
		List<Empleado> listaEmp = repo.getAll();
		
		//Lo envio con el atributo listita que levantamos de la vista.
		request.setAttribute("listita", listaEmp);
		
		request.getRequestDispatcher("/views/empleados/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(400);
	}

}
