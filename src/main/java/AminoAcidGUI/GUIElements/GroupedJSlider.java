package AminoAcidGUI.GUIElements;

import javax.sound.midi.Track;
import java.util.LinkedList;

public class GroupedJSlider extends CustomJSlider{
    private static LinkedList<CustomJSlider> allGroupedSliders = new LinkedList<>();

    public GroupedJSlider(Track track, int trackIndex){
        super(track, trackIndex);
        allGroupedSliders.add(this);
    }

    public static LinkedList<CustomJSlider> getAllGroupedSliders() {
        return allGroupedSliders;
    }
}