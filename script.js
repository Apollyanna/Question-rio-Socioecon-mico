const perguntasTextos = {
    pessoal: [
        "Faixa Etaria",
        "Genero",
        "Estado Civil",
        "Pessoas na Casa",
        "Renda Familiar",
        "Responsavel Financeiro",
        "Regiao de Moradia",
        "Plano de Saude",
        "Acesso a Internet",
        "Classe Social"
    ],
    educacional: [
        "Nivel de Escolaridade",
        "Tipo de Escola",
        "Ultima Instituicao",
        "Concluiu Superior",
        "Curso Tecnico",
        "Idiomas Dominados",
        "Certificacoes",
        "Qualidade da Educacao",
        "Pretende Continuar Estudos",
        "Fator Influenciador"
    ],
    profissional: [
        "Situacao no Mercado",
        "Tempo na Ocupacao",
        "Ramo de Atuacao",
        "Nivel Hierarquico",
        "Trabalha na Area",
        "Faixa Salarial",
        "Outro Emprego",
        "Estabilidade",
        "Pretende Mudar Emprego",
        "Fator de Satisfacao"
    ]
};

const paletaAzul = [
    "#0d47a1",
    "#1565c0",
    "#1976d2",
    "#1e88e5",
    "#2196f3",
    "#42a5f5",
    "#64b5f6",
    "#90caf9",
    "#bbdefb",
    "#e3f2fd"
];

document.getElementById("formQuestionario").addEventListener("submit", function(e) {
    e.preventDefault();

    const formData = new FormData(this);
    const dados = {};

    for (let [chave, valor] of formData.entries()) {
        dados[chave] = valor;
    }

    fetch("/api/respostas", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados)
    })
    .then(resposta => {
        if (resposta.ok) {
            document.getElementById("secao-formulario").style.display = "none";
            document.getElementById("secao-graficos").style.display = "block";
            carregarEstatisticas();
            window.scrollTo({ top: 0, behavior: "smooth" });
        } else {
            alert("Erro ao enviar respostas. Tente novamente.");
        }
    })
    .catch(erro => {
        console.error("Erro:", erro);
        alert("Erro de conexao com o servidor.");
    });
});

function voltarFormulario() {
    document.getElementById("secao-formulario").style.display = "block";
    document.getElementById("secao-graficos").style.display = "none";
    document.getElementById("formQuestionario").reset();
    window.scrollTo({ top: 0, behavior: "smooth" });
}

function carregarEstatisticas() {
    fetch("/api/estatisticas")
    .then(resposta => resposta.json())
    .then(dados => {
        renderizarGraficos("pessoal", dados.pessoal);
        renderizarGraficos("educacional", dados.educacional);
        renderizarGraficos("profissional", dados.profissional);
    })
    .catch(erro => {
        console.error("Erro ao carregar estatisticas:", erro);
    });
}

function renderizarGraficos(categoria, dados) {
    const container = document.getElementById("graficos-" + categoria);
    container.innerHTML = "";

    const perguntas = perguntasTextos[categoria];
    let temDados = false;

    for (let i = 1; i <= 10; i++) {
        const chave = "pergunta" + i;
        const contagem = dados[chave] || {};

        const item = document.createElement("div");
        item.className = "grafico-item";

        const titulo = document.createElement("h3");
        titulo.textContent = i + ". " + perguntas[i - 1];
        item.appendChild(titulo);

        const canvas = document.createElement("canvas");
        canvas.id = categoria + "_grafico_" + i;
        item.appendChild(canvas);

        container.appendChild(item);

        const labels = Object.keys(contagem);
        const valores = Object.values(contagem);
        const total = valores.reduce((a, b) => a + b, 0);

        if (total === 0) {
            const aviso = document.createElement("p");
            aviso.style.textAlign = "center";
            aviso.style.color = "#1565c0";
            aviso.style.padding = "20px";
            aviso.textContent = "Sem respostas ainda";
            item.appendChild(aviso);
        } else {
            temDados = true;
            criarGraficoPizza(canvas.id, labels, valores, total);
        }
    }

    if (!temDados) {
        const aviso = document.createElement("div");
        aviso.className = "mensagem vazio";
        aviso.textContent = "Nenhuma resposta registrada ainda nesta categoria.";
        container.appendChild(aviso);
    }
}

function criarGraficoPizza(canvasId, labels, valores, total) {
    const ctx = document.getElementById(canvasId).getContext("2d");

    const porcentagens = valores.map(v => ((v / total) * 100).toFixed(1) + "%");

    new Chart(ctx, {
        type: "pie",
        data: {
            labels: labels.map((l, i) => l + " (" + porcentagens[i] + ")"),
            datasets: [{
                data: valores,
                backgroundColor: paletaAzul,
                borderColor: "#ffffff",
                borderWidth: 2
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: true,
            plugins: {
                legend: {
                    position: "bottom",
                    labels: {
                        color: "#0d47a1",
                        font: { size: 11, weight: "600" },
                        padding: 10,
                        boxWidth: 12
                    }
                },
                tooltip: {
                    callbacks: {
                        label: function(context) {
                            const valor = context.parsed;
                            const perc = ((valor / total) * 100).toFixed(1);
                            return context.label.split(" (")[0] + ": " + valor + " (" + perc + "%)";
                        }
                    },
                    backgroundColor: "#0d47a1",
                    titleColor: "#ffffff",
                    bodyColor: "#ffffff",
                    borderColor: "#1976d2",
                    borderWidth: 1
                }
            }
        }
    });
          }
