// src/main/java/com/flps/CadastroDeNinjas/controller/MissoesController.java
package com.flps.CadastroDeNinjas.controller;

import com.flps.CadastroDeNinjas.models.MissoesModel;
import com.flps.CadastroDeNinjas.service.MissoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/missoes")
public class MissoesController {

    private final MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    /**
     * GET /api/missoes
     * Retorna todas as missões.
     */
    @GetMapping
    public List<MissoesModel> listarTodas() {
        return missoesService.findAll();
    }

    /**
     * GET /api/missoes/{id}
     * Busca uma missão por ID.
     * Se existir, retorna 200 OK com o recurso; senão, 404 Not Found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MissoesModel> buscarPorId(@PathVariable Long id) {
        return missoesService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * POST /api/missoes
     * Cria uma nova missão.
     * Retorna 201 Created com Location apontando para o novo recurso.
     */
    @PostMapping
    public ResponseEntity<MissoesModel> criar(@RequestBody MissoesModel missoes) {
        MissoesModel criado = missoesService.save(missoes);
        URI uri = URI.create("/api/missoes/" + criado.getId());
        return ResponseEntity.created(uri).body(criado);
    }

    /**
     * PUT /api/missoes/{id}
     * Atualiza uma missão existente.
     * Se encontrado, atualiza e retorna 200 OK; senão, 404 Not Found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<MissoesModel> atualizar(
            @PathVariable Long id,
            @RequestBody MissoesModel missoesAtualizada) {

        return missoesService.findById(id)
                .map(existente -> {
                    // Define o ID para que o JPA faça UPDATE e não INSERT
                    missoesAtualizada.setId(id);
                    MissoesModel salvo = missoesService.save(missoesAtualizada);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/missoes/{id}
     * Remove uma missão por ID.
     * Se existia, retorna 204 No Content; senão, 404 Not Found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return missoesService.findById(id)
                .map(existente -> {
                    missoesService.delete(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
