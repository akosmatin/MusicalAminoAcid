package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.{NoteDivision, rhythmTuple}
trait Melody extends NoteDivision{
  val melodyTrack: Seq[rhythmTuple]
}
