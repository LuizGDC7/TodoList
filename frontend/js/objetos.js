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

    localAAdicionar.innerHTML = `<form id="formularioTarefa">

            <label for="nome">Nome da tarefa</label>
            <input id="nome" name="nome"  type="text" required>

            <label for="descricao">Descrição da tarefa</label>
            <input id="descricao" name="descricao" type="text">

            <label for="dataTermino">Data em que a tarefa termina</label>
            <input id="dataTermino" name="dataTermino" type="date" required>

            <label for="prioridade"></label>
            <select name="prioridade" id="prioridade" required>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
            </select>

            <label for="categoria">Categoria</label>
            <input id="categoria" name="categoria" type="text">

            <label for="status"></label>
            <select name="status" id="status">
                <option value="To Do">To Do</option>
                <option value="Doing">Doing</option>
                <option value="Done">Done</option>
            </select>

            <label for="alarme"></label >
            <input id="alarme" name="alarme" type="time">
            
            <button type="submit" id="enviarDados">
                Enviar dados
            </button>
            <button type="button">Cancelar</button>
            </form>
            `
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


