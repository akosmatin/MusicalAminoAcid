package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.rhythmTuple

object Melody4 extends Melody{
  val notes = Seq(84,77,76,74)
  val melodyTrack = for (i <- Range(0,4)) yield {
    rhythmTuple(i*2*division,division,notes(i))
  }
}