export class Tarefa {
    #nome
    #dataTermino
    #prioridade
    #estado
    #categoria
    #descricao
    #alarme
    #id

    constructor(nome, descricao, prioridade, estado, categoria, dataTermino, alarme) {
        this.#nome = nome;
        this.#dataTermino = dataTermino;
        this.#prioridade = prioridade;
        this.#estado = estado;
        this.#categoria = categoria;
        this.#descricao = descricao;
        this.#alarme = alarme;
        this.#id = Math.floor(Math.random() * 100000);
    }

    setnome(nome) {
        this.#nome = nome;
    }
    setdataTermino(dataTermino) {
        this.#dataTermino = dataTermino;
    }
    setprioridade(prioridade) {
        this.#prioridade = prioridade;
    }
    setestado(estado) {
        this.#estado = estado;
    }
    setcategoria(categoria) {
        this.#categoria = categoria;
    }
    setdescricao(descricao) {
        this.#descricao = descricao;
    }
    setalarme(alarme) {
        this.#alarme = alarme;
    }


    getNome() {
        return this.#nome;
    }
    getDataTermino() {
        return this.#dataTermino;
    }
    getPrioridade() {
        return this.#prioridade;
    }
    getEstado() {
        return this.#estado;
    }
    getCategoria() {
        return this.#categoria;
    }
    getDescricao() {
        return this.#descricao;
    }
    getAlarme() {
        return this.#alarme;
    }
    getId(){
        return this.#id;
    }


}

export const adicionarFormulario = function (localAAdicionar) {

    localAAdicionar.innerHTML = `<form id="formularioTarefa" class="formularioTarefa">

            <div class="campoTarefa"> 
                <label for="nome">Nome da tarefa</label>
                <input id="nome" name="nome" class="inputFormulario" type="text" required>
            </div>

            <div class="campoTarefa"> 
                <label for="descricao">Descrição da tarefa</label>
                <input id="descricao" class="inputFormulario" name="descricao" type="text">
            </div>

            <div class="campoTarefa"> 
                <label for="dataTermino">Data em que a tarefa termina</label>
                <input id="dataTermino" class="inputFormulario" name="dataTermino" type="date" required>
            </div>

            <div class="campoTarefa"> 
                <label for="prioridade">Prioridade da tarefa</label>
                <select name="prioridade" id="prioridade" required class="inputFormulario">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>
            </div>

            <div class="campoTarefa"> 
                <label for="categoria">Categoria</label>
            <input id="categoria" class="inputFormulario" name="categoria" type="text">
            </div>

            <div class="campoTarefa"> 
                <label for="status">Status inicial da tarefa</label>
            <select name="status" id="status" class="inputFormulario">
                <option value="To Do">To Do</option>
                <option value="Doing">Doing</option>
                <option value="Done">Done</option>
            </select>
            </div>

            <div class="campoTarefa"> 
                <label for="alarme">Alarme para tarefa</label >
            <input id="alarme" class="inputFormulario" name="alarme" type="time">
            </div>

            <div class="separador"> 

            
                <button type="submit" id="enviarDados">
                Enviar dados
            </button>
            <button type="button" id="cancelarFormulario">Cancelar</button>
            </div>
            
            
            </form>
            `;
}


export const htmlTarefa = function (novaTarefa) {

    var nome = novaTarefa.getNome();
    var descricao = novaTarefa.getDescricao();
    var prioridade = novaTarefa.getPrioridade();
    var estado = novaTarefa.getEstado();
    var categoria = novaTarefa.getCategoria();
    var dataTermino = novaTarefa.getDataTermino();
    var alarme = novaTarefa.getAlarme();
    var id = novaTarefa.getId();

    return `
    <div class="tarefa" id="tarefa-${id}">
        
        <div class="informacoesTarefa">

            <div class="informacoesPrimarias">
                <div class="infoPrimaria" id="identificadorNome">
                    <p class="identificador" >Nome</p>
                    <p class="conteudo">${nome}</p>
                </div>
                <div class="infoPrimaria">
                    <p class="identificador">Data de término</p>
                    <p class="conteudo">${dataTermino}</p>
                </div>
                <div class="infoPrimaria">
                    <p class="identificador">Prioridade</p>
                    <p class="conteudo">${prioridade}</p>
                </div>
                <div class="infoPrimaria">
                    <p class="identificador">Estado</p>
                    <p class="conteudo">${estado}</p>
                </div>
                <div class="infoPrimaria">
                    <p class="identificador">Alarme</p>
                    <p class="conteudo">${alarme}</p>
                </div>
                <div class="infoPrimaria">
                    <p class="identificador">Categoria</p>
                    <p class="conteudo">${categoria}</p>
                </div>
            </div>
            <div class="informacoesSecundarias">
                <div class="infoSecundaria">
                    <p class="identificador">Descrição</p>
                    <p class="conteudo">${descricao}</p>
                </div>
            </div>
        </div>
        <div class="opcoesTarefa">
            <button class="excluirTarefa" data-id="${id}">
                <img src="./img/trash.png" alt="" />
            </button>
            <button class="alterarTarefa" data-id="${id}">
                <img src="./img/edit.png" alt="" />
            </button>
        </div>

    </div>
    `;





}


