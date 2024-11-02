package repositories;

import java.util.ArrayList;
import java.util.List;

import models.Empleado;
import repositories.interfaces.EmpleadoRepo;

public class EmpleadosRepoSingleton implements EmpleadoRepo {
	
	//Singleton: Como queremos que este en nuestra raiz y sea accesible a todos.
	//Aplicamos singleton:
	//Consta de 3 cosas:
	//Singleton uno solo repo accesible
	//Constructor Privado
	//getInstance, nos trae la unica instancia del objeto, tiene que ser estatico y no recibe nada
	
	private static EmpleadosRepoSingleton singleton;
	
	public static EmpleadosRepoSingleton getInstance() {
		
		//Princioio de singleton -> el objeto no va a existir hasta que no se necesita, por eso tenemos que ver si se necesita.
		if (singleton == null) {
			singleton = new EmpleadosRepoSingleton();
			//si nunca existio, lo creamos
		}
		
		return singleton;
		//lo retornamos
	}

	private List<Empleado> listaEmpleados;

	// constructor
	private EmpleadosRepoSingleton() {
		this.listaEmpleados = new ArrayList<Empleado>();

		// agregamos algunos valores para tener algo de info
		Empleado empleado1 = new Empleado("Alan", 31, 200000);
		Empleado empleado2 = new Empleado("Chicho", 41, 30000);
		Empleado empleado3 = new Empleado("Jorge", 81, 230000);
		Empleado empleado4 = new Empleado("Felipe", 11, 30000);
		Empleado empleado5 = new Empleado("Felipe2", 12, 30000);

		this.insert(empleado1);
		this.insert(empleado2);
		this.insert(empleado3);
		this.insert(empleado4);
		this.insert(empleado5);
	}

	@Override
	public List<Empleado> getAll() {
		// retornamos una copia inmutable, asi no puede ser modificada por afuera.
		return new ArrayList<Empleado>(this.listaEmpleados);
	}

	@Override
	public Empleado findById(int id) {
		return this.listaEmpleados.stream()
			.filter((e) -> e.getId() == id)
			.findFirst()
			.orElse(null);
		
		//filtramos empleado por id, usamos findfirst para que nos traiga el objeto y si no existe, nos devuelve null
		
	}

	@Override
	public void insert(Empleado empleado) {
		int ultimaId = this.listaEmpleados.stream().map(Empleado::getId).max(Integer::compare).orElse(0);
		// transformamos la lista en numeros, buscamos el mayor, si no trae nada,
		// devuelva 0
		empleado.setId(ultimaId + 1);

		this.listaEmpleados.add(empleado);

	}

	@Override
	public void update(Empleado empleado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		this.listaEmpleados.removeIf((e)->e.getId() == id);
		
		//lo eliminamos de la lista si su id coincide.

	}

}
