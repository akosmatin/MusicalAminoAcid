package AminoAcidComposition.SongStructure.Melody

import AminoAcidComposition.SongStructure.Note

object Melody4 extends MelodyTrait{
  val notes = Seq(
    (84, one),
    (77, two),
    (76, three),
    (74,four)
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