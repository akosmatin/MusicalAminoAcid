package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.AMinGMaj
import AminoAcidChords.SongStructure.Drum.Drum1
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody1

object G extends AminoAcidAbstract {
  val tracks = new MeasureStructure(AMinGMaj, Bass1, Drum1, Melody1)
}
