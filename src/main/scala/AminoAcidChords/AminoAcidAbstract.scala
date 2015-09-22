package AminoAcidChords

import AminoAcidChords.SongStructure.MeasureStructure

trait AminoAcidAbstract {
  val tracks: MeasureStructure
  def addTracks(measureOffset:Int) = {
    tracks.addTrack(measureOffset)
  }
}
