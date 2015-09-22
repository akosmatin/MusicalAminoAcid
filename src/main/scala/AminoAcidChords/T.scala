package AminoAcidChords

import AminoAcidChords.SongStructure.Bass.Bass1
import AminoAcidChords.SongStructure.ChordRoot.CMajor
import AminoAcidChords.SongStructure.Drum.Drum2
import AminoAcidChords.SongStructure.MeasureStructure
import AminoAcidChords.SongStructure.Melody.Melody2

object T extends AminoAcidAbstract {
  val tracks = new MeasureStructure(CMajor, Bass1, Drum2, Melody2)
}
