package AminoAcidComposition.SongStructure.Melody

import AminoAcidComposition.SongStructure.{Instrument, MusicCommon}

trait MelodyTrait extends Instrument with MusicCommon{
  val trackNumber = 2
  val altTrackNumber = 3
  val velocity = 50
}
