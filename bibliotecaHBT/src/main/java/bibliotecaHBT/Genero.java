package bibliotecaHBT;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
	@Table(name="genero")

public class Genero {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_genero;
	private String nombre;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Libro> generos = new ArrayList();
	
	
	public Genero(int id_genero, String nombre, List<Libro> generos) {
		super();
		this.id_genero = id_genero;
		this.nombre = nombre;
		this.generos = generos;
	}


	public Genero() {
		// TODO Auto-generated constructor stub
	}


	public int getId_genero() {
		return id_genero;
	}


	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Libro> getGeneros() {
		return generos;
	}


	public void setGeneros(List<Libro> generos) {
		this.generos = generos;
	}
	

}
