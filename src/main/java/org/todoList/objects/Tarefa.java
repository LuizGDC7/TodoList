package org.todoList.objects;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tarefa implements Comparable<Tarefa> {
    private String nome;
    private String descricao;
    private Date dataTermino;
    private int prioridade;
    private String categoria;
    private Status status;

    public Tarefa(String nome, String descricao, Date dataTermino, int prioridade, String categoria, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
        this.prioridade = prioridade;
        this.categoria = categoria;
        this.status = status;
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

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
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

    @Override
    public int compareTo(Tarefa outraTarefa){
        return Integer.compare(this.prioridade, outraTarefa.prioridade);
    }

    @Override
    public String toString() {
         return "\nNome: " + getNome() +
                "\nDescrição: " + getDescricao() +
                "\nData final: " + getDataTermino() +
                "\nPrioridade: " + getPrioridade() +
                "\nCategoria: " + getCategoria() +
                "\nStatus: " + getStatus().getStatusWithColor() +
                "\n";

    }



}
