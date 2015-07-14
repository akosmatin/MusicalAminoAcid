package AminoAcidChords.ChordStructure.Voicings

import AminoAcidChords.ChordStructure.ChordBuilder

trait VoiceNone extends ChordBuilder {
  def notes: Seq[Int] = Seq(scale(root), scale(root + 2), scale(root + 4))

  def voiceNotes: Seq[Int] = Seq(scale(root + 7))
}