package org.todoList.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Categoria {
    private List<String> categorias = new ArrayList<>(Arrays.asList("Trabalho", "Faculdade", "Tarefas Domésticas", "Planos"));

//    public Categoria(ArrayList<String> categorias) {
//        categorias = new ArrayList<>();
//    }

//    public Categoria() {
//
//    }

    public void addCategoria(String categoria) {
        this.categorias.add(categoria);
    }

    public void removeCategoria(String categoria) {
        this.categorias.remove(categoria);
    }

    public List<String> getCategorias() {
        return this.categorias;
    }

    public void mostrarCategorias() {
        for (String categoria : this.categorias) {
            System.out.println(categoria);
        }
    }

    public boolean categoriaValida(String candidata){
        for (String categoria : this.categorias) {
            if (candidata.equals(categoria)) {
                return true;
            }
        }
        return false;
    }

}
