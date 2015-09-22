package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.CMajFMaj
import AminoAcidChords.SongStructure.Drum.Drum1
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody2

object S extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajFMaj, Bass1, Drum1, Melody2)
}
