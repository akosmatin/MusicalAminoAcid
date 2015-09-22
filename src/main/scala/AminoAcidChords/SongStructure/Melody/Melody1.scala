package AminoAcidChords.SongStructure.Melody

object Melody1 extends Melody{
  val notes = Seq(
    (72, one),
    (74, two),
    (76, three),
    (79,four)
  )

  def melodyTrack(measureOffset:Int) = {
    for(n<-notes) {
      mc.addNote(trackNumber,n._1,velocity,measureOffset+n._2, quarter)
    }
  }
}
