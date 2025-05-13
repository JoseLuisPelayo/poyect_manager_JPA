package modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Objects;
import java.math.BigDecimal;

/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String cif;

	private String apellidos;

	private String domicilio;

	@Column(name="facturacion_anual")
	private double facturacionAnual;

	private String nombre;

	@Column(name="numero_empleados")
	private int numeroEmpleados;

	public Cliente() {
	}

	public Cliente(String cif, String apellidos, String domicilio, double facturacionAnual, String nombre,
			int numeroEmpleados) {
		super();
		this.cif = cif;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.nombre = nombre;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return this.domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public double getFacturacionAnual() {
		return this.facturacionAnual;
	}

	public void setFacturacionAnual(double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroEmpleados() {
		return this.numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", apellidos=" + apellidos + ", domicilio=" + domicilio + ", facturacionAnual="
				+ facturacionAnual + ", nombre=" + nombre + ", numeroEmpleados=" + numeroEmpleados + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif);
	}
	

}