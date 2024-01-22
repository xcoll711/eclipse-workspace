package zzcurs;

public class Curso {
	private String id;
	private String descripcion;
	
	public Curso() {}
	public Curso(String id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	public String getId() {
		return id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Curso [id=" + id + ", descripcion=" + descripcion + "]";
	}
}