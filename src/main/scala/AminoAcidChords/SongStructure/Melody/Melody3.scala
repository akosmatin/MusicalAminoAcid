package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.rhythmTuple

object Melody3 extends Melody{
  val notes = Seq(83,79,74,76)
  val melodyTrack = for (i <- Range(0,4)) yield {
    rhythmTuple(i*2*division,2*division,notes(i))
  }
}