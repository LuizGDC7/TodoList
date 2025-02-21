package org.todoList.objects;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Som {

    public static void reproduzirSom(String caminhoArquivo) {
        try {
            // Carrega o arquivo de áudio
            File arquivoSom = new File(caminhoArquivo);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(arquivoSom);

            // Obtém um Clip para reprodução
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Reproduz o som
            clip.start();

            // Aguarda o término da reprodução (opcional)
            while (!clip.isRunning()) Thread.sleep(10);
            while (clip.isRunning()) Thread.sleep(10);

            // Fecha o clip
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}