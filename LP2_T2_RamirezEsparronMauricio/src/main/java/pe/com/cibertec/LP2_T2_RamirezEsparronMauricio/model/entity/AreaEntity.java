package pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tb_area")
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "area_id", nullable = false)
    private Integer id;

    @Column(name = "nombre_area", length = 45, nullable = false)
    private String nombreArea;

    @OneToMany(mappedBy = "areaEntity")
    private Set<EmpleadoEntity> empleados;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}
    
    
}
