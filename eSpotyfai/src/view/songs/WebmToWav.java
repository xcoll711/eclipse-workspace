package view.songs;

import javax.sound.sampled.*;

import java.io.File;
import java.io.IOException;

public class WebmToWav {

    public static void main(String[] args) {
        String inputFile = "src/view/songs/11.webm";
        String outputFile = "src/view/songs/11.wav";

        convertWebMToWav(inputFile, outputFile);
    }

    public static void convertWebMToWav(String inputPath, String outputPath) {
        try {
            File webmFile = new File(inputPath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(webmFile);
            AudioFormat sourceFormat = audioInputStream.getFormat();
            AudioFormat targetFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    sourceFormat.getSampleRate(),
                    16,
                    sourceFormat.getChannels(),
                    sourceFormat.getChannels() * 2,
                    sourceFormat.getSampleRate(),
                    false);

            AudioInputStream pcmAudioInputStream = AudioSystem.getAudioInputStream(targetFormat, audioInputStream);

            File wavFile = new File(outputPath);
            AudioSystem.write(pcmAudioInputStream, AudioFileFormat.Type.WAVE, wavFile);

            audioInputStream.close();
            pcmAudioInputStream.close();
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }
}
