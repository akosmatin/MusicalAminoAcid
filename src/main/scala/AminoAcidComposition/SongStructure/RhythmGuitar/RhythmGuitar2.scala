package AminoAcidComposition.SongStructure.RhythmGuitar

import AminoAcidComposition.SongStructure.Note
object RhythmGuitar2 extends RhythmGuitarTrait {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true) = {
    if (!altTrack) {
      val chord = rootNote match {
        case 45 => aMinor
        case 48 => cMajor
        case 41 => fMajor
        case 43 => gMajor
      }

      def downStroke = downStrokeCurry(chord) _
      def upStroke = upStrokeCurry(chord) _

      val rhythmTrack = if (firstChord) {
        downStroke(one, half, velocity) ++ downStroke(two, quarter, velocity) ++ downStroke(twoAnd, eighth, velocity) ++ upStroke(twoAnd + sixteenth, sixteenth, velocity)
      } else {
        downStroke(three, half, velocity) ++ downStroke(threeAnd, dottedQuarter, velocity) ++ downStroke(four, quarter, velocity) ++ downStroke(fourAnd, eighth, velocity)
      }

      for (n <- rhythmTrack) yield {
        Note(mc.rhythmGuitarTrack, trackNumber, n._3, n._4, n._1, n._2)
      }
    } else {
      val chord = rootNote match {
        case 45 => Seq(rootNote, rootNote + 3, rootNote + 7)
        case _ => Seq(rootNote, rootNote + 4, rootNote + 7)
      }

      val notes = if (firstChord) {
        chord.flatMap(n =>
          Seq(
            (one, quarter, n),
            (two, eighth, n),
            (twoAnd,sixteenth, n),
            (twoAnd+sixteenth,sixteenth, n)
          )
        )
      } else {
        chord.flatMap(n =>
          Seq(
            (three, eighth, n),
            (threeAnd,eighth, n),
            (four, eighth, n),
            (fourAnd,eighth,n)
          )
        )
      }
      notes.map(n=>Note(mc.altRhythmGuitarTrack, altTrackNumber,n._3,altVelocity,n._1,n._2))
    }
  }
}
