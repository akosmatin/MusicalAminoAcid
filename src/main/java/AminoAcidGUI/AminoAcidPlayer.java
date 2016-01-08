package AminoAcidGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JComboBox FirstMelodyDropDown;
    private JComboBox FirstRhythmDropDown;
    private JComboBox FirstBassDropDown;
    private JComboBox SecondMelodyDropDown;
    private JComboBox SecondRhythmDropDown;
    private JComboBox SecondBassDropDown;
    private JPanel aminoAcidPlayerPanel;
    private JTextField saveField;
    private JButton saveButton;
    private JButton saveAsButton;
    private JButton convertButton;
    private JComboBox FirstAminoAcidDropDown;
    private JComboBox SecondAminoAcidDropDown;
    private JPanel SequencePanel;
    private JPanel PlayControlPanel;
    private JPanel SaveControlPanel;
    private JPanel InstrumentControlPanel;
    private JPanel TrackControlPanel;

    LinkedHashMap<String, String> acids = new LinkedHashMap<>();

    private void createTrack() {
        mi.stopMidi();
        mi.createMidi(firstAminoAcid.getText(), secondAminoAcid.getText());
        mi.setInstrument(mi.rhythmGuitarTrack(),0,FirstRhythmDropDown.getSelectedIndex());
        mi.setInstrument(mi.melodyTrack(), 2,FirstMelodyDropDown.getSelectedIndex());
        mi.setInstrument(mi.bassTrack(), 4,FirstBassDropDown.getSelectedIndex());
        mi.setInstrument(mi.altRhythmGuitarTrack(),1,SecondRhythmDropDown.getSelectedIndex());
        mi.setInstrument(mi.altMelodyTrack(),3, SecondMelodyDropDown.getSelectedIndex());
        mi.setInstrument(mi.altBassTrack(), 5, SecondBassDropDown.getSelectedIndex());
    }

    public AminoAcidPlayer() {
        acids.put("None","");
        acids.put("HBB",              "MVHLTPEEKSAVTALWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH");
        acids.put("HBB S (Sickle Cell Anemia)",  "MVHLTPVEKSAVTALWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH");
        acids.put("HBB C",            "MVHLTPKEKSAVTALWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH");
        acids.put("HBB E",             "MVHLTPEEKSAVTALWGKVNVDEVGGKALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH");
        acids.put("HBA1 Human",             "MVLSPADKTNVKAAWGKVGAHAGEYGAEALERMFLSFPTTKTYFPHFDLSHGSAQVKGHGKKVADALTNAVAHVDDMPNALSALSDLHAHKLRVDPVNFKLLSHCLLVTLAAHLPAEFTPAVHASLDKFLASVSTVLTSKYR");
        acids.put("DPH6 Human",             "MRVAALISGGKDSCYNMMQCIAAGHQIVALANLRPAENQVGSDELDSYMYQTVGHHAIDLYAEAMALPLYRRTIRGRSLDTRQVYTKCEGDEVEDLYELLKLVKEKEEVEGISVGAILSDYQRIRVENVCKRLNLQPLAYLWQRNQEDLLREMISSNIQAMIIKVAALGLDPDKHLGKTLDQMEPYLIELSKKYGVHVCGEGGEYETFTLDCPLFKKKIIVDSSEVVIHSADAFAPVAYLRFLELHLEDKVSSVPDNYRTSNYIYNF");
        acids.put("DPH6 Mouse",             "MRVAALISGGKDSCYNMMQCIAEGHQIVALANLRPDENQVESDELDSYMYQTVGHHAIDLYAEAMALPLYRRAIRGRSLETGRVYTQCEGDEVEDLYELLKLVKEKEEIEGVSVGAILSDYQRGRVENVCKRLNLQPLAYLWQRNQEDLLREMIASNIKAIIIKVAALGLDPDKHLGKTLVEMEPYLLELSKKYGVHVCGEGGEYETFTLDCPLFKKKIVVDSSEAVMHSADAFAPVAYLRLSRLHLEEKVSSVPADDETANSIHSS");
        acids.put("DPH6 Rat",               "MRVAALISGGKDSCYNMMRCIAEGHQIVALANLRPDDNQVESDELDSYMYQTVGHHAIDLYAEAMALPLYRRTIRGRSLETGRVYTRCEGDEVEDLYELLKLVKEKEEIEGVSVGAILSDYQRVRVENVCKRLNLQPLAYLWQRNQEDLLREMIASNIEAIIIKVAALGLDPDKHLGKTLGEMEPYLLELSKKYGVHVCGEGGEYETFTLDCPLFKKKIVVDTSEAVIHSADAFAPVAYLRLSGLHLEEKVSSVPGDDETTSYIHNS");
        acids.put("DPH6 ZebraFish",         "MRVVGLISGGKDSCFNMLQCVSAGHSIVALANLRPADHAASDELDSYMYQTVGHQAVDLIAEAMGLPLYRRTIEGSSVHIDREYSPTDGDEVEDLYQLLKHVKEEMHVDGVSVGAILSDYQRVRVENVCARLQLQPLAYLWRRDQAALLSEMISSGLHAILIKVAAFGLHPDKHLGKSLAEMELYLHELSEKYGVHICGEGGEYETFTLDCPLFKKKIIIDATETVIHSDDAFAPVGFLRFTKMHTEDKTEGSGGPPPPSLSACPCQSAIDRMTEELEYADKTADVQRECPSHTQSTWQLDEGCEVSHSSSSSGFQWISGLSALPSEHPDIQSQAQHVFTLLQSRLQEMGSALRHVLLVHLYVSSMQDFGLINSIYSRLFTHNPPARVCVQASLPVGQQLQMDVLLQDQTKASPSSSSSVCEEECFPQRETLHVQSVSHWAPANIGPYSQATQVQLCFLLTAAASAVFSTVFYISTSAAQWLSGQHCGFTARRSLV");
        acids.put("DPH6 D. melanogaster",   "MRVVAMVSGGKDSCYNMMQCVAEGHEIVALANLHPKDRDELDSFMYQTVGHMGIEILASAMGLPLYRRETKGKSTQTGKQYVPTDDDEVEDLYSLLETCKHELQVDAVAVGAILSDYQRVRVENVCSRLNLISLAYLWRRDQTELLQEMIDCQVHAIIIKVAALGLVPDRHLGKSLREMQPHLLKMRDKYGLNVCGEGGEYETFTLDCPLFRQRIVVEDIQTIISSADPICPVGYINFTKLTLQPKEAAGAASSGGNEVVFVKRSLDYISDLNESTYSDLSDPDFSETELELIEKETRLRESLSQSELISRSNSFGRHLAATASSPIPIVTKSASVDEPTAAAAPILGGVGGPPICSTSACASMLLTTTADGLSSLASSQSQGGGHGLGSSTAAVCGSLSLAISSLGLSANTCCHPGGAGGGGGVGIGVGAGAGAGAPSATTQPPSPLKYEREFRPLANEARAAINAKGWMWLAGIQGSGTEGIEQGMQQALDTLRDLCQAKGYDLQDLCYVTLYVRSIGEYPLLNRVYHRAFDFHNPPTRVCVECPLPDGCHVVMEAIAYRQPVAGTISSAEERDREGEETAAALLNGRRNTMHVQGISHWAPANIGPYSQSTRIGDITYISGQIALVPGSMTIIEGGIRPQCKLTLRHISRIAKAMNAHGQLRDVVHGICFVTHPAFIGEARRQWERRTTNAIMDYIVLPALPREALVEWQVWAHTHNDRFDYEETGCSVGDYTISIRRRWNYENNCAAIVCYVSTGLASSTTQLTQLSDDILGNHCRLAQAVNAEHLDEIFTYVVNRLLKDYPLAKKQASQPTNSATPPATPTQPGGAGGDQQQPVPAIHLKLFYQVNAAPATDLLLQALHDFRLKCQDTAAIVYTVLPACSLHNFSTFLSICGVRHE");
        acids.put("DPH6 C. elegans", "MQVVGLISGGKDSCYNLMCAVREGHQIVALANLHPPKDAKSDELDSYMYQSVGADGVELYGEAMQLPLYRREITGEPKNQKSDYEKTDGDEVEDLFELLCEVKKHHPEVKGVSAGAILSSYQKVRVEDICRRLDLVPLCFLWEREQNGLLAEMVENGLDAILIKVAAIGLGEQHLGKTLSEMAPIMKVLQDKYGVHPCGEGGEFESFVRDCPLFKKRIVIDETETVTHQDDPIAPVFYLRLKKMHLEDK");
        acids.put("DPH6 S. cerevisiae", "MKFIALISGGKDSFYNIFHCLKNNHELIALGNIYPKESEEQELDSFMFQTVGHDLIDYYSKCIGVPLFRRSILRNTSNNVELNYTATQDDEIEELFELLRTVKDKIPDLEAVSVGAILSSYQRTRVENVCSRLGLVVLSYLWQRDQAELMGEMCLMSKDVNNVENDTNSGNKFDARIIKVAAIGLNEKHLGMSLPMMQPVLQKLNQLYQVHICGEGGEFETMVLDAPFFQHGYLELIDIVKCSDGEVHNARLKVKFQPRNLSKSFLLNQLDQLPVPSIFGNNWQDLTQNLPKQQAKTGEQRFENHMSNALPQTTINKTNDKLYISNLQSRKSETVEKQSEDIFTELADILHSNQIPRNHILSASLLIRDMSNFGKINKIYNEFLDLSKYGPLPPSRACVGSKCLPEDCHVQLSVVVDVKNTGKEKINKNKGGLHVQGRSYWAPCNIGPYSQSTWLNDDANQVSFISGQIGLVPQSMEILGTPLTDQIVLALQHFDTLCETIGAQEKLLMTCYISDESVLDSVIKTWAFYCSNMNHRSDLWMDKSDDVEKCLVLVKISELPRGAVAEFGGVTCKRLIVDDNDSDKKEREENDDVSTVFQKLNLNIEGFHNTTVSAFGYNRNFITGFVDSREELELILEKTPKSAQITLYYNPKEIITFHHHIGYYPVEKLFDYRGKEHRFGLHIRS");


        createUIComponents();

        for(String acid: acids.keySet()){
            FirstAminoAcidDropDown.addItem(acid);
            SecondAminoAcidDropDown.addItem(acid);
        }

        FirstAminoAcidDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstAminoAcid.setText(acids.get(FirstAminoAcidDropDown.getSelectedItem()));
                firstAminoAcid.setCaretPosition(0);
                firstAminoAcid.requestFocus();
            }
        });

        SecondAminoAcidDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondAminoAcid.setText(acids.get(SecondAminoAcidDropDown.getSelectedItem()));
                secondAminoAcid.setCaretPosition(0);
                secondAminoAcid.requestFocus();
            }
        });

        playButton.addActionListener(new ActionListener() {
//            removed pause stuff
            @Override
            public void actionPerformed(ActionEvent e) {
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
                            if(currentAcid<firstAminoAcid.getText().length()) {
                                try {
                                    firstAminoAcid.setCaretPosition(currentAcid + 22);
                                }catch(IllegalArgumentException e){}
                                firstAminoAcid.setSelectionStart(currentAcid);
                                firstAminoAcid.setSelectionEnd(currentAcid + 1);
                            }

                            if(currentAcid<secondAminoAcid.getText().length()){
                                try{
                                    secondAminoAcid.setCaretPosition(currentAcid + 22);
                                }catch(IllegalArgumentException e){}
                                secondAminoAcid.setSelectionStart(currentAcid);
                                secondAminoAcid.setSelectionEnd(currentAcid+1);
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
                firstAminoAcid.setEditable(false);
                secondAminoAcid.setEditable(false);
            }
        });


        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.stopMidi();
                paused = false;
                playButton.setText("play");
                trackPresent = false;
                updateSelection.cancel();
                currentAcid = 0;
                firstAminoAcid.setEditable(true);
                secondAminoAcid.setEditable(true);
            }
        });

        FirstRhythmDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.setInstrument(mi.rhythmGuitarTrack(), 0, FirstRhythmDropDown.getSelectedIndex());
            }
        });
        SecondRhythmDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.setInstrument(mi.altRhythmGuitarTrack(), 1, SecondRhythmDropDown.getSelectedIndex());
            }
        });
        FirstMelodyDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.setInstrument(mi.melodyTrack(), 2, FirstMelodyDropDown.getSelectedIndex());
            }
        });
        SecondMelodyDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.setInstrument(mi.altMelodyTrack(), 3, SecondMelodyDropDown.getSelectedIndex());
            }
        });
        FirstBassDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.setInstrument(mi.bassTrack(), 4, FirstBassDropDown.getSelectedIndex());
            }
        });
        SecondBassDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.setInstrument(mi.altBassTrack(), 5, SecondBassDropDown.getSelectedIndex());
            }
        });


        FirstMelodySoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.melodyTrackIndex());
            }
        });
        FirstRhythmSoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.rhythmGuitarTrackIndex());
            }
        });
        FirstBassSoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.bassTrackIndex());
            }
        });
        FirstDrumSoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.drumTrackIndex());
            }
        });
        SecondMelodySoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.altMelodyTrackIndex());
            }
        });
        SecondRhythmSoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.altRhythmGuitarTrackIndex());
            }
        });
        SecondBassSoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.altBassTrackIndex());
            }
        });
        SecondDrumSoloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.soloTrack(mi.altDrumTrackIndex());
            }
        });

        FirstMelodyMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.melodyTrackIndex());
            }
        });
        FirstRhythmMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.rhythmGuitarTrackIndex());
            }
        });
        FirstBassMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.bassTrackIndex());
            }
        });
        FirstDrumMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.drumTrackIndex());
            }
        });
        SecondMelodyMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.altMelodyTrackIndex());
            }
        });
        SecondRhythmMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.altRhythmGuitarTrackIndex());
            }
        });
        SecondBassMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.altBassTrackIndex());
            }
        });
        SecondDrumMuteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mi.muteTrack(mi.altDrumTrackIndex());
            }
        });
        saveAsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser fc = new JFileChooser();
                int retVal = fc.showSaveDialog(AminoAcidPlayer.this);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    if (!trackPresent) {
                        createTrack();
                    }
                    saveField.setText(fc.getSelectedFile().toString());
                    mi.writeMidi(fc.getSelectedFile().toString());
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!trackPresent) {
                    createTrack();
                }
                mi.writeMidi(saveField.getText());
            }
        });
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Runtime rt = Runtime.getRuntime();
                try {
                    rt.exec("timidity " + saveField.getText() + " -Ow");
                    JOptionPane.showMessageDialog(AminoAcidPlayer.this, "Converted to wav");
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(AminoAcidPlayer.this, "Failed to convert", "error", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }

            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AminoAcidPlayer");
        frame.setContentPane(new AminoAcidPlayer().aminoAcidPlayerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        for(String instrument: mi.listInstruments()) {
            FirstMelodyDropDown.addItem(instrument);
            SecondMelodyDropDown.addItem(instrument);
            FirstRhythmDropDown.addItem(instrument);
            SecondRhythmDropDown.addItem(instrument);
            FirstBassDropDown.addItem(instrument);
            SecondBassDropDown.addItem(instrument);
        }


        FirstMelodyDropDown.setSelectedIndex(48);
        SecondMelodyDropDown.setSelectedIndex(4);
        FirstRhythmDropDown.setSelectedIndex(24);
        SecondRhythmDropDown.setSelectedIndex(0);
        FirstBassDropDown.setSelectedIndex(33);
        SecondBassDropDown.setSelectedIndex(35);
    }
}