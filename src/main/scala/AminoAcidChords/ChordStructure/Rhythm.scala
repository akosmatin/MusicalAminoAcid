package AminoAcidChords.ChordStructure

case class rhythmTuple(measureOffset: Int, duration: Int)

trait Rhythm {
  val rhythm: Seq[rhythmTuple]
  val voiceRhythm: Seq[rhythmTuple]
  val baseRhythm: Seq[rhythmTuple]
}
