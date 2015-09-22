package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.AMinor
import AminoAcidChords.SongStructure.Drum.Drum1
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody1

object V extends AminoAcidAbstract {
  val tracks = new MeasureStructure(AMinor, Bass1, Drum1, Melody1)
}
