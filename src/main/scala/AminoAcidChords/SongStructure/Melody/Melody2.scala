package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.rhythmTuple

object Melody2 extends Melody{
  val notes = Seq(81,76,77,74)
  val melodyTrack = for (i <- Range(0,4)) yield {
    rhythmTuple(i*2*division,2*division,notes(i))
  }
}
