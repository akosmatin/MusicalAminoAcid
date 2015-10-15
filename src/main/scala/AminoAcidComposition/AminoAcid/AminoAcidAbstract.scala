package AminoAcidComposition.AminoAcid

import AminoAcidComposition.SongStructure.MeasureStructure

abstract class AminoAcidAbstract {
  val tracks: MeasureStructure
  def addTracks(measureOffset:Int, alternativeTrack:Boolean = false) = {
    tracks.addTrack(measureOffset, alternativeTrack)
  }
}
