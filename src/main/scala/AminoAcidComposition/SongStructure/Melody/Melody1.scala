package AminoAcidComposition.SongStructure.Melody

import AminoAcidComposition.SongStructure.Note

object Melody1 extends MelodyTrait{
  val notes = Seq(
    (72, one),
    (74, two),
    (76, three),
    (79,four)
  )

  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true) = {
    for(n<-notes) yield {
      if(!altTrack) {
        Note(melodyTrackNumber, n._1, velocity, n._2, quarter)
      }else{
        Note(altMelodyTrackNumber, n._1, velocity, n._2, quarter)
      }
    }
  }
}
