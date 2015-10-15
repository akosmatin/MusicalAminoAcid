package AminoAcidComposition.SongStructure.Melody

import AminoAcidComposition.SongStructure.Note

object Melody3 extends MelodyTrait{
  val notes = Seq(
    (83, one),
    (79, two),
    (74, three),
    (76,four)
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