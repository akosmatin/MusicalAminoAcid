package AminoAcidChords.SongStructure.Bass

import AminoAcidChords.SongStructure.ChordRoot.Chord
import AminoAcidChords.SongStructure.{NoteDivision, rhythmTuple}

trait Bass extends NoteDivision{
  def bassTrack(rootNote:Int,offset:Int): Seq[rhythmTuple]
}
