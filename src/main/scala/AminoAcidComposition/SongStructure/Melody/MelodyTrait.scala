package AminoAcidComposition.SongStructure.Melody

import AminoAcidComposition.SongStructure.{Instrument, MusicCommon}

trait MelodyTrait extends Instrument with MusicCommon{
  val trackNumber = mc.melodyTrackIndex
  val altTrackNumber = mc.altMelodyTrackIndex
  val velocity = 50
}
