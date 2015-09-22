package AminoAcidChords.SongStructure.Drum

import AminoAcidChords.SongStructure.MusicCommon

trait Drum extends MusicCommon{
  val trackNumber = 9
  def drumTrack(measureOffset:Int): Unit
}
