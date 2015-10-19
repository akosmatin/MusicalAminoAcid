package AminoAcidComposition.SongStructure.Bass

import AminoAcidComposition.SongStructure.{Instrument, MusicCommon}

trait BassTrait extends Instrument with MusicCommon {
  val trackNumber = 4
  val altTrackNumber = 5
  val velocity = 100
}
