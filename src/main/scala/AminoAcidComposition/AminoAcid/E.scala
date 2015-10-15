package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.CMajGMaj
import AminoAcidComposition.SongStructure.Drum.Drum3
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody4
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar2

object E extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajGMaj, Bass1, Drum3, Melody4, RhythmGuitar2)
}
