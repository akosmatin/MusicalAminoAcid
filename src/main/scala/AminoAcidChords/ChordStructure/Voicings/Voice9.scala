package AminoAcidChords.ChordStructure.Voicings

import AminoAcidChords.ChordStructure.ChordBuilder

trait Voice9 extends ChordBuilder {
  def notes: Seq[Int] = Seq(scale(root), scale(root + 2), scale(root + 4))

  def voiceNotes: Seq[Int] = Seq(scale(root + 8))
}
