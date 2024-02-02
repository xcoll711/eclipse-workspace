package model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YoutubeAudioDownloader {

    public static void main(String[] args) {
        // Especifica la URL del video de YouTube
        String videoUrl = "https://www.youtube.com/watch?v=Fsc3eCv3Rts";

        // Especifica el formato de salida (en este caso, wav)
        String outputFormat = "wav";

        try {
            // Construye el comando para descargar el audio en formato WAV
            String[] command = {"src/res/yt-dlp.exe", "-f", "--audio-format", outputFormat, videoUrl};
            String c = "src/res/yt-dlp.exe -f bestaudio --extract-audio --audio-format wav --output eSpotyfai "+videoUrl ;

            // Ejecuta el comando en un proceso
            Process process = Runtime.getRuntime().exec(c);

            // Lee la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Espera a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso terminado con código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
