package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.GMajor
import AminoAcidChords.SongStructure.Drum.Drum3
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody1

object F extends AminoAcidAbstract {
  val tracks = new MeasureStructure(GMajor, Bass1, Drum3, Melody1)
}
