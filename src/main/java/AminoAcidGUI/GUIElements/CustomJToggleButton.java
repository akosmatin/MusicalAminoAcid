package AminoAcidGUI.GUIElements;

import javax.swing.*;

public class CustomJToggleButton extends JToggleButton {
    private String type;
    private int trackIndex;

    public CustomJToggleButton(String type, int trackIndex){
        super(type);
        this.type = type;
        this.trackIndex = trackIndex;
    }

    public int getTrackIndex() {
        return trackIndex;
    }

    public String getType() {
        return type;
    }
}
