package bibliotecaHBT;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro {
	private String titulo;
	private String id_genero;
	private String estado;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	public Libro() {
		
	}
	public Libro(String titulo, String id_genero, String estado, int id) {
		super();
		this.titulo = titulo;
		this.id_genero = id_genero;
		this.estado = estado;
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getId_genero() {
		return id_genero;
	}
	public void setId_genero(String id_genero) {
		this.id_genero = id_genero;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
}
