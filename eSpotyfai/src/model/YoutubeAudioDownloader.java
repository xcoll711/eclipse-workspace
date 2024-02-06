

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.sound.sampled.*;


public class YoutubeAudioDownloader {

    public static void main(String[] args) {
        // Especifica la URL del video de YouTube
        String videoUrl = "https://www.youtube.com/watch?v=Fsc3eCv3Rts";

        // Especifica el formato de salida (en este caso, wav)
        String outputFormat = "wav";

        // Establece el destino del archivo
        String destinationFolder = "src/view/songs";

        try {
            // Construye el comando para descargar el audio en formato WAV
        	String command = "src/res/yt-dlp.exe -f bestaudio --extract-audio --audio-format wav --output " + destinationFolder + "/%(title)s.wav/ " + videoUrl;
            System.out.println("/%(title)s.%\"wav " );
        	
        	// Ejecuta el comando en un proceso
            Process process = Runtime.getRuntime().exec(command);

            // Lee la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Espera a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);

            // Pregunta al usuario si quiere reproducir la canción
            System.out.println("¿Deseas reproducir la canción recién descargada? (S/N)");

            BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = userInputReader.readLine().trim();

            // Si la respuesta es Sí, reproduce la canción
            if (userInput.equalsIgnoreCase("S")) {
                String songFilePath = destinationFolder + "/01.wav"; // Reemplaza con el nombre real de la canción
                
                System.out.println(songFilePath);
                playSong(songFilePath);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

 // Método para reproducir la canción
 // Método para reproducir la canción
    private static void playSong(String filePath) {
        try {
            // Obtener un Clip de audio
            Clip clip = AudioSystem.getClip();

            // Abrir el archivo de audio
            File audioFile = new File(filePath);
            if (!audioFile.exists()) {
                System.err.println("El archivo de audio no existe en la ruta especificada: " + filePath);
                return;
            }
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioInputStream);

            // Reproducir el audio
            clip.start();

            // Esperar hasta que el clip termine de reproducirse
            Thread.sleep(clip.getMicrosecondLength() / 1000);

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}