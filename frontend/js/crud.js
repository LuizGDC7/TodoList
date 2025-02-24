var tarefas = []

const adicionar = document.getElementById('adicionar');


const main = document.getElementById("main");

function adicionarTarefas(novaTarefa) {
    tarefas.push(novaTarefa);
    console.log(tarefas);
}


adicionar.onclick = function mostrarFormulario() {
    main.innerHTML = "";
    adicionarFormulario(main);
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

            var novaTarefa = new Tarefa(nome, descricao, prioridade, estado, categoria, dataTermino, alarme);

            adicionarTarefas(novaTarefa);
            main.innerHTML = "";

        })

        formulario.addEventListener("cancelarNovaTarefa", function (event) {
            event.preventDefault();
            main.innerHTML = "";
        });

        const botaoCancelar = formulario.querySelector('button[type="button"]');
        if (botaoCancelar) {
            botaoCancelar.addEventListener("click", function () {
                main.innerHTML = ""; // Limpa o formulário ao cancelar
            });
        }

    }


}