package com.steel.financecontrol.application.service;

import com.steel.financecontrol.domain.exception.ContaNaoEncontradaException;
import com.steel.financecontrol.domain.repository.ContaRepository;
import com.steel.financecontrol.domain.repository.RendimentoRepository;
import com.steel.financecontrol.model.Conta;
import com.steel.financecontrol.model.Rendimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceiroService {

    private final ContaRepository contaRepository;
    private final RendimentoRepository rendimentoRepository;


    @Autowired
    public FinanceiroService(ContaRepository contaRepository, RendimentoRepository rendimentoRepository) {
        this.contaRepository = contaRepository;
        this.rendimentoRepository = rendimentoRepository;
    }

    public void adicionarRendimento(Long contaId, Double valor, Integer mes, Integer ano) {
        System.out.println("Buscando conta por ID:" + contaId);
        Conta conta = contaRepository.findById(contaId).orElseThrow(() -> new ContaNaoEncontradaException("Conta não encontrada com ID:" + contaId));


        Rendimento rendimento = new Rendimento();
        rendimento.setValor(valor);
        rendimento.setMes(mes);
        rendimento.setAno(ano);
        rendimento.setConta(conta);

        rendimentoRepository.save(rendimento);


    }
    public List<Rendimento> buscarRendimentosPorMesAno(Integer mes, Integer ano) {
        List<Rendimento> rendimentos = rendimentoRepository.findByMesAndAno(mes, ano);
        System.out.println("Rendimentos encontrados: " + rendimentos.size());
        return rendimentos;
        //return rendimentoRepository.findByMesAndAno(mes, ano);
    }

}
