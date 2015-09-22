package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.FMajor
import AminoAcidChords.SongStructure.Drum.Drum1
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody2

object C extends AminoAcidAbstract {
  val tracks = new MeasureStructure(FMajor, Bass1, Drum1, Melody2)
}
