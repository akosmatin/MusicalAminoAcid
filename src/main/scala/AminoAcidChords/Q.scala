package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.CMajFMaj
import AminoAcidChords.SongStructure.Drum.Drum3
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody2

object Q extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajFMaj, Bass1, Drum3, Melody2)
}
