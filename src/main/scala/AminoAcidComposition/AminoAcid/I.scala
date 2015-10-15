package AminoAcidComposition.AminoAcid

import AminoAcidComposition.AminoAcid.AminoAcidAbstract
import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.AMinor
import AminoAcidComposition.SongStructure.Drum.Drum3
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody1
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object I extends AminoAcidAbstract {
  val tracks = new MeasureStructure(AMinor, Bass1, Drum3, Melody1, RhythmGuitar1)
}
