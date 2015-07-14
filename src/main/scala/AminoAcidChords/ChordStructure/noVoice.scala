package AminoAcidChords.ChordStructure

/**
 * Created by doccali on 7/12/15.
 */
trait noVoice extends Chord{
  def notes():Seq[Int] = Seq(scale(root),scale(root+2),scale(root+4))
  def voiceNotes():Seq[Int] = Seq(scale(root+7))
}