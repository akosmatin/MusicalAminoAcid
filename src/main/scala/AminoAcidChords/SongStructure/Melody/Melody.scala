package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.MusicCommon

trait Melody extends MusicCommon{
  mc.changeInstrument(2, 42)
  val trackNumber = 2
  val velocity = 50

  def melodyTrack(measureOffset:Int):Unit
}
