package org.todoList.objects;

import org.todoList.interfaces.Propertie;

import java.util.HashMap;

public class Status implements Comparable<Status>, Propertie<String> {
    public static final String TODO = "To do";
    public static final String DOING = "Doing";
    public static final String DONE = "Done";

    private String statusTarefa;

    public Status(String status) {
        this.statusTarefa = "Not set";
        String[] flavors = {TODO, DOING, DONE};
        for (String flavor : flavors) {
            if (flavor.equalsIgnoreCase(status)) {
                this.statusTarefa = flavor;
            }
        }
    }

    public String getTodo(){
        return TextColor.ANSI_RED + TODO + TextColor.ANSI_RESET;
    }

    public String getDoing(){
        return TextColor.ANSI_YELLOW + DOING + TextColor.ANSI_RESET;
    }

    public String getDone(){
        return TextColor.ANSI_GREEN + DONE + TextColor.ANSI_RESET;
    }

    public Status(){

    }

    public String getStatusWithColor(){
        return switch (this.statusTarefa) {
            case TODO -> getTodo();
            case DOING -> getDoing();
            case DONE -> getDone();
            default -> "Error";
        };
    }

    public String getStatusTarefa() {
        return this.statusTarefa;
    }

    @Override
    public int compareTo(Status otherStatus){
        HashMap<String, Integer> map = new HashMap<>();
        map.put(TODO, 2);
        map.put(DOING, 1);
        map.put(DONE, 0);

        int myStatusNumber = map.get(this.statusTarefa);
        int otherStatusNumber = map.get(otherStatus.getStatusTarefa());

        return Integer.compare(myStatusNumber, otherStatusNumber);
    }

    @Override
    public boolean validarPropriedade(String objeto){
        String[] valores = {TODO, DOING, DONE};
        for (String valor : valores) {
            if (valor.equalsIgnoreCase(objeto)) {
                return true;
            }
        }
        return false;
    }

    public void setStatus(String novoStatus){
        String[] estados = {TODO, DOING, DONE};
        for (String estado : estados) {
            if (estado.equalsIgnoreCase(novoStatus)) {
                this.statusTarefa = estado;
            }
        }
    }

}
