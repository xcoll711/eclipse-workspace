package examenudp_xavi;


public class Alumno {
	private String idAlumno;
	private String nombre;
	private Curso curso;
	private int nota;
	
	public Alumno() {}
	public Alumno(String idAlumno, String nombre, Curso curso, int nota) {
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.curso = curso;
		this.nota = nota;
	}
	public String getIdAlumno() {
		return idAlumno;
	}
	public String getNombre() {
		return nombre;
	}
	public Curso getCurso() {
		return curso;
	}
	public int getNota() {
		return nota;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	@Override
	public String toString() {
		return "Alumno  "
				+ "\n\t    ID del alumno ->\t" + idAlumno + "\n\t    Nombre ->\t\t" + nombre + "\n\t"
						+ "Curso \n\t" + curso 
							+ "\n\t  Nota ->\t\t" + nota;
		
	}
}