package AminoAcidGUI.GUIElements;

import javax.sound.midi.Track;
import javax.swing.*;

public class CustomJSlider extends JSlider {
    private Track track;
    private int trackIndex;

    public CustomJSlider(Track track, int trackIndex){
        super();
        this.track = track;
        this.trackIndex = trackIndex;
    }

    public Track getTrack() {
        return track;
    }

    public int getTrackIndex() {
        return trackIndex;
    }
}