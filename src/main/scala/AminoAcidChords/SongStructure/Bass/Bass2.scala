package AminoAcidChords.SongStructure.Bass

import AminoAcidChords.SongStructure.{MusicCommon, rhythmTuple}

object Bass2 extends Bass with MusicCommon{
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
      mc.addNote(trackNumber,n._1-5,velocity,measureOffset+n._2,quarter)
    }
  }
}
