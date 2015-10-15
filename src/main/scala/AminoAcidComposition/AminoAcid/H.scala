package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.GMajor
import AminoAcidComposition.SongStructure.Drum.Drum3
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody3
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object H extends AminoAcidAbstract {
  val tracks = new MeasureStructure(GMajor, Bass1, Drum3, Melody3, RhythmGuitar1)
}
