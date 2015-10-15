package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.AMinor
import AminoAcidComposition.SongStructure.Drum.Drum1
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody1
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object V extends AminoAcidAbstract {
  val tracks = new MeasureStructure(AMinor, Bass1, Drum1, Melody1, RhythmGuitar1)
}
