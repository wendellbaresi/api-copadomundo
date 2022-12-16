package com.escolinha.futebol.service;

import com.escolinha.futebol.model.Jogador;
import com.escolinha.futebol.model.Posicao;
import com.escolinha.futebol.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

// Serviços
@Service
public class JogadorService {

    @Autowired // criação de dependencia
    private JogadorRepository jogadorRepository;

    public List<Jogador> listarJogadores (){
        List<Jogador> jogadores = jogadorRepository.findAll();
        return jogadores;
    }

    // Jogador vai ser direcionado a posição conforme o numero da sua camisa
    @Transactional
    public Jogador cadastrarJogador(Jogador jogador){
        Posicao posicao1 = new Posicao(1);
        Posicao posicao2 = new Posicao(2);
        Posicao posicao3 = new Posicao(3);
        Posicao posicao4 = new Posicao(4);

        if(jogador.getCamisa() == 1 || jogador.getCamisa() == 12 || jogador.getCamisa() ==24){
            jogador.setPosicao(posicao1);
        } else if (jogador.getCamisa() >= 2 && jogador.getCamisa() <= 5){
            jogador.setPosicao(posicao2);
        } else if (jogador.getCamisa() >= 6 && jogador.getCamisa() <= 8){
            jogador.setPosicao(posicao3);
        } else if (jogador.getCamisa() >= 9 && jogador.getCamisa() <= 11){
            jogador.setPosicao(posicao4);
        }
        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> listarJogador (Integer id){
        return jogadorRepository.findById(id);
    }

    @Transactional
    public void deletarJogador (Integer id){
        jogadorRepository.deleteById(id);
    }
}
