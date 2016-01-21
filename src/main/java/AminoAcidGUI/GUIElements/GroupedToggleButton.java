package AminoAcidGUI.GUIElements;

import java.util.LinkedList;

public class GroupedToggleButton extends CustomJToggleButton {
    private static LinkedList<CustomJToggleButton> allGroupedButtons = new LinkedList<>();

    public GroupedToggleButton(String type, int trackIndex) {
        super(type, trackIndex);
        allGroupedButtons.add(this);
    }

    public static LinkedList<CustomJToggleButton> getAllGroupedButtons() {
        return allGroupedButtons;
    }

    public static LinkedList<CustomJToggleButton> getGroupedByType(String type){
        LinkedList<CustomJToggleButton> returnValue = new LinkedList<>();
        for (CustomJToggleButton tb: allGroupedButtons){
            if(tb.getType().equals(type)){
                returnValue.add(tb);
            }
        }
        return returnValue;
    }
}
