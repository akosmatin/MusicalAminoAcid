package AminoAcidGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import AminoAcidComposition.MidiInterface$;

public class AminoAcidPlayer extends JFrame {
    private MidiInterface$ mi = MidiInterface$.MODULE$;
    private Boolean trackPresent = false;
    private Boolean paused = false;

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
    private JComboBox FirstMelodyDropDown;
    private JComboBox FirstRhythmDropDown;
    private JComboBox FirstBassDropDown;
    private JComboBox SecondMelodyDropDown;
    private JComboBox SecondRhythmDropDown;
    private JComboBox SecondBassDropDown;

    public AminoAcidPlayer() {
        FirstMelodyDropDown.setSelectedIndex(18);
        SecondMelodyDropDown.setSelectedIndex(20);
        FirstRhythmDropDown.setSelectedIndex(24);
        SecondRhythmDropDown.setSelectedIndex(0);
        FirstBassDropDown.setSelectedIndex(33);
        SecondBassDropDown.setSelectedIndex(35);

        playButton.addActionListener(e -> {
            if (!trackPresent) {
                mi.createMidi(firstAminoAcid.getText(), secondAminoAcid.getText());
                mi.setInstrument(mi.rhythmGuitarTrackNumber(),FirstRhythmDropDown.getSelectedIndex());
                mi.setInstrument(mi.melodyTrackNumber(),FirstMelodyDropDown.getSelectedIndex());
                mi.setInstrument(mi.bassTrackNumber(),FirstBassDropDown.getSelectedIndex());
                mi.setInstrument(mi.altRhythmGuitarTrackNumber(),SecondRhythmDropDown.getSelectedIndex());
                mi.setInstrument(mi.altMelodyTrackNumber(), SecondMelodyDropDown.getSelectedIndex());
                mi.setInstrument(mi.altBassTrackNumber(), SecondBassDropDown.getSelectedIndex());
                mi.playMidi(120);
                paused = false;
                trackPresent = true;
            }
        });
        stopButton.addActionListener(e -> {
            mi.stopMidi();
            paused = false;
            playButton.setText("play");
            trackPresent = false;
        });

        FirstRhythmDropDown.addActionListener(e -> mi.setInstrument(mi.rhythmGuitarTrackNumber(), FirstRhythmDropDown.getSelectedIndex()));
        SecondRhythmDropDown.addActionListener(e -> mi.setInstrument(mi.altRhythmGuitarTrackNumber(), SecondRhythmDropDown.getSelectedIndex()));
        FirstMelodyDropDown.addActionListener(e -> mi.setInstrument(mi.melodyTrackNumber(), FirstMelodyDropDown.getSelectedIndex()));
        SecondMelodyDropDown.addActionListener(e -> mi.setInstrument(mi.altMelodyTrackNumber(), SecondMelodyDropDown.getSelectedIndex()));
        FirstBassDropDown.addActionListener(e -> mi.setInstrument(mi.bassTrackNumber(), FirstBassDropDown.getSelectedIndex()));
        SecondBassDropDown.addActionListener(e -> mi.setInstrument(mi.altBassTrackNumber(), SecondBassDropDown.getSelectedIndex()));


        FirstMelodySoloButton.addActionListener(e -> mi.soloTrack(mi.melodyTrackNumber()));
        FirstRhythmSoloButton.addActionListener(e -> mi.soloTrack(mi.rhythmGuitarTrackNumber()));
        FirstBassSoloButton.addActionListener(e -> mi.soloTrack(mi.bassTrackNumber()));
        SecondMelodySoloButton.addActionListener(e -> mi.soloTrack(mi.altMelodyTrackNumber()));
        SecondRhythmSoloButton.addActionListener(e -> mi.soloTrack(mi.altRhythmGuitarTrackNumber()));
        SecondBassSoloButton.addActionListener(e -> mi.soloTrack(mi.altBassTrackNumber()));

        FirstMelodyMuteButton.addActionListener(e -> mi.muteTrack(mi.melodyTrackNumber()));
        FirstRhythmMuteButton.addActionListener(e -> mi.muteTrack(mi.rhythmGuitarTrackNumber()));
        FirstBassSoloButton.addActionListener(e -> mi.muteTrack(mi.bassTrackNumber()));
        SecondMelodySoloButton.addActionListener(e -> mi.muteTrack(mi.altMelodyTrackNumber()));
        SecondRhythmSoloButton.addActionListener(e -> mi.muteTrack(mi.altRhythmGuitarTrackNumber()));
        SecondBassSoloButton.addActionListener(e -> mi.muteTrack(mi.altBassTrackNumber()));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AminoAcidPlayer");
        frame.setContentPane(new AminoAcidPlayer().aminoAcidPlayerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel aminoAcidPlayerPanel;

    private void createUIComponents() {

    }
}
