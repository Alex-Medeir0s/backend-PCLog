package com.ueg.web.controller;

import com.ueg.web.exception.ResourceNotFoundException;
import com.ueg.web.model.ManutencaoPC;
import com.ueg.web.repository.ManutencaoPCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/manutencao/")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })

@RestController
public class ManutencaoPCController {

    @Autowired
    private ManutencaoPCRepository manutencaoRep;

    @GetMapping("/listar")
    public List<ManutencaoPC> listarTodas() {
        return manutencaoRep.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManutencaoPC> buscarPorId(@PathVariable Long id) {
        ManutencaoPC manutencao = manutencaoRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manutenção não encontrada: " + id));
        return ResponseEntity.ok(manutencao);
    }

    @PostMapping("/adicionar")
    public ManutencaoPC adicionar(@RequestBody ManutencaoPC manutencao) {
        return manutencaoRep.save(manutencao);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ManutencaoPC> atualizar(@PathVariable Long id, @RequestBody ManutencaoPC novaManutencao) {
        ManutencaoPC manutencao = manutencaoRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manutenção não encontrada: " + id));

        manutencao.setEquipamento(novaManutencao.getEquipamento());
        manutencao.setTipoManutencao(novaManutencao.getTipoManutencao());
        manutencao.setCusto(novaManutencao.getCusto());
        manutencao.setDataManutencao(novaManutencao.getDataManutencao());
        manutencao.setFoiConcluida(novaManutencao.getFoiConcluida());

        return ResponseEntity.ok(manutencaoRep.save(manutencao));
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Map<String, Boolean>> remover(@PathVariable Long id) {
        ManutencaoPC manutencao = manutencaoRep.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Manutenção não encontrada: " + id));

        manutencaoRep.delete(manutencao);

        Map<String, Boolean> resposta = new HashMap<>();
        resposta.put("removido", Boolean.TRUE);
        return ResponseEntity.ok(resposta);
    }
}
