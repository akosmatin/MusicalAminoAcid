package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass2
import AminoAcidChords.SongStructure.ChordRoot.GMajor
import AminoAcidChords.SongStructure.Drum.Drum3
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody2

object W extends AminoAcidAbstract {
  val tracks = new MeasureStructure(GMajor, Bass2, Drum3, Melody2)
}
