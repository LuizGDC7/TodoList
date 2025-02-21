package org.todoList.objects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tarefa implements Comparable<Tarefa> {
    private String nome;
    private String descricao;
    private LocalDate dataTermino;
    private LocalTime horarioAlarme;
    private int prioridade;
    private String categoria;
    private Status status;
    private Alarme alarme;

    public Tarefa(String nome, String descricao, LocalDate dataTermino, int prioridade, String categoria, Status status, LocalTime horarioAlarme) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
        this.horarioAlarme = horarioAlarme;
        if(horarioAlarme != null){
            alarme = new Alarme(dataTermino, horarioAlarme, "src/main/resources/audio/somAlarme.wav", nome);
        }

    }

    public Tarefa(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalTime getHorarioAlarme() {
        return horarioAlarme;
    }

    public void setHorarioAlarme(LocalTime horarioAlarme) {
        this.horarioAlarme = horarioAlarme;
    }

    @Override
    public int compareTo(Tarefa outraTarefa){
        return Integer.compare(this.prioridade, outraTarefa.prioridade);
    }

    @Override
    public String toString() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

         return "\nNome: " + getNome() +
                "\nDescrição: " + getDescricao() +
                "\nData final: " + getDataTermino().toString() +
                "\nPrioridade: " + getPrioridade() +
                "\nCategoria: " + getCategoria() +
                "\nStatus: " + getStatus().getStatusWithColor() +
                "\n";
    }



}
