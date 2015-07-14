package AminoAcidChords.ChordStructure.Voicings

import AminoAcidChords.ChordStructure.ChordBuilder

trait Voice79 extends ChordBuilder {
  def notes: Seq[Int] = Seq(scale(root), scale(root + 2), scale(root + 4))

  def voiceNotes: Seq[Int] = Seq(scale(root + 6), scale(root + 8))
}
