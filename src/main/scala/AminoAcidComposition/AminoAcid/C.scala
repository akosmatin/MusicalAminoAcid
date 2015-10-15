package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.FMajor
import AminoAcidComposition.SongStructure.Drum.Drum1
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody2
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object C extends AminoAcidAbstract {
  val tracks = new MeasureStructure(FMajor, Bass1, Drum1, Melody2, RhythmGuitar1)
}
