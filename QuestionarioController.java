package com.questionario.controller;

import com.questionario.model.Resposta;
import com.questionario.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class QuestionarioController {

    @Autowired
    private RespostaRepository repository;

    @PostMapping("/respostas")
    public Resposta salvar(@RequestBody Resposta resposta) {
        return repository.save(resposta);
    }

    @GetMapping("/respostas")
    public List<Resposta> listarTodas() {
        return repository.findAll();
    }

    @GetMapping("/estatisticas")
    public Map<String, Object> obterEstatisticas() {
        List<Resposta> respostas = repository.findAll();
        Map<String, Object> resultado = new HashMap<>();

        resultado.put("pessoal", calcularEstatisticas(respostas, "pessoal"));
        resultado.put("educacional", calcularEstatisticas(respostas, "educacional"));
        resultado.put("profissional", calcularEstatisticas(respostas, "profissional"));

        return resultado;
    }

    private Map<String, Map<String, Map<String, Integer>>> calcularEstatisticas(
            List<Resposta> respostas, String categoria) {

        Map<String, Map<String, Map<String, Integer>>> estatisticas = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            Map<String, Integer> contagem = new HashMap<>();
            for (Resposta r : respostas) {
                String valor = obterValor(r, categoria, i);
                if (valor != null && !valor.isEmpty()) {
                    contagem.put(valor, contagem.getOrDefault(valor, 0) + 1);
                }
            }
            estatisticas.put("pergunta" + i, contagem);
        }

        return estatisticas;
    }

    private String obterValor(Resposta r, String categoria, int numero) {
        String chave = "pergunta" + categoria.substring(0, 1).toUpperCase()
                + categoria.substring(1) + numero;

        switch (chave) {
            case "perguntaPessoal1": return r.getPerguntaPessoal1();
            case "perguntaPessoal2": return r.getPerguntaPessoal2();
            case "perguntaPessoal3": return r.getPerguntaPessoal3();
            case "perguntaPessoal4": return r.getPerguntaPessoal4();
            case "perguntaPessoal5": return r.getPerguntaPessoal5();
            case "perguntaPessoal6": return r.getPerguntaPessoal6();
            case "perguntaPessoal7": return r.getPerguntaPessoal7();
            case "perguntaPessoal8": return r.getPerguntaPessoal8();
            case "perguntaPessoal9": return r.getPerguntaPessoal9();
            case "perguntaPessoal10": return r.getPerguntaPessoal10();
            case "perguntaEducacional1": return r.getPerguntaEducacional1();
            case "perguntaEducacional2": return r.getPerguntaEducacional2();
            case "perguntaEducacional3": return r.getPerguntaEducacional3();
            case "perguntaEducacional4": return r.getPerguntaEducacional4();
            case "perguntaEducacional5": return r.getPerguntaEducacional5();
            case "perguntaEducacional6": return r.getPerguntaEducacional6();
            case "perguntaEducacional7": return r.getPerguntaEducacional7();
            case "perguntaEducacional8": return r.getPerguntaEducacional8();
            case "perguntaEducacional9": return r.getPerguntaEducacional9();
            case "perguntaEducacional10": return r.getPerguntaEducacional10();
            case "perguntaProfissional1": return r.getPerguntaProfissional1();
            case "perguntaProfissional2": return r.getPerguntaProfissional2();
            case "perguntaProfissional3": return r.getPerguntaProfissional3();
            case "perguntaProfissional4": return r.getPerguntaProfissional4();
            case "perguntaProfissional5": return r.getPerguntaProfissional5();
            case "perguntaProfissional6": return r.getPerguntaProfissional6();
            case "perguntaProfissional7": return r.getPerguntaProfissional7();
            case "perguntaProfissional8": return r.getPerguntaProfissional8();
            case "perguntaProfissional9": return r.getPerguntaProfissional9();
            case "perguntaProfissional10": return r.getPerguntaProfissional10();
            default: return null;
        }
    }
        }
