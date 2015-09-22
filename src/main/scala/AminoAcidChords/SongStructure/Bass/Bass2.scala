package AminoAcidChords.SongStructure.Bass

import AminoAcidChords.SongStructure.{NoteDivision, rhythmTuple}

object Bass2 extends Bass with NoteDivision{
  def bassTrack(rootNote:Int,offset:Int) = Seq(rhythmTuple(0+offset, division*4, rootNote-5), rhythmTuple(2*division+offset, division*4, rootNote-5))
}
