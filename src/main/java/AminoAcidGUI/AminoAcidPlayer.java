package AminoAcidGUI;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import AminoAcidComposition.MidiInterface$;
import AminoAcidGUI.Data.Acids;
import AminoAcidGUI.GUIElements.CustomJSlider;
import AminoAcidGUI.GUIElements.CustomJToggleButton;
import AminoAcidGUI.GUIElements.GroupedJSlider;
import AminoAcidGUI.GUIElements.GroupedToggleButton;

public class AminoAcidPlayer extends JFrame {
    private MidiInterface$ mi = MidiInterface$.MODULE$;
    private Boolean trackPresent = false;
    private Boolean paused = false;
    private long pauseLocation = 0;
    private Timer updateSelection;
    private int currentAcid = 0;

    private JTextField firstAminoAcid;
    private JTextField secondAminoAcid;
    private JButton playButton;
    private JButton stopButton;
    private GroupedToggleButton FirstMelodyMuteButton;
    private GroupedToggleButton FirstMelodySoloButton;
    private GroupedToggleButton FirstRhythmMuteButton;
    private GroupedToggleButton FirstRhythmSoloButton;
    private GroupedToggleButton FirstBassMuteButton;
    private GroupedToggleButton FirstBassSoloButton;
    private GroupedToggleButton FirstDrumMuteButton;
    private GroupedToggleButton FirstDrumSoloButton;
    private GroupedToggleButton SecondMelodyMuteButton;
    private GroupedToggleButton SecondMelodySoloButton;
    private GroupedToggleButton SecondRhythmMuteButton;
    private GroupedToggleButton SecondRhythmSoloButton;
    private GroupedToggleButton SecondBassMuteButton;
    private GroupedToggleButton SecondBassSoloButton;
    private GroupedToggleButton SecondDrumMuteButton;
    private GroupedToggleButton SecondDrumSoloButton;
    private JComboBox<String> FirstMelodyDropDown;
    private JComboBox<String> FirstRhythmDropDown;
    private JComboBox<String> FirstBassDropDown;
    private JComboBox<String> SecondMelodyDropDown;
    private JComboBox<String> SecondRhythmDropDown;
    private JComboBox<String> SecondBassDropDown;
    protected JPanel aminoAcidPlayerPanel;
    private JTextField saveField;
    private JButton saveButton;
    private JButton saveAsButton;
    private JButton convertButton;
    private JComboBox<String> FirstAminoAcidDropDown;
    private JComboBox<String> SecondAminoAcidDropDown;
    private JPanel SequencePanel;
    private JPanel PlayControlPanel;
    private JPanel SaveControlPanel;
    private JPanel InstrumentControlPanel;
    private JPanel TrackControlPanel;
    private GroupedJSlider firstMelodySlider;
    private GroupedJSlider secondMelodySlider;
    private GroupedJSlider firstRhythmSlider;
    private GroupedJSlider secondRhythmSlider;
    private GroupedJSlider firstBassSlider;
    private GroupedJSlider secondBassSlider;
    private GroupedJSlider firstDrumSlider;
    private GroupedJSlider secondDrumSlider;


    private LinkedHashMap<String, String> acids = Acids.getInstance().getAcids();
    private DropDown[] dropDowns = new DropDown[6];
    private LinkedList<CustomJSlider> volumeSliders = GroupedJSlider.getAllGroupedSliders();

    private void createTrack() {
        mi.stopMidi();
        mi.createMidi(firstAminoAcid.getText(), secondAminoAcid.getText());
        for(DropDown dd: dropDowns){
            mi.setInstrument(dd.getTrack(), dd.getTrackIndex(), dd.getComboBox().getSelectedIndex());
        }
    }

    public AminoAcidPlayer() {
        dropDowns[0] = new DropDown(mi.rhythmGuitarTrack(), mi.rhythmGuitarTrackIndex(), FirstRhythmDropDown, 24);
        dropDowns[1] = new DropDown(mi.melodyTrack(), mi.melodyTrackIndex(),FirstMelodyDropDown, 48);
        dropDowns[2] = new DropDown(mi.bassTrack(), mi.bassTrackIndex(),FirstBassDropDown, 35);
        dropDowns[3] = new DropDown(mi.altRhythmGuitarTrack(), mi.altRhythmGuitarTrackIndex(), SecondRhythmDropDown, 0);
        dropDowns[4] = new DropDown(mi.altMelodyTrack(), mi.altMelodyTrackIndex(), SecondMelodyDropDown, 4);
        dropDowns[5] = new DropDown(mi.altBassTrack(), mi.altBassTrackIndex(), SecondBassDropDown, 35);

        for(DropDown dd: dropDowns){
            for(String instrument: mi.listInstruments()) {
                dd.getComboBox().addItem(instrument);
            }
            dd.getComboBox().setSelectedIndex(dd.getDefaultInstrument());
        }

        for(String acid: acids.keySet()){
            FirstAminoAcidDropDown.addItem(acid);
            SecondAminoAcidDropDown.addItem(acid);
        }

        FirstAminoAcidDropDown.addActionListener(e -> {
            firstAminoAcid.setText(acids.get(FirstAminoAcidDropDown.getSelectedItem()));
            firstAminoAcid.setCaretPosition(0);
        });

        SecondAminoAcidDropDown.addActionListener(e -> {
            secondAminoAcid.setText(acids.get(SecondAminoAcidDropDown.getSelectedItem()));
            secondAminoAcid.setCaretPosition(0);
        });

        playButton.addActionListener(e -> {
            if (!trackPresent) {
                createTrack();
                playMidi(120);
//                    paused = false;
                trackPresent = true;
//                    playButton.setText("pause");
                pauseLocation=0;
                firstAminoAcid.requestFocus();
                updateSelection = new Timer();
                updateSelection.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (currentAcid>=firstAminoAcid.getText().length() &&
                                currentAcid>=secondAminoAcid.getText().length()){
                            stopPlayback();
                            currentAcid=-1;
                        }
                        firstAminoAcid.setScrollOffset((currentAcid-32)*8);
                        secondAminoAcid.setScrollOffset((currentAcid-32)*8);
                        if(firstAminoAcid.hasFocus()) {
                            highlightCurrentAcid(secondAminoAcid, currentAcid);
                            highlightCurrentAcid(firstAminoAcid, currentAcid);
                        }else if(secondAminoAcid.hasFocus()) {
                            highlightCurrentAcid(firstAminoAcid, currentAcid);
                            highlightCurrentAcid(secondAminoAcid, currentAcid);
                        }
                        currentAcid++;
                    }
                }, 0, 2000);
            }
//                else if(paused){
//                    createTrack();
//                    mi.setLocation(pauseLocation);
//                    playMidi(120);
//                    paused = false;
//                    playButton.setText("pause");
//                    pauseLocation=0;
//                }else{
//                    pauseLocation = stopPlayback();
//                    paused = true;
////                    playButton.setText("play");
//                }
        });


        stopButton.addActionListener(e -> {
            stopPlayback();
            currentAcid = 0;
        });

        for(DropDown dd: dropDowns){
            dd.getComboBox().addActionListener(e -> mi.setInstrument(dd.getTrack(), dd.getTrackIndex(), dd.getComboBox().getSelectedIndex()));
        }

        for(CustomJToggleButton sb: GroupedToggleButton.getGroupedByType("Solo")){
            sb.addActionListener(e -> mi.soloTrack(sb.getTrackIndex()));
        }

        for(CustomJToggleButton mb: GroupedToggleButton.getGroupedByType("Mute")){
            mb.addActionListener(e -> mi.muteTrack(mb.getTrackIndex()));
        }

        for(CustomJSlider vs: volumeSliders){
            vs.addChangeListener(e -> mi.changeVolume(vs.getTrack(), vs.getTrackIndex(), vs.getValue()));
        }

        saveAsButton.addActionListener(e -> {
            final JFileChooser fc = new JFileChooser();
            int retVal = fc.showSaveDialog(AminoAcidPlayer.this);
            if (retVal == JFileChooser.APPROVE_OPTION) {
                if (!trackPresent) {
                    createTrack();
                }
                saveField.setText(fc.getSelectedFile().toString());
                mi.writeMidi(fc.getSelectedFile().toString());
            }
        });
        saveButton.addActionListener(e -> {
            if (!trackPresent) {
                createTrack();
            }
            mi.writeMidi(saveField.getText());
        });
        convertButton.addActionListener(e -> {
            Runtime rt = Runtime.getRuntime();
            try {
                rt.exec("timidity " + saveField.getText() + " -Ow");
                JOptionPane.showMessageDialog(AminoAcidPlayer.this, "Converted to wav");
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(AminoAcidPlayer.this, "Failed to convert", "error", JOptionPane.ERROR_MESSAGE);
                e1.printStackTrace();
            }

        });
    }

    private void playMidi(int bpm) {
        mi.playMidi(bpm);
        for(CustomJSlider vs: volumeSliders){
            vs.setEnabled(true);
        }
        for(CustomJToggleButton tb: GroupedToggleButton.getAllGroupedButtons()){
            tb.setEnabled(true);
        }
    }

    private long stopPlayback(){
        long currentTick;
        try{
            currentTick = mi.stopMidi();
        }catch (NullPointerException e){
            currentTick = 0;
        }
        paused = false;
        playButton.setText("play");
        trackPresent = false;
        try{
            updateSelection.cancel();
        }catch (NullPointerException ignored){}
        for(CustomJSlider vs: volumeSliders){
            vs.setValue(100);
            vs.setEnabled(false);
        }
        for(CustomJToggleButton tb: GroupedToggleButton.getAllGroupedButtons()){
            tb.setSelected(false);
            tb.setEnabled(false);
        }
        return currentTick;
    }

    private static void highlightCurrentAcid(JTextField textField, int currentAcid) {
        try{
            textField.requestFocus();
            textField.setSelectionStart(currentAcid);
            textField.setSelectionEnd(currentAcid + 1);
        }catch(IndexOutOfBoundsException ignored){}
    }

    private void createUIComponents() {
        FirstMelodyMuteButton = new GroupedToggleButton("Mute", mi.melodyTrackIndex());
        FirstRhythmMuteButton = new GroupedToggleButton("Mute", mi.rhythmGuitarTrackIndex());
        FirstBassMuteButton = new GroupedToggleButton("Mute", mi.bassTrackIndex());
        FirstDrumMuteButton = new GroupedToggleButton("Mute", mi.drumTrackIndex());
        SecondMelodyMuteButton = new GroupedToggleButton("Mute", mi.altMelodyTrackIndex());
        SecondRhythmMuteButton = new GroupedToggleButton("Mute", mi.altRhythmGuitarTrackIndex());
        SecondBassMuteButton = new GroupedToggleButton("Mute", mi.altBassTrackIndex());
        SecondDrumMuteButton = new GroupedToggleButton("Mute", mi.altDrumTrackIndex());

        FirstMelodySoloButton = new GroupedToggleButton("Solo", mi.melodyTrackIndex());
        FirstRhythmSoloButton = new GroupedToggleButton("Solo", mi.rhythmGuitarTrackIndex());
        FirstBassSoloButton = new GroupedToggleButton("Solo", mi.bassTrackIndex());
        FirstDrumSoloButton = new GroupedToggleButton("Solo", mi.drumTrackIndex());
        SecondMelodySoloButton = new GroupedToggleButton("Solo", mi.altMelodyTrackIndex());
        SecondRhythmSoloButton = new GroupedToggleButton("Solo", mi.altRhythmGuitarTrackIndex());
        SecondBassSoloButton = new GroupedToggleButton("Solo", mi.altBassTrackIndex());
        SecondDrumSoloButton = new GroupedToggleButton("Solo", mi.altDrumTrackIndex());

        firstMelodySlider = new GroupedJSlider(mi.melodyTrack(), mi.melodyTrackIndex());
        secondMelodySlider = new GroupedJSlider(mi.altMelodyTrack(),mi.altBassTrackIndex());
        firstRhythmSlider = new GroupedJSlider(mi.rhythmGuitarTrack(),mi.rhythmGuitarTrackIndex());
        secondRhythmSlider = new GroupedJSlider(mi.altRhythmGuitarTrack(),mi.altRhythmGuitarTrackIndex());
        firstBassSlider = new GroupedJSlider(mi.bassTrack(),mi.bassTrackIndex());
        secondBassSlider = new GroupedJSlider(mi.altBassTrack(),mi.altBassTrackIndex());
        firstDrumSlider = new GroupedJSlider(mi.drumTrack(),mi.drumTrackIndex());
        secondDrumSlider = new GroupedJSlider(mi.altDrumTrack(),mi.altDrumTrackIndex());
    }
}