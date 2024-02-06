package model;

import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class AdvancedPlayer {
    private Player player;

    public AdvancedPlayer(InputStream stream) throws JavaLayerException {
        this.player = new Player(stream);
    }

    public void play() throws JavaLayerException {
        if (player != null) {
            player.play();
        }
    }

    public void close() {
        if (player != null) {
            player.close();
        }
    }
}