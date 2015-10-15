package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.CMajFMaj
import AminoAcidComposition.SongStructure.Drum.Drum2
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody2
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar2

object N extends AminoAcidAbstract{
  val tracks = new MeasureStructure(CMajFMaj, Bass1, Drum2, Melody2, RhythmGuitar2)
}
