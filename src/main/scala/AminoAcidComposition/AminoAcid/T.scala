package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.CMajor
import AminoAcidComposition.SongStructure.Drum.Drum2
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody2
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object T extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajor, Bass1, Drum2, Melody2, RhythmGuitar1)
}
