package AminoAcidGUI;

import javax.swing.*;

class Button {
    private JToggleButton button;
    private int trackIndex;

    public Button(int trackIndex, JToggleButton button){
        this.trackIndex=trackIndex;
        this.button=button;
    }

    public JToggleButton getButton() {
        return button;
    }

    public int getTrackIndex() {
        return trackIndex;
    }
}