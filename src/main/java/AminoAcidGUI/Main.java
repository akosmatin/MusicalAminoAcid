package AminoAcidGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AminoAcidPlayer");
        frame.setContentPane(new AminoAcidPlayer().aminoAcidPlayerPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
