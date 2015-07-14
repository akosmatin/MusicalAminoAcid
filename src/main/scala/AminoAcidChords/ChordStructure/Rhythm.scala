package AminoAcidChords.ChordStructure

/**
 * Created by doccali on 7/12/15.
 */

case class rhythmTuple(measureOffset:Int, duaration:Int)

trait Rhythm {
  val rhythm:Seq[rhythmTuple]
  val voiceRhythm:Seq[rhythmTuple]
  val baseRhythm:Seq[rhythmTuple]
}
