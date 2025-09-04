package com.example.pruebaTecnicaSpringBoot.service;

import com.example.pruebaTecnicaSpringBoot.models.Vuelo;
import com.example.pruebaTecnicaSpringBoot.repository.VueloRepository;
import com.example.pruebaTecnicaSpringBoot.utils.FechaUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VueloService {
    private final VueloRepository vueloRepository = new VueloRepository();

    public List<Vuelo> listar(Map<String, String> filtros) {
        return vueloRepository.findAll(filtros);
    }

    public Optional<Vuelo> buscarPorId(Long id) {
        return vueloRepository.findById(id);
    }

    public Vuelo crear(Vuelo vuelo) {
        if (vuelo.getNombreVuelo() == null || vuelo.getNombreVuelo().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if (!FechaUtils.validarFechas(vuelo.getFechaSalida(), vuelo.getFechaLlegada())) {
            throw new IllegalArgumentException("Las fechas no son validas");
        }
        return vueloRepository.save(vuelo);
    }

    public Vuelo actualizar(Long id, Vuelo vuelo) {
        if (!FechaUtils.validarFechas(vuelo.getFechaSalida(), vuelo.getFechaLlegada())) {
            throw new IllegalArgumentException("Las fechas no son validas");
        }
        return vueloRepository.update(id, vuelo);
    }
    public void eliminar(Long id){
        vueloRepository.delete(id);
    }
}