package AminoAcidChords.SongStructure.Melody

import AminoAcidChords.SongStructure.rhythmTuple

object Melody4 extends Melody{
  val notes = Seq(
    (84, one),
    (77, two),
    (76, three),
    (74,four)
  )

  def melodyTrack(measureOffset:Int) = {
    for(n<-notes) {
      mc.addNote(trackNumber,n._1,velocity,measureOffset+n._2, quarter)
    }
  }
}