package AminoAcidComposition.SongStructure.Melody

import AminoAcidComposition.SongStructure.Note

object Melody2 extends MelodyTrait{
  val notes = Seq(
    (81, one),
    (76, two),
    (77, three),
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
