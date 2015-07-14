package AminoAcidChords.ChordStructure

/**
 * Created by doccali on 7/12/15.
 */
trait VoiceSus4 extends Chord {
  def notes():Seq[Int] = Seq(scale(root),scale(root+3),scale(root+4))
  def voiceNotes():Seq[Int] = Seq(scale(root+7))
}
