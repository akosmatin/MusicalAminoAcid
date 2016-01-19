package AminoAcidComposition.SongStructure.Drum

import AminoAcidComposition.SongStructure.Note

object Drum3 extends DrumTrait {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true) = {
    val track = if(altTrack){
      mc.altDrumTrack
    }else{
      mc.drumTrack
    }
    val notes = if (!altTrack) {
      Seq(
        (35, 120, one, quarter),
        (35, 120, two, quarter),
        (35, 120, three, quarter),
        (35, 120, four, quarter)
      )
    } else {
      Seq(
        (35, 120, oneAnd, eighth),
        (35, 120, twoAnd, eighth),
        (35, 120, threeAnd, eighth),
        (35, 120, fourAnd, eighth)
      )
    }
    notes.map(n => Note(track, mc.drumTrackIndex, n._1, n._2, n._3, n._4))
  }
}