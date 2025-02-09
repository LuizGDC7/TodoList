package org.todoList.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Menu {

    private static Scanner input;

    public Menu() {
        input = new Scanner(System.in);
    }

    public void boasVindas(){
        System.out.println("Olá, seja bem vindo ao ToDo List!!!");
    }

    public int opcoes(){


        System.out.println(
                "\n"+
                "1 - Adicionar nova tarefa\n" +
                "2 - Deletar tarefa\n" +
                "3 - Vizualizar tarefas\n" +
                "4 - Vizualizar categorias\n" +
                "5 - Adicionar categoria\n" +
                "6 - Ordenar por prioridade\n" +
                "7 - Listar tarefas por Categoria\n" +
                "8 - Listar tarefas por Prioridade\n" +
                "9 - Listar tarefas por Status\n" +
                "10 - Sair\n"
        );

        int escolha = 0;

        while(true){
            try {
                escolha = Integer.parseInt(input.nextLine());
                if(escolha <= 0 || escolha > 10){
                    throw new java.lang.RuntimeException("\nErro\n");
                }
                break;
            }catch(Exception e){
                System.out.println("\nPor favor, escolha um número entre 1 e 9\n");
            }
        }

        return escolha;
    }

    public int opcoesTarefa(){

        System.out.println(
               "\n" +
               "1 - Inserir nome da tarefa\n" +
               "2 - Inserir Descrição da tarefa\n"+
               "3 - Inserir data de término da tarefa\n" +
               "4 - Inserir nível de prioridade da tarefa\n" +
               "5 - Inserir categoria da tarefa\n" +
               "6 - Cancelar"
        );
        int escolha = 0;

        while(true){
            try{
                escolha = Integer.parseInt(input.nextLine());
                if(escolha <= 0 || escolha > 7){
                    throw new java.lang.RuntimeException("\nErro\n");
                }
                break;
            }catch(Exception e){
                System.out.println("\nPor favor, insira uma opção entre 1 e 6\n");
            }
        }
        return escolha;
    }

    public String obterStringTarefa(String mensagem){

        System.out.println(mensagem);
        String nome;
        while(true){
            try{
                nome = input.nextLine();
                break;
            }catch(Exception e){
                System.out.println("\nPor favor, insira caracteres válidos\n");
            }
        }
        return nome;
    }

    public Date obterDataTarefa(){

        SimpleDateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data;
        while(true){
            try {
                System.out.println("Digite a data de fim da tarefa no formato DD/MM/yyyy:\n");
                String leitura = input.nextLine();
                data = dataFormat.parse(leitura);
                break;
            }catch (Exception e){
                System.out.println("\nInsira data no formato adequado\n");
            }
        }
        return data;
    }

    public int obterIntTarefa(String mensagem){

        int saida;
        while(true){
            try {
                System.out.println(mensagem);
                saida = Integer.parseInt(input.nextLine());
                if (saida >= 1 && saida <= 5) {
                    break;
                }
                System.out.println("\nPor favor, insira um número entre 1 e 5\n");
            }catch (Exception e){
                System.out.println("Insira um número adequado");
            }
        }
        return saida;
    }

    public String obterCategoriaTarefa(Categoria categoria){

        categoria.mostrarCategorias();

        while(true){
            try {
                String leitura = input.nextLine();
                for(String categorias : categoria.getCategorias()){
                    if (leitura.equalsIgnoreCase(categorias)) {
                        return categorias;
                    }
                }
                throw new java.lang.RuntimeException("\nErro\n");
            }catch (Exception e){
                System.out.println("\nEscolha uma categoria adequada\n");
            }
        }
    }

    public Tarefa criarTarefa(Categoria categorias){
        String nome = null, descricao = null, categoriaEscolhida = null;
        Date data = null;
        Integer prioridade = null;

        while(true){

            System.out.println("Dados inseridos até agora: \n\n" +
                    "nome: " + (nome == null ? "" : nome) + "\n" +
                    "descricao: " + (descricao == null ? "" : descricao) + "\n" +
                    "categoria:" + (categoriaEscolhida == null ? "" : categoriaEscolhida) + "\n" +
                    "prioridade: " + (prioridade == null ? "" : prioridade) + "\n" +
                    "Data: " + (data == null ? "" : data) + "\n"
                    );

            switch(opcoesTarefa()){
                case 1: nome = obterStringTarefa("Insira nome da tarefa");
                    break;
                case 2: descricao = obterStringTarefa("Insira descrição da tarefa");
                    break;
                case 3: data = obterDataTarefa();
                    break;
                case 4: prioridade = obterIntTarefa("Insira a prioridade da tarefa (Número 1 até 5)");
                    break;
                case 5: categoriaEscolhida = obterCategoriaTarefa(categorias);
                    break;
                case 6: return null;
            }

            if(nome != null && descricao != null && data != null && prioridade != null && categoriaEscolhida != null){
                break;
            }

        }

        return new Tarefa(nome, descricao, data, prioridade, categoriaEscolhida, new Status(Status.TODO));
    }

    public void mostrarTarefas(ArrayList<Tarefa> tarefa){
        for(int i = 0; i < tarefa.size(); i++){
            System.out.println(tarefa.get(i));
        }
    }

    public void deletarTarefa(ArrayList<Tarefa> tarefas){
        System.out.println("Escolha um número de tarefa a ser deletado, escolha qualquer outro para cancelar:\n");
        int escolha;
        for(int c = 0; c < tarefas.size(); c++){
            System.out.println(String.format("[%d] - ", c) + tarefas.get(c).getNome());
        }
        while(true){
            try{
                escolha = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e){
                System.out.println("\nDigite um número inteiro adequado\n");
            }
        }

        if(escolha >= 0 && escolha < tarefas.size()){
            tarefas.remove(escolha);
        }
    }

    public void criarCategoria(Categoria categoria){
        System.out.println("Essas são as atuais categorias:\n");
        categoria.mostrarCategorias();
        String novaCategoria = null;
        System.out.println("Insira uma nova categoria, digite ESC para cancelar:\n");
        try{
            novaCategoria = input.nextLine();
        }catch (Exception e){
            System.out.println("\nFalha na inserção de categoria\n");
        }
        if(novaCategoria != null && !novaCategoria.equals("ESC")){
            categoria.addCategoria(novaCategoria);
        }
    }

    public void executarOpcao(int opcao, Menu menu, ArrayList<Tarefa> tarefas, Categoria categoria){
        switch (opcao) {
            case 1: {
                Tarefa novatarefa = menu.criarTarefa(categoria);
                if (novatarefa != null) {
                    tarefas.add(novatarefa);
                }
            }
                break;
            case 2: deletarTarefa(tarefas);
                break;
            case 3: mostrarTarefas(tarefas);
                break;
            case 4: categoria.mostrarCategorias();
                break;
            case 5: criarCategoria(categoria);
                break;
            case 6:
                Collections.sort(tarefas);
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                break;


        }
    }

}
