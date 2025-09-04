package com.example.pruebaTecnicaSpringBoot.repository;

import com.example.pruebaTecnicaSpringBoot.models.Vuelo;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class VueloRepository {
    private final List<Vuelo> vuelos = new ArrayList<>();
    private final AtomicLong secuenciaId = new AtomicLong(1);

    public VueloRepository(){
        vuelos.addAll(List.of(
                new Vuelo(secuenciaId.getAndIncrement(), "A001-A", "Iberia", "Madrid", "Bilbao", LocalDate.of(2025,3,10), LocalDate.of(2025,3,11)),
                new Vuelo(secuenciaId.getAndIncrement(), "B002-B", "Turkish", "Estambul", "New York", LocalDate.of(2025,4,1), LocalDate.of(2025,4,2)),
                new Vuelo(secuenciaId.getAndIncrement(), "C003-C", "Emirates", "Dubai", "Tokio", LocalDate.of(2025,5,15), LocalDate.of(2025,5,16)),
                new Vuelo(secuenciaId.getAndIncrement(), "D004-D", "Rutaca", "Caracas", "Tachira", LocalDate.of(2025,6,20), LocalDate.of(2025,6,20)),
                new Vuelo(secuenciaId.getAndIncrement(), "E005-E", "Lufthansa", "Londres", "Milan", LocalDate.of(2025,7,5), LocalDate.of(2025,7,5)),
                new Vuelo(secuenciaId.getAndIncrement(), "F006-F", "American Airlines", "Miami", "Madrid", LocalDate.of(2025,11,10), LocalDate.of(2025,11,11)),
                new Vuelo(secuenciaId.getAndIncrement(), "G007-G", "klm", "Madrid", "Roma", LocalDate.of(2025,9,8), LocalDate.of(2025,9,8)),
                new Vuelo(secuenciaId.getAndIncrement(), "H008-H", "Easy Jet", "Sevilla", "Mallorca", LocalDate.of(2025,10,3), LocalDate.of(2025,10,3)),
                new Vuelo(secuenciaId.getAndIncrement(), "I009-I", "Ryanair", "Vitoria Gasteiz", "Sevilla", LocalDate.of(2025,11,10), LocalDate.of(2025,11,10)),
                new Vuelo(secuenciaId.getAndIncrement(), "J000-J", "Vueling Airlines", "Alicante", "Talavera la Real", LocalDate.of(2025,12,25), LocalDate.of(2025,12,25))
        ));
    }

    public List<Vuelo> findAll(Map<String,String> filtros){
        return vuelos.stream()
                .filter(v->filtros.get("empresa")==null||v.getEmpresa().equalsIgnoreCase(filtros.get("empresa")))
                .filter(vuelo -> filtros.get("lugarLlegada")==null|| vuelo.getLugarLlegada().equalsIgnoreCase(filtros.get("lugarLlegada")))
                .filter(vuelo -> filtros.get("fechaSalida")==null|| vuelo.getFechaSalida().equals(LocalDate.parse(filtros.get("fechaSalida"))))
                .sorted(Comparator.comparing(Vuelo::getFechaSalida))
                .collect(Collectors.toList());
    }

    public Optional<Vuelo> findById(Long id){
        return vuelos.stream().filter(vuelo -> vuelo.getId().equals(id)).findFirst();
    }

    public Vuelo save(Vuelo vuelo){
        vuelo.setId(secuenciaId.getAndIncrement());
        vuelos.add(vuelo);
        return vuelo;
    }

    public void delete(Long id){
        vuelos.removeIf(vuelo -> vuelo.getId().equals(id));
    }

    public Vuelo update(Long id, Vuelo nuevo){
        return findById(id).map(v -> {
            v.setNombreVuelo(nuevo.getNombreVuelo());
            v.setEmpresa(nuevo.getEmpresa());
            v.setLugarSalida(nuevo.getLugarSalida());
            v.setLugarLlegada(nuevo.getLugarLlegada());
            v.setFechaSalida(nuevo.getFechaSalida());
            v.setFechaLlegada(nuevo.getFechaLlegada());
            return v;
        }).orElse(null);
    }
}