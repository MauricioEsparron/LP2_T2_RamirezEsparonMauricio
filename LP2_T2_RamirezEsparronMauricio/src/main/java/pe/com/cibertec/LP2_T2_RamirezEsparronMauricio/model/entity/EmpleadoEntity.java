package pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "tb_empleado")
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoEntity {

    @Id
    @Column(name = "dni_empleado", length = 8, nullable = false)
    private String dniEmpleado;

    @Column(name = "nombre_empleado", length = 45, nullable = false)
    private String nombreEmpleado;

    @Column(name = "apellido_empleado", length = 45, nullable = false)
    private String apellidoEmpleado;

    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaNacimiento;

    @Column(name = "direccion", length = 45, nullable = false)
    private String direccion;

    @Column(name = "correo", length = 45, nullable = false)
    private String correo;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private AreaEntity areaEntity;

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}

	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public AreaEntity getAreaEntity() {
		return areaEntity;
	}

	public void setAreaEntity(AreaEntity areaEntity) {
		this.areaEntity = areaEntity;
	}
    
    
}
