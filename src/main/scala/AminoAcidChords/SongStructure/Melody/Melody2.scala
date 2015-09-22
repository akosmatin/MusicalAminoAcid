package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.rhythmTuple

object Melody2 extends Melody{
  val notes = Seq(
    (81, one),
    (76, two),
    (77, three),
    (74,four)
  )

  def melodyTrack(measureOffset:Int) = {
    for(n<-notes) {
      mc.addNote(trackNumber,n._1,velocity,measureOffset+n._2, quarter)
    }
  }
}
