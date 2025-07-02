package com.flps.CadastroDeNinjas.controller;

import com.flps.CadastroDeNinjas.models.NinjaModel;
import com.flps.CadastroDeNinjas.service.NinjaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping
    public List<NinjaModel> findAll() {
        return ninjaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaModel> findById(@PathVariable Long id) {
        return ninjaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NinjaModel> save(@RequestBody NinjaModel ninjaModel) {
        NinjaModel save = ninjaService.save(ninjaModel);
        return ResponseEntity.created(null).body(save);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NinjaModel> update(@PathVariable Long id, @RequestBody NinjaModel ninjaUpdate) {
        return ninjaService.findById(id)
                .map(ninjaExist -> {
                    ninjaUpdate.setId(id);
                    NinjaModel save = ninjaService.save(ninjaUpdate);
                    return ResponseEntity.ok(save);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return ninjaService.findById(id)
                .map(ninja -> {
                    ninjaService.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
