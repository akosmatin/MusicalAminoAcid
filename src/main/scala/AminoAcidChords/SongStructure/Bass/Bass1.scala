package AminoAcidChords.SongStructure.Bass

import AminoAcidChords.SongStructure.{NoteDivision, rhythmTuple}

object Bass1 extends Bass with NoteDivision{
  def bassTrack(rootNote:Int, offset:Int) = Seq(rhythmTuple(0+offset, division*4, rootNote-12), rhythmTuple(2*division+offset, division*4, rootNote-12))
}
