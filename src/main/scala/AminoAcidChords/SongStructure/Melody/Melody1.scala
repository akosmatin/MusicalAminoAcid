package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.rhythmTuple

object Melody1 extends Melody{
  val notes = Seq(72,74,76,79)
  val melodyTrack = for (i <- Range(0,4)) yield {
    rhythmTuple(i*2*division,2*division,notes(i))
  }
}
