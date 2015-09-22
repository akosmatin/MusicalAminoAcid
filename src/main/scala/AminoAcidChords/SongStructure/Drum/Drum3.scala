package AminoAcidChords.SongStructure.Drum

import AminoAcidChords.SongStructure.rhythmTuple

object Drum3 extends Drum {
  def drumTrack(measureOffset:Int) = {
    Seq(
      (42, 60, one, eighth),
      (42, 60, oneAnd, eighth),
      (42, 60, two, eighth),
      (42, 60, twoAnd, eighth),
      (42, 60, three, eighth),
      (42, 60, threeAnd, eighth),
      (42, 60, four, eighth),
      (42, 60, fourAnd, eighth),

      (35, 120, one, quarter),
      (35, 120, two, quarter),
      (35, 120, three, quarter),
      (35, 120, four, quarter)
    ) foreach(n => mc.addNote(trackNumber, n._1, n._2, measureOffset + n._3, n._4))
  }}