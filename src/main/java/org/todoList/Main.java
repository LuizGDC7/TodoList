package org.todoList;

import org.todoList.objects.Categoria;
import org.todoList.objects.Menu;
import org.todoList.objects.Tarefa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Categoria categoria = new Categoria();
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        while (true) {
            int escolha = menu.opcoes();
            if (escolha == 10) {
                break;
            }
            menu.executarOpcao(escolha, menu, tarefas, categoria);
        }
    }
}