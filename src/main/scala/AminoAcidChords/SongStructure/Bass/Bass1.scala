package AminoAcidChords.SongStructure.Bass

object Bass1 extends Bass {
  def bassTrack(rootNote:Int, measureOffset:Int, firstChord:Boolean) = {
    val notes = if(firstChord) {
      Seq(
        (rootNote, one),
        (rootNote, two)
      )
    } else {
      Seq(
        (rootNote, three),
        (rootNote, four)
      )
    }

    for(n<-notes){
      mc.addNote(trackNumber,n._1-12,velocity,measureOffset+n._2,quarter)
    }
  }
}
