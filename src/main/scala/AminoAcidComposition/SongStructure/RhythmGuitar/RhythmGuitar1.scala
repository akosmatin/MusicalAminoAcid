package AminoAcidComposition.SongStructure.RhythmGuitar

import AminoAcidComposition.SongStructure.Note

object RhythmGuitar1 extends RhythmGuitarTrait {
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
        downStroke(one, measure, velocity) ++ downStroke(two, dottedHalf, (velocity * 1.2).toInt)
      } else {
        downStroke(three, half, velocity) ++ upStroke(three + sixteenth, dottedQuarter + sixteenth, velocity) ++ downStroke(threeAnd, dottedQuarter, velocity) ++ downStroke(four, quarter, (velocity * 1.2).toInt)
      }

      for (n <- rhythmTrack) yield {
        Note(rhythmGuitarTrackNumber, n._3, n._4, n._1, n._2)
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
            (two, quarter, n)
          )
        )
      } else {
        chord.flatMap(n =>
          Seq(
            (three, sixteenth, n),
            (three + sixteenth, sixteenth, n),
            (threeAnd, eighth, n),
            (four, quarter, n)
          )
        )
      }
      notes.map(n=>Note(altRhythmGuitarTrackNumber,n._3,altVelocity,n._1,n._2))
    }
  }
}
