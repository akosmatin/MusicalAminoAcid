package AminoAcidComposition.SongStructure.Drum

import AminoAcidComposition.SongStructure.Note

object Drum1 extends DrumTrait {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true) = {
    val track = if(altTrack){
      mc.altDrumTrack
    }else{
      mc.drumTrack
    }

    val notes = if (!altTrack) {
      Seq(
        (35, 120, one, quarter)
      )
    } else {
      Seq(
        (35, 120, oneAnd, eighth)
      )
    }
    notes.map(n => Note(track, 9, n._1, n._2, n._3, n._4))
  }
}
