package AminoAcidGUI;

import javax.sound.midi.Track;
import javax.swing.*;

class DropDown{
    private Track track;
    private int trackIndex;
    private JComboBox<String> comboBox;
    private int defaultInstrument;

    public DropDown(Track track, int trackIndex, JComboBox<String> comboBox, int defaultInstrument){
        this.track=track;
        this.trackIndex=trackIndex;
        this.comboBox=comboBox;
        this.defaultInstrument = defaultInstrument;
    }

    public Track getTrack() {
        return track;
    }

    public int getTrackIndex() {
        return trackIndex;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public int getDefaultInstrument() {
        return defaultInstrument;
    }
}