package pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity.AreaEntity;
import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.repository.EmpleadoRepository;
import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.service.EmpleadosService;
import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.service.AreaService;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadosService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private AreaService areaService;

	@Override
	public List<EmpleadoEntity> buscarEmpleados() {
		return empleadoRepository.findAll();
	}

	@Override
	public void crearEmpleado(EmpleadoEntity empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public EmpleadoEntity buscarEmpleadoPorDni(String dni) {
		Optional<EmpleadoEntity> empleado = empleadoRepository.findByDniEmpleado(dni);
		if (empleado.isPresent()) {
			return empleado.get();
		} else {
			throw new RuntimeException("Empleado no encontrado");
		}
	}

	@Override
	public List<EmpleadoEntity> buscarEmpleadosPorArea(Integer areaId) {
		return empleadoRepository.findByAreaEntity_Id(areaId);
	}

	@Override
	public void actualizarEmpleado(String dni, EmpleadoEntity empleado) {
	    EmpleadoEntity empleadoExistente = buscarEmpleadoPorDni(dni);
	    if (empleadoExistente != null) {
	        empleadoExistente.setNombreEmpleado(empleado.getNombreEmpleado());
	        empleadoExistente.setApellidoEmpleado(empleado.getApellidoEmpleado());
	        empleadoExistente.setCorreo(empleado.getCorreo());
	        empleadoExistente.setDireccion(empleado.getDireccion());
	        empleadoExistente.setFechaNacimiento(empleado.getFechaNacimiento());
	        empleadoExistente.setAreaEntity(empleado.getAreaEntity());
	        // Guardar cambios en la base de datos
	        empleadoRepository.save(empleadoExistente);
	    }
	}


	@Override
	public void eliminarEmpleado(String dni) {
		EmpleadoEntity empleadoEncontrado = buscarEmpleadoPorDni(dni);
		if (empleadoEncontrado == null) {
			throw new RuntimeException("Empleado no encontrado");
		}
		empleadoRepository.delete(empleadoEncontrado);
	}

	@Override
	public List<EmpleadoEntity> buscarEmpleadosPorNombre(String nombre) {
		return empleadoRepository.findByNombreEmpleado(nombre);
	}

	@Override
	public List<EmpleadoEntity> buscarEmpleadosPorApellido(String apellido) {
		return empleadoRepository.findByApellidoEmpleado(apellido);
	}
}
