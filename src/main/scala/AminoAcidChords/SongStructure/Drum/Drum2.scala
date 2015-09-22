package AminoAcidChords.SongStructure.Drum

import AminoAcidChords.SongStructure.rhythmTuple

object Drum2 extends Drum {
  val drumTrack = (for(i <- Range(0,8)) yield {
    rhythmTuple(i*division, division, 42)
  }) ++ Seq(rhythmTuple(0, division, 35), rhythmTuple(4*division, division, 35))
}
