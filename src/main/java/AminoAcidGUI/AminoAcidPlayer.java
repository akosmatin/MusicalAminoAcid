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
//            String[] instruments = mi.listInstruments();
//            for(int i=0; i<instruments.length;i++){
//                System.out.println(i+" "+instruments[i]);
//            }
            if (!trackPresent) {
                mi.createMidi(firstAminoAcid.getText(), secondAminoAcid.getText());
                mi.setInstrument(mi.rhythmGuitarTrack(),0,FirstRhythmDropDown.getSelectedIndex());
                mi.setInstrument(mi.melodyTrack(), 2,FirstMelodyDropDown.getSelectedIndex());
                mi.setInstrument(mi.bassTrack(), 4,FirstBassDropDown.getSelectedIndex());
                mi.setInstrument(mi.altRhythmGuitarTrack(),1,SecondRhythmDropDown.getSelectedIndex());
                mi.setInstrument(mi.altMelodyTrack(),3, SecondMelodyDropDown.getSelectedIndex());
                mi.setInstrument(mi.altBassTrack(), 5, SecondBassDropDown.getSelectedIndex());
                mi.playMidi(120);
                paused = false;
                trackPresent = true;
                playButton.setText("pause");
            } else if(paused){
                mi.playMidi(120);
                paused = false;
                playButton.setText("pause");
            }else{
                mi.stopMidi();
                paused = true;
                playButton.setText("play");
            }
        });
        stopButton.addActionListener(e -> {
            mi.stopMidi();
            paused = false;
            playButton.setText("play");
            trackPresent = false;
        });

        FirstRhythmDropDown.addActionListener(e -> mi.setInstrument(mi.rhythmGuitarTrack(), 0, FirstRhythmDropDown.getSelectedIndex()));
        SecondRhythmDropDown.addActionListener(e -> mi.setInstrument(mi.altRhythmGuitarTrack(),1, SecondRhythmDropDown.getSelectedIndex()));
        FirstMelodyDropDown.addActionListener(e -> mi.setInstrument(mi.melodyTrack(),2, FirstMelodyDropDown.getSelectedIndex()));
        SecondMelodyDropDown.addActionListener(e -> mi.setInstrument(mi.altMelodyTrack(),3, SecondMelodyDropDown.getSelectedIndex()));
        FirstBassDropDown.addActionListener(e -> mi.setInstrument(mi.bassTrack(), 4, FirstBassDropDown.getSelectedIndex()));
        SecondBassDropDown.addActionListener(e -> mi.setInstrument(mi.altBassTrack(), 5, SecondBassDropDown.getSelectedIndex()));


        FirstMelodySoloButton.addActionListener(e -> mi.soloTrack(mi.melodyTrackIndex()));
        FirstRhythmSoloButton.addActionListener(e -> mi.soloTrack(mi.rhythmGuitarTrackIndex()));
        FirstBassSoloButton.addActionListener(e -> mi.soloTrack(mi.bassTrackIndex()));
        FirstDrumSoloButton.addActionListener(e -> mi.soloTrack(mi.drumTrackIndex()));
        SecondMelodySoloButton.addActionListener(e -> mi.soloTrack(mi.altMelodyTrackIndex()));
        SecondRhythmSoloButton.addActionListener(e -> mi.soloTrack(mi.altRhythmGuitarTrackIndex()));
        SecondBassSoloButton.addActionListener(e -> mi.soloTrack(mi.altBassTrackIndex()));
        SecondDrumSoloButton.addActionListener(e -> mi.soloTrack(mi.altDrumTrackIndex()));

        FirstMelodyMuteButton.addActionListener(e -> mi.muteTrack(mi.melodyTrackIndex()));
        FirstRhythmMuteButton.addActionListener(e -> mi.muteTrack(mi.rhythmGuitarTrackIndex()));
        FirstBassMuteButton.addActionListener(e -> mi.muteTrack(mi.bassTrackIndex()));
        FirstDrumMuteButton.addActionListener(e -> mi.muteTrack(mi.drumTrackIndex()));
        SecondMelodyMuteButton.addActionListener(e -> mi.muteTrack(mi.altMelodyTrackIndex()));
        SecondRhythmMuteButton.addActionListener(e -> mi.muteTrack(mi.altRhythmGuitarTrackIndex()));
        SecondBassMuteButton.addActionListener(e -> mi.muteTrack(mi.altBassTrackIndex()));
        SecondDrumMuteButton.addActionListener(e -> mi.muteTrack(mi.altDrumTrackIndex()));
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
