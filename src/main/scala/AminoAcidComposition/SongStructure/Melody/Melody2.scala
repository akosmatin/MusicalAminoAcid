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
        Note(mc.melodyTrack, trackNumber, n._1, velocity, n._2, quarter)
      }else{
        Note(mc.altMelodyTrack, altTrackNumber, n._1, velocity + 5, n._2, quarter)
      }
    }
  }
}
