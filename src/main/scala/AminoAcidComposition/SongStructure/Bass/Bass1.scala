package AminoAcidComposition.SongStructure.Bass

import AminoAcidComposition.SongStructure.Note

object Bass1 extends BassTrait {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true) = {
    val notes = if(firstChord) {
      Seq(
        (rootNote-12,one,eighth),
        (rootNote-12,oneAnd,eighth),
        (rootNote-12,two,quarter)
      )
    } else {
      Seq(
        (rootNote-12,three,eighth),
        (rootNote-12,threeAnd,eighth),
        (rootNote-12,four,quarter)
      )
    }

    if(!altTrack){
      notes.map(n=>Note(bassTrackNumber,n._1,velocity,n._2,n._3))
    } else {
      notes.map(n=>Note(altBassTrackNumber,n._1,velocity,n._2,n._3))
    }

  }
}
