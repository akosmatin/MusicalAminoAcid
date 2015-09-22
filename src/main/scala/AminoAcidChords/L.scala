package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass2
import AminoAcidChords.SongStructure.ChordRoot.AMinor
import AminoAcidChords.SongStructure.Drum.Drum3
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody1

object L extends AminoAcidAbstract {
  val tracks = new MeasureStructure(AMinor, Bass2, Drum3, Melody1)
}
