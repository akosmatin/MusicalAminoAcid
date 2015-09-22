package AminoAcidChords.SongStructure.Bass

import AminoAcidChords.SongStructure.MusicCommon

trait Bass extends MusicCommon{
  mc.changeInstrument(1, 33)
  val trackNumber = 1
  val velocity = 100
  def bassTrack(rootNote:Int, measureOffset:Int, firstChord: Boolean): Unit
}
