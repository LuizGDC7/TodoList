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
        ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>(
                Arrays.asList(
                        new Tarefa("Limpar a casa", "Preciso limpar toda a casa", new Date(2025, 1, 20), 2, "Trabalho", new Status(Status.TODO)),
                        new Tarefa("Arruamar a cozinha", "Preciso arrumar a cozinha", new Date(2024, 2, 18), 3, "Tarefas Domésticas", new Status(Status.DOING)),
                        new Tarefa("Zerar Durkest Dungeon", "Vou zerar o jogo", new Date(2025, 3, 20), 2, "Lazer", new Status(Status.DONE))
                )
        );
        while (true) {
            int escolha = menu.opcoes();
            if (escolha == 0) {
                break;
            }
            menu.executarOpcao(escolha, menu, tarefas, categoria);
        }
    }
}