package com.questionario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pergunta_pessoal_1")
    private String perguntaPessoal1;

    @Column(name = "pergunta_pessoal_2")
    private String perguntaPessoal2;

    @Column(name = "pergunta_pessoal_3")
    private String perguntaPessoal3;

    @Column(name = "pergunta_pessoal_4")
    private String perguntaPessoal4;

    @Column(name = "pergunta_pessoal_5")
    private String perguntaPessoal5;

    @Column(name = "pergunta_pessoal_6")
    private String perguntaPessoal6;

    @Column(name = "pergunta_pessoal_7")
    private String perguntaPessoal7;

    @Column(name = "pergunta_pessoal_8")
    private String perguntaPessoal8;

    @Column(name = "pergunta_pessoal_9")
    private String perguntaPessoal9;

    @Column(name = "pergunta_pessoal_10")
    private String perguntaPessoal10;

    @Column(name = "pergunta_educacional_1")
    private String perguntaEducacional1;

    @Column(name = "pergunta_educacional_2")
    private String perguntaEducacional2;

    @Column(name = "pergunta_educacional_3")
    private String perguntaEducacional3;

    @Column(name = "pergunta_educacional_4")
    private String perguntaEducacional4;

    @Column(name = "pergunta_educacional_5")
    private String perguntaEducacional5;

    @Column(name = "pergunta_educacional_6")
    private String perguntaEducacional6;

    @Column(name = "pergunta_educacional_7")
    private String perguntaEducacional7;

    @Column(name = "pergunta_educacional_8")
    private String perguntaEducacional8;

    @Column(name = "pergunta_educacional_9")
    private String perguntaEducacional9;

    @Column(name = "pergunta_educacional_10")
    private String perguntaEducacional10;

    @Column(name = "pergunta_profissional_1")
    private String perguntaProfissional1;

    @Column(name = "pergunta_profissional_2")
    private String perguntaProfissional2;

    @Column(name = "pergunta_profissional_3")
    private String perguntaProfissional3;

    @Column(name = "pergunta_profissional_4")
    private String perguntaProfissional4;

    @Column(name = "pergunta_profissional_5")
    private String perguntaProfissional5;

    @Column(name = "pergunta_profissional_6")
    private String perguntaProfissional6;

    @Column(name = "pergunta_profissional_7")
    private String perguntaProfissional7;

    @Column(name = "pergunta_profissional_8")
    private String perguntaProfissional8;

    @Column(name = "pergunta_profissional_9")
    private String perguntaProfissional9;

    @Column(name = "pergunta_profissional_10")
    private String perguntaProfissional10;

    @Column(name = "data_resposta")
    private LocalDateTime dataResposta;

    @PrePersist
    protected void onCreate() {
        dataResposta = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPerguntaPessoal1() { return perguntaPessoal1; }
    public void setPerguntaPessoal1(String v) { this.perguntaPessoal1 = v; }
    public String getPerguntaPessoal2() { return perguntaPessoal2; }
    public void setPerguntaPessoal2(String v) { this.perguntaPessoal2 = v; }
    public String getPerguntaPessoal3() { return perguntaPessoal3; }
    public void setPerguntaPessoal3(String v) { this.perguntaPessoal3 = v; }
    public String getPerguntaPessoal4() { return perguntaPessoal4; }
    public void setPerguntaPessoal4(String v) { this.perguntaPessoal4 = v; }
    public String getPerguntaPessoal5() { return perguntaPessoal5; }
    public void setPerguntaPessoal5(String v) { this.perguntaPessoal5 = v; }
    public String getPerguntaPessoal6() { return perguntaPessoal6; }
    public void setPerguntaPessoal6(String v) { this.perguntaPessoal6 = v; }
    public String getPerguntaPessoal7() { return perguntaPessoal7; }
    public void setPerguntaPessoal7(String v) { this.perguntaPessoal7 = v; }
    public String getPerguntaPessoal8() { return perguntaPessoal8; }
    public void setPerguntaPessoal8(String v) { this.perguntaPessoal8 = v; }
    public String getPerguntaPessoal9() { return perguntaPessoal9; }
    public void setPerguntaPessoal9(String v) { this.perguntaPessoal9 = v; }
    public String getPerguntaPessoal10() { return perguntaPessoal10; }
    public void setPerguntaPessoal10(String v) { this.perguntaPessoal10 = v; }

    public String getPerguntaEducacional1() { return perguntaEducacional1; }
    public void setPerguntaEducacional1(String v) { this.perguntaEducacional1 = v; }
    public String getPerguntaEducacional2() { return perguntaEducacional2; }
    public void setPerguntaEducacional2(String v) { this.perguntaEducacional2 = v; }
    public String getPerguntaEducacional3() { return perguntaEducacional3; }
    public void setPerguntaEducacional3(String v) { this.perguntaEducacional3 = v; }
    public String getPerguntaEducacional4() { return perguntaEducacional4; }
    public void setPerguntaEducacional4(String v) { this.perguntaEducacional4 = v; }
    public String getPerguntaEducacional5() { return perguntaEducacional5; }
    public void setPerguntaEducacional5(String v) { this.perguntaEducacional5 = v; }
    public String getPerguntaEducacional6() { return perguntaEducacional6; }
    public void setPerguntaEducacional6(String v) { this.perguntaEducacional6 = v; }
    public String getPerguntaEducacional7() { return perguntaEducacional7; }
    public void setPerguntaEducacional7(String v) { this.perguntaEducacional7 = v; }
    public String getPerguntaEducacional8() { return perguntaEducacional8; }
    public void setPerguntaEducacional8(String v) { this.perguntaEducacional8 = v; }
    public String getPerguntaEducacional9() { return perguntaEducacional9; }
    public void setPerguntaEducacional9(String v) { this.perguntaEducacional9 = v; }
    public String getPerguntaEducacional10() { return perguntaEducacional10; }
    public void setPerguntaEducacional10(String v) { this.perguntaEducacional10 = v; }

    public String getPerguntaProfissional1() { return perguntaProfissional1; }
    public void setPerguntaProfissional1(String v) { this.perguntaProfissional1 = v; }
    public String getPerguntaProfissional2() { return perguntaProfissional2; }
    public void setPerguntaProfissional2(String v) { this.perguntaProfissional2 = v; }
    public String getPerguntaProfissional3() { return perguntaProfissional3; }
    public void setPerguntaProfissional3(String v) { this.perguntaProfissional3 = v; }
    public String getPerguntaProfissional4() { return perguntaProfissional4; }
    public void setPerguntaProfissional4(String v) { this.perguntaProfissional4 = v; }
    public String getPerguntaProfissional5() { return perguntaProfissional5; }
    public void setPerguntaProfissional5(String v) { this.perguntaProfissional5 = v; }
    public String getPerguntaProfissional6() { return perguntaProfissional6; }
    public void setPerguntaProfissional6(String v) { this.perguntaProfissional6 = v; }
    public String getPerguntaProfissional7() { return perguntaProfissional7; }
    public void setPerguntaProfissional7(String v) { this.perguntaProfissional7 = v; }
    public String getPerguntaProfissional8() { return perguntaProfissional8; }
    public void setPerguntaProfissional8(String v) { this.perguntaProfissional8 = v; }
    public String getPerguntaProfissional9() { return perguntaProfissional9; }
    public void setPerguntaProfissional9(String v) { this.perguntaProfissional9 = v; }
    public String getPerguntaProfissional10() { return perguntaProfissional10; }
    public void setPerguntaProfissional10(String v) { this.perguntaProfissional10 = v; }

    public LocalDateTime getDataResposta() { return dataResposta; }
          }
