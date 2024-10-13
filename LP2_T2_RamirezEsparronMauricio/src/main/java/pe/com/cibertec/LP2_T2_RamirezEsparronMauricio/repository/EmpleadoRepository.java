package pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity.EmpleadoEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, String> {
	List<EmpleadoEntity> findByAreaEntity_Id(Integer areaId);

	Optional<EmpleadoEntity> findByDniEmpleado(String dni);
	
	List<EmpleadoEntity> findByNombreEmpleado(String nombre);

	List<EmpleadoEntity> findByApellidoEmpleado(String apellido);
}
