var tarefas = []

class Tarefa{
    #nome
    #dataTermino
    #prioridade
    #estado
    #categoria
    #descricao
    #alarme

    constructor(nome, descricao, prioridade, estado, categoria, dataTermino, alarme){
        this.#nome = nome;
        this.#dataTermino = dataTermino;
        this.#prioridade = prioridade;
        this.#estado = estado;
        this.#categoria = categoria;
        this.#descricao = descricao;
        this.#alarme = alarme;
    }

    setnome(nome){
        this.#nome = nome;
    }
    setdataTermino(dataTermino){
        this.#dataTermino = dataTermino;
    }
    setprioridade(prioridade){
        this.#prioridade = prioridade;
    }
    setestado(estado){
        this.#estado = estado;
    }
    setcategoria(categoria){
        this.#categoria = categoria;
    }
    setdescricao(descricao){
        this.#descricao = descricao;
    }
    setalarme(alarme){
        this.#alarme = alarme;
    }
    

    getNome(){
        return this.#nome;
    }
    getDataTermino(){
        return this.#dataTermino;
    }
    getPrioridade(){
        return this.#prioridade;
    }
    getEstado(){
        return this.#estado;
    }
    getCategoria(){
        return this.#categoria;
    }
    getDescricao(){
        return this.#descricao;
    }
    getAlarme(){
        return this.#alarme;
    }

}

const formulario = document.getElementById('formularioTarefa')

function adicionarTarefas(novaTarefa){
    tarefas.push(novaTarefa);
    console.log(tarefas);
}

formulario.addEventListener("submit", function(event){
    
    event.preventDefault();

    const dados = new FormData(formulario);

    var nome =          dados.get('nome');
    var descricao =     dados.get('descricao');
    var dataTermino =   dados.get('dataTermino');
    var alarme =        dados.get('alarme');
    var categoria =     dados.get('categoria');
    var estado =        dados.get('status');
    var prioridade =    dados.get('prioridade');

    var novaTarefa = new Tarefa(nome, descricao, prioridade, estado, categoria, dataTermino, alarme);

    adicionarTarefas(novaTarefa);

})



