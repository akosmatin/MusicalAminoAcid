package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.CMajGMaj
import AminoAcidChords.SongStructure.Drum.Drum3
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody3

object R extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajGMaj, Bass1, Drum3, Melody3)
}
