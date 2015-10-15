package AminoAcidComposition.SongStructure.Drum

import AminoAcidComposition.SongStructure.Note

object Drum2 extends DrumTrait {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true) = {
    val notes = if (!altTrack) {
      Seq(
        (35, 120, one, quarter),
        (35, 120, three, quarter)
      )
    } else {
      Seq(
        (35, 120, oneAnd, eighth),
        (35, 120, threeAnd, eighth)
      )
    }
    notes.map(n => Note(trackNumber, n._1, n._2, n._3, n._4))
  }
}
