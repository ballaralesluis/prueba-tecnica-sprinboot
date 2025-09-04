package com.example.pruebaTecnicaSpringBoot.controller;

import com.example.pruebaTecnicaSpringBoot.models.Vuelo;
import com.example.pruebaTecnicaSpringBoot.service.VueloService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vuelos")
@Data
public class VueloController {

    private final VueloService vueloService;

    @GetMapping
    public ResponseEntity<List<Vuelo>> listar(@RequestParam Map<String,String> filtros){
        return ResponseEntity.ok(vueloService.listar(filtros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtener(@PathVariable Long id){
        return vueloService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vuelo> crear(@RequestBody Vuelo vuelo){
        try{
            return ResponseEntity.ok(vueloService.crear(vuelo));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizar(@PathVariable Long id, @RequestBody Vuelo vuelo){
        try {
            Vuelo actualizado = vueloService.actualizar(id, vuelo);
            return actualizado !=null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        vueloService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
