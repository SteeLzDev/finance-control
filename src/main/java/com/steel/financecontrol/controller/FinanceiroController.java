package com.steel.financecontrol.controller;


import com.steel.financecontrol.application.service.FinanceiroService;
import com.steel.financecontrol.model.Rendimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/financeiro")
public class FinanceiroController {


    private final FinanceiroService financeiroService;

    @Autowired
    public FinanceiroController(FinanceiroService financeiroService) {
        this.financeiroService = financeiroService;
    }

    @RequestMapping("/rendimento")
    public ResponseEntity<Void> adicionarRendimento (@RequestParam Long contaId, @RequestParam Double valor, @RequestParam Integer mes, @RequestParam Integer ano) {
        financeiroService.adicionarRendimento(contaId, valor, mes, ano);
        return ResponseEntity.status(201).build();

    }

    @RequestMapping ("/rendimentos")
    public ResponseEntity<List<Rendimento>> buscarRendimentosPorMesAno (@RequestParam Integer mes, @RequestParam Integer ano) {
        List<Rendimento> rendimentos = financeiroService.buscarRendimentosPorMesAno(mes, ano);
        return ResponseEntity.ok(rendimentos);
    }


    @GetMapping("/api/test") // http://localhost:8080/financeiro/api/test
            public ResponseEntity<String> test() {
        return ResponseEntity.ok("Teste de integração bem-sucedido!");
    }





}
