package AminoAcidComposition.AminoAcid

import AminoAcidComposition.AminoAcid.AminoAcidAbstract
import AminoAcidComposition.SongStructure.Bass.Bass2
import AminoAcidComposition.SongStructure.ChordRoot.AMinor
import AminoAcidComposition.SongStructure.Drum.Drum3
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody1
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object L extends AminoAcidAbstract {
  val tracks = new MeasureStructure(AMinor, Bass2, Drum3, Melody1, RhythmGuitar1)
}
