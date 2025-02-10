package org.todoList;

import org.todoList.objects.Categoria;
import org.todoList.objects.Menu;
import org.todoList.objects.Status;
import org.todoList.objects.Tarefa;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Categoria categoria = new Categoria();
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
        while (true) {
            int escolha = menu.opcoes();
            if (escolha == 0) {
                break;
            }
            menu.executarOpcao(escolha, menu, tarefas, categoria);
        }
    }
}