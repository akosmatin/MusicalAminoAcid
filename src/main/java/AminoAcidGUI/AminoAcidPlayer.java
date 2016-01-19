package AminoAcidGUI;

import javax.sound.midi.Track;
import javax.swing.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.TimerTask;

import AminoAcidComposition.MidiInterface$;

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
    private JToggleButton FirstMelodyMuteButton;
    private JToggleButton FirstMelodySoloButton;
    private JToggleButton FirstRhythmMuteButton;
    private JToggleButton FirstRhythmSoloButton;
    private JToggleButton FirstBassMuteButton;
    private JToggleButton FirstBassSoloButton;
    private JToggleButton FirstDrumMuteButton;
    private JToggleButton FirstDrumSoloButton;
    private JToggleButton SecondMelodyMuteButton;
    private JToggleButton SecondMelodySoloButton;
    private JToggleButton SecondRhythmMuteButton;
    private JToggleButton SecondRhythmSoloButton;
    private JToggleButton SecondBassMuteButton;
    private JToggleButton SecondBassSoloButton;
    private JToggleButton SecondDrumMuteButton;
    private JToggleButton SecondDrumSoloButton;
    private JComboBox<String> FirstMelodyDropDown;
    private JComboBox<String> FirstRhythmDropDown;
    private JComboBox<String> FirstBassDropDown;
    private JComboBox<String> SecondMelodyDropDown;
    private JComboBox<String> SecondRhythmDropDown;
    private JComboBox<String> SecondBassDropDown;
    private JPanel aminoAcidPlayerPanel;
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


    private LinkedHashMap<String, String> acids = Acids.getInstance().getAcids();
    private DropDown[] dropDowns = new DropDown[6];

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


        Button[] soloButtons = {
                new Button(mi.melodyTrackIndex(), FirstMelodySoloButton),
                new Button(mi.rhythmGuitarTrackIndex(), FirstRhythmSoloButton),
                new Button(mi.bassTrackIndex(), FirstBassSoloButton),
                new Button(mi.drumTrackIndex(), FirstDrumSoloButton),
                new Button(mi.altMelodyTrackIndex(), SecondMelodySoloButton),
                new Button(mi.altRhythmGuitarTrackIndex(), SecondRhythmSoloButton),
                new Button(mi.altBassTrackIndex(), SecondBassSoloButton),
                new Button(mi.altDrumTrackIndex(), SecondDrumSoloButton)
        };

        Button[] muteButtons = {
                new Button(mi.melodyTrackIndex(), FirstMelodyMuteButton),
                new Button(mi.rhythmGuitarTrackIndex(), FirstRhythmMuteButton),
                new Button(mi.bassTrackIndex(), FirstBassMuteButton),
                new Button(mi.drumTrackIndex(), FirstDrumMuteButton),
                new Button(mi.altMelodyTrackIndex(), SecondMelodyMuteButton),
                new Button(mi.altRhythmGuitarTrackIndex(), SecondRhythmMuteButton),
                new Button(mi.altBassTrackIndex(), SecondBassMuteButton),
                new Button(mi.altDrumTrackIndex(), SecondDrumMuteButton)
        };

        createUIComponents();

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
                mi.playMidi(120);
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
                            updateSelection.cancel();
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
//                    mi.playMidi(120);
//                    paused = false;
//                    playButton.setText("pause");
//                    pauseLocation=0;
//                }else{
//                    pauseLocation = mi.stopMidi();
//                    paused = true;
////                    playButton.setText("play");
//                }
        });


        stopButton.addActionListener(e -> {
            mi.stopMidi();
            paused = false;
            playButton.setText("play");
            trackPresent = false;
            updateSelection.cancel();
            currentAcid = 0;
        });

        for(DropDown dd: dropDowns){
            dd.getComboBox().addActionListener(e -> mi.setInstrument(dd.getTrack(), dd.getTrackIndex(), dd.getComboBox().getSelectedIndex()));
        }

        for(Button sb: soloButtons){
            sb.getButton().addActionListener(e -> mi.soloTrack(sb.getTrackIndex()));
        }

        for(Button mb: muteButtons){
            mb.getButton().addActionListener(e -> mi.muteTrack(mb.getTrackIndex()));
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

    private static void highlightCurrentAcid(JTextField textField, int currentAcid) {
        try{
            textField.requestFocus();
            textField.setSelectionStart(currentAcid);
            textField.setSelectionEnd(currentAcid + 1);
        }catch(IndexOutOfBoundsException ignored){}
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AminoAcidPlayer");
        frame.setContentPane(new AminoAcidPlayer().aminoAcidPlayerPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        for(DropDown dd: dropDowns){
            for(String instrument: mi.listInstruments()) {
                dd.getComboBox().addItem(instrument);
            }
            dd.getComboBox().setSelectedIndex(dd.getDefaultInstrument());
        }
    }
}