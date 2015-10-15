package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.GMajor
import AminoAcidComposition.SongStructure.Drum.Drum3
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody1
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object F extends AminoAcidAbstract {
  val tracks = new MeasureStructure(GMajor, Bass1, Drum3, Melody1, RhythmGuitar1)
}
