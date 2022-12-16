package com.escolinha.futebol.controller;


import com.escolinha.futebol.model.Jogador;
import com.escolinha.futebol.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


// Controlador
@RestController
@RequestMapping(value = "/{jogador}") // rota de mapeamento
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;



    @GetMapping
    public ResponseEntity<Object> getAllJogador(){
        return ResponseEntity.status(HttpStatus.OK).body(jogadorService.listarJogadores());
    }

    @PostMapping
    public ResponseEntity<Object> insertJogador(@RequestBody Jogador jogador){
        return ResponseEntity.status(HttpStatus.CREATED).body(jogadorService.cadastrarJogador(jogador));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getJogador (@PathVariable(value = "id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(jogadorService.listarJogador(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletJogador (@PathVariable(value = "id") Integer id){
        jogadorService.deletarJogador(id);
        return ResponseEntity.status(HttpStatus.OK).body("Jogador Removido da base de dados!!");
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateJogador (@PathVariable(value = "id") Integer id, @RequestBody Jogador jogador) {
        Optional<Jogador> dadosJogador = jogadorService.listarJogador(id);
        Jogador alterarJogador = dadosJogador.get();
        alterarJogador.setAltura(jogador.getAltura());
        alterarJogador.setCamisa(jogador.getCamisa());
        alterarJogador.setIdade(jogador.getIdade());
        alterarJogador.setNome(jogador.getNome());
        alterarJogador.setPerna(jogador.getPerna());
        alterarJogador.setPeso(jogador.getPeso());

        return ResponseEntity.status(HttpStatus.OK).body(jogadorService.cadastrarJogador(alterarJogador));
    }
}
