package AminoAcidComposition.SongStructure.Bass

import AminoAcidComposition.SongStructure.{Instrument, MusicCommon}

trait BassTrait extends Instrument with MusicCommon {
  mc.changeInstrument(1, 33)
  val trackNumber = 1
  val velocity = 100
}
