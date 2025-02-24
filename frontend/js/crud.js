import * as objetos from "./objetos.js";

let tarefas = [new objetos.Tarefa("Anotar dados", "Preciso anotar dados até segunda", 3, "To Do", "Afazeres", "2025-02-26", "08:30"),
    new objetos.Tarefa("Passear com os cachorros", "Passear com os cachorros", 2, "Doing", "Lazer", "2025-02-28", "07:30")
]

const adicionar = document.getElementById('adicionar');

const main = document.getElementById("main");


function atualizarMain(){

    main.innerHTML = "";

    if(tarefas.length > 0){
        tarefas.forEach(
            (tarefa) => {
                main.innerHTML += objetos.htmlTarefa(tarefa)
            }
        )
    }
}

function adicionarTarefas(novaTarefa) {
    tarefas.push(novaTarefa);
    console.log(tarefas);
    atualizarMain();
}

function mostrarFormulario() {
    main.innerHTML = "";
    objetos.adicionarFormulario(main);
    const formulario = document.getElementById('formularioTarefa');

    if (formulario) {

        formulario.addEventListener("submit", function (event) {

            event.preventDefault();

            const dados = new FormData(formulario);

            var nome = dados.get('nome');
            var descricao = dados.get('descricao');
            var dataTermino = dados.get('dataTermino');
            var alarme = dados.get('alarme');
            var categoria = dados.get('categoria');
            var estado = dados.get('status');
            var prioridade = dados.get('prioridade');

            var novaTarefa = new objetos.Tarefa(nome, descricao, prioridade, estado, categoria, dataTermino, alarme);

            adicionarTarefas(novaTarefa);

        })

        const botaoCancelar = formulario.querySelector('button[type="button"]');
        if (botaoCancelar) {
            botaoCancelar.addEventListener("click", function () {
                atualizarMain(); // Limpa o formulário ao cancelar
            });
        }

    }


}

adicionar.addEventListener("click", mostrarFormulario);

atualizarMain();