package models;

public class Empleado {
	
	//Attributes
	private int id;
	private String nombre;
	private int edad;
	private double sueldo;
	
	//constructor
	public Empleado( String nombre, int edad, double sueldo) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	
	//constructor vacio
	public Empleado() {
		super();
	}
	
	//getters y S
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", sueldo=" + sueldo + "]";
	}
	
	//ToString
	
	
}
