package AminoAcidComposition.SongStructure

case class Note(track:Int, note:Int, velocity:Int, start:Int, duration:Int)

trait Instrument {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true):Seq[Note]
}
