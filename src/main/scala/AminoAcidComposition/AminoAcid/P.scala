package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.AMinGMaj
import AminoAcidComposition.SongStructure.Drum.Drum2
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody1
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar2

object P extends AminoAcidAbstract {
  val tracks = new MeasureStructure(AMinGMaj, Bass1, Drum2, Melody1, RhythmGuitar2)
}
