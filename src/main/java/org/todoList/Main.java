package org.todoList;

import org.todoList.objects.*;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

//        System.out.println(System.getProperty("user.dir"));
//        Som.reproduzirSom("src/main/resources/audio/somAlarme.wav");
//        Alarme Alarme = new Alarme(LocalDate.now(), LocalTime.now().plusSeconds(2), "src/main/resources/audio/somAlarme.wav");

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

        Alarme.pararAlarmes();
    }

}