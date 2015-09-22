package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.CMajGMaj
import AminoAcidChords.SongStructure.Drum.Drum2
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody4

object D extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajGMaj, Bass1, Drum2, Melody4)
}
