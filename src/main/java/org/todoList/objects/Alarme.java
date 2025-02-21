package org.todoList.objects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Alarme {
    private LocalDateTime alarme;
    private Thread threadAlarme;
    private volatile boolean executando;
    private static ArrayList<Alarme> alarmes = new ArrayList<>();
    private String caminhoArquivoDeSom;
    private String aviso;

    public Alarme(LocalDate data, LocalTime horario, String caminhoArquivoDeSom, String aviso) {
        this.alarme = LocalDateTime.of(data, horario);
        this.executando = true;
        this.caminhoArquivoDeSom = caminhoArquivoDeSom;
        iniciarAlarme();
        alarmes.add(this);
        this.aviso = aviso;
    }

    private void iniciarAlarme() {
        threadAlarme = new Thread(() -> {
            while (executando) {
                if (gatilhoAlarme()) {
                    System.out.println("Tarefa " + aviso + " precisa ser feita!");
                    Som.reproduzirSom(caminhoArquivoDeSom);
                    executando = false; // Encerra a thread após o alarme disparar
                } else {
//                    System.out.println("Aguardando alarme...");
                    try {
                        Thread.sleep(1000); // Verifica a cada segundo
                    } catch (InterruptedException e) {
//                        System.out.println("Thread do alarme interrompida!");
                        executando = false; // Encerra a thread se for interrompida
                    }
                }
            }
//            System.out.println("Thread do alarme finalizada.");
        });
        threadAlarme.start();
    }

    public boolean gatilhoAlarme() {
        return LocalDateTime.now().isAfter(alarme);
    }

    public void pararAlarme() {
        executando = false;
        if (threadAlarme != null) {
            threadAlarme.interrupt(); // Interrompe a thread se estiver dormindo
        }
    }

    public static void pararAlarmes(){
        for(Alarme alarme: alarmes){
            alarme.pararAlarme();
        }
    }

}