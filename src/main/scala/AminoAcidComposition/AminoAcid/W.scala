package AminoAcidComposition.AminoAcid

import AminoAcidComposition.AminoAcid.AminoAcidAbstract
import AminoAcidComposition.SongStructure.Bass.Bass2
import AminoAcidComposition.SongStructure.ChordRoot.GMajor
import AminoAcidComposition.SongStructure.Drum.Drum3
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody2
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar1

object W extends AminoAcidAbstract {
  val tracks = new MeasureStructure(GMajor, Bass2, Drum3, Melody2, RhythmGuitar1)
}
