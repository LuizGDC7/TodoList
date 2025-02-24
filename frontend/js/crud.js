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
                let novoHtmlTarefa = objetos.htmlTarefa(tarefa);
                
                main.innerHTML += novoHtmlTarefa;
            }
        );

        document.querySelectorAll('.excluirTarefa').forEach(
            (botao) => {
                botao.addEventListener('click', () => {
                    const id = parseInt(botao.getAttribute('data-id'));
                    excluirTarefa(id);
                });
            }
        );

        document.querySelectorAll('.alterarTarefa').forEach((botao) => {
            botao.addEventListener('click', () => {
                const id = parseInt(botao.getAttribute('data-id'));
                alterarTarefa(id);
            });
        });
    }
}

function adicionarTarefas(novaTarefa) {
    tarefas.push(novaTarefa);
    console.log(tarefas);
    atualizarMain();
}

function excluirTarefa(id){
    tarefas = tarefas.filter((tarefa) => tarefa.getId() !== id);
    atualizarMain();
}

function alterarTarefa(id){
    const tarefa = tarefas.find((tarefa) => tarefa.getId() === id);
    if(tarefa){
        mostrarFormulario(tarefa);
    }
}

function mostrarFormulario(tarefa = null) {
    main.innerHTML = "";
    objetos.adicionarFormulario(main);
    const formulario = document.getElementById('formularioTarefa');

    if (formulario) {

        if (tarefa) {
            formulario.querySelector('#nome').value = tarefa.getNome();
            formulario.querySelector('#descricao').value = tarefa.getDescricao();
            formulario.querySelector('#dataTermino').value = tarefa.getDataTermino();
            formulario.querySelector('#alarme').value = tarefa.getAlarme();
            formulario.querySelector('#categoria').value = tarefa.getCategoria();
            formulario.querySelector('#status').value = tarefa.getEstado();
            formulario.querySelector('#prioridade').value = tarefa.getPrioridade();
        }



        formulario.addEventListener("submit", function (event) {

            event.preventDefault();

            const dados = new FormData(formulario);

            const nome = dados.get('nome');
            const descricao = dados.get('descricao');
            const dataTermino = dados.get('dataTermino');
            const alarme = dados.get('alarme');
            const categoria = dados.get('categoria');
            const estado = dados.get('status');
            const prioridade = dados.get('prioridade');

            if(tarefa){

                tarefa.setnome(nome);
                tarefa.setdescricao(descricao);
                tarefa.setdataTermino(dataTermino);
                tarefa.setalarme(alarme);
                tarefa.setcategoria(categoria);
                tarefa.setestado(estado);
                tarefa.setprioridade(prioridade);

            }else{
                const novaTarefa = new objetos.Tarefa(nome, descricao, prioridade, estado, categoria, dataTermino, alarme);
                adicionarTarefas(novaTarefa);
            }

            atualizarMain();
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