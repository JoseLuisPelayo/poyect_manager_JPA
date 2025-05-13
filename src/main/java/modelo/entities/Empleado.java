package modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


/**
 * The persistent class for the empleados database table.
 * 
 */
@Entity
@Table(name="empleados")

public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empl")
	private int idEmpl;

	private String apellidos;

	private String email;

//	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ingreso")
	private LocalDate fechaIngreso;

 //	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;

	private String genero;

	private String nombre;

	private String password;

	private double salario;

	//uni-directional many-to-one association to Departamento
	@ManyToOne
	@JoinColumn(name="id_depar")
	private Departamento departamento;

	//uni-directional many-to-one association to Perfil
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private Perfil perfil;

	public Empleado() {
	}



	public Empleado(int idEmpl, String apellidos, String email, LocalDate fechaIngreso, LocalDate fechaNacimiento, String genero,
			String nombre, String password, double salario, Departamento departamento, Perfil perfil) {
		super();
		this.idEmpl = idEmpl;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaIngreso = fechaIngreso;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
		this.nombre = nombre;
		this.password = password;
		this.salario = salario;
		this.departamento = departamento;
		this.perfil = perfil;
	}



	public int getIdEmpl() {
		return this.idEmpl;
	}

	public void setIdEmpl(int idEmpl) {
		this.idEmpl = idEmpl;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpl=" + idEmpl + ", apellidos=" + apellidos + ", email=" + email + ", fechaIngreso="
				+ fechaIngreso + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", nombre=" + nombre
				+ ", password=" + password + ", salario=" + salario + ", departamento=" + departamento + ", perfil="
				+ perfil + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idEmpl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Empleado))
			return false;
		Empleado other = (Empleado) obj;
		return idEmpl == other.idEmpl;
	}
	
	//METODOS PROPIOS
	
}