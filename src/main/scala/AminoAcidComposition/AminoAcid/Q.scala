package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.CMajFMaj
import AminoAcidComposition.SongStructure.Drum.Drum3
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody2
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar2

object Q extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajFMaj, Bass1, Drum3, Melody2, RhythmGuitar2)
}
