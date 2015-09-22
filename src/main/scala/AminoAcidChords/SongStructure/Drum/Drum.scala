package AminoAcidChords.SongStructure.Drum

import AminoAcidChords.SongStructure.{NoteDivision, rhythmTuple}
trait Drum extends NoteDivision{
  val drumTrack: Seq[rhythmTuple]
}
