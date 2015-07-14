package AminoAcidChords.ChordStructure

/**
 * Created by doccali on 7/12/15.
 */
trait Rhythm1 extends Rhythm {
  val rhythm = Seq(rhythmTuple(0,2),rhythmTuple(2,1))
  val voiceRhythm = Seq(rhythmTuple(1,1),rhythmTuple(2,1))
  val baseRhythm = Seq(rhythmTuple(0,1),rhythmTuple(1,1),rhythmTuple(2,1))
}
