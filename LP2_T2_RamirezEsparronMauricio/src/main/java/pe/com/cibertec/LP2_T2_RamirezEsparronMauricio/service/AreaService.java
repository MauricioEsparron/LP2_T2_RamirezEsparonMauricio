package pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.service;

import pe.com.cibertec.LP2_T2_RamirezEsparronMauricio.model.entity.AreaEntity;

import java.util.List;

public interface AreaService {
    List<AreaEntity> buscarAreas();
    void crearArea(AreaEntity area);
    AreaEntity buscarAreaPorId(Integer id);
    void actualizarArea(Integer id, AreaEntity area); 
    void eliminarArea(Integer id); 
}
