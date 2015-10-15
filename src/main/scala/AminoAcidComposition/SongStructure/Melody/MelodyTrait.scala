package AminoAcidComposition.SongStructure.Melody

import AminoAcidComposition.SongStructure.{Instrument, MusicCommon}

trait MelodyTrait extends Instrument with MusicCommon{
  mc.changeInstrument(2, 18)
  val trackNumber = 2
  val altTrackNumber=4
  val velocity = 50
}
