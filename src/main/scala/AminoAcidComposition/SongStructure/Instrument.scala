package AminoAcidComposition.SongStructure

import javax.sound.midi.Track

case class Note(track:Track, trackNumber:Int, note:Int, velocity:Int, start:Int, duration:Int)

trait Instrument {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true):Seq[Note]
}
