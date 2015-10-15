package AminoAcidComposition.AminoAcid

import AminoAcidComposition.AminoAcid.AminoAcidAbstract
import AminoAcidComposition.SongStructure.Bass.Bass1
import AminoAcidComposition.SongStructure.ChordRoot.CMajGMaj
import AminoAcidComposition.SongStructure.Drum.Drum2
import AminoAcidComposition.SongStructure.MeasureStructure
import AminoAcidComposition.SongStructure.Melody.Melody4
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitar2

object D extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajGMaj, Bass1, Drum2, Melody4, RhythmGuitar2)
}
