package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.rhythmTuple

object Melody3 extends Melody{
  val notes = Seq(
    (83, one),
    (79, two),
    (74, three),
    (76,four)
  )

  def melodyTrack(measureOffset:Int) = {
    for(n<-notes) {
      mc.addNote(trackNumber,n._1,velocity,measureOffset+n._2, quarter)
    }
  }
}