package AminoAcidComposition.SongStructure.RhythmGuitar

import AminoAcidComposition.SongStructure.Note

object RhythmGuitar1 extends RhythmGuitarTrait {
  def getTrack(rootNote:Int, altTrack:Boolean = false, firstChord:Boolean = true) = {
    if (!altTrack) {
      val chord = rootNote match {
        case 45 => aMinorGuitar
        case 48 => cMajorGuitar
        case 41 => fMajorGuitar
        case 43 => gMajorGuitar
      }

      def downStroke = downStrokeCurry(chord) _
      def upStroke = upStrokeCurry(chord) _

      val rhythmTrack = if (firstChord) {
        downStroke(one, measure, velocity) ++ downStroke(two, dottedHalf, (velocity * 1.2).toInt)
      } else {
        downStroke(three, half, velocity) ++ upStroke(three + sixteenth, dottedQuarter + sixteenth, velocity) ++ downStroke(threeAnd, dottedQuarter, velocity) ++ downStroke(four, quarter, (velocity * 1.2).toInt)
      }

      for (n <- rhythmTrack) yield {
        Note(mc.rhythmGuitarTrack, trackNumber, n._3, n._4, n._1, n._2)
      }
    } else {
      val chord = rootNote match {
        case 45 => aMinorPiano
        case 48 => cMajorPiano
        case 41 => fMajorPiano
        case 43 => gMajorPiano
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
      notes.map(n=>Note(mc.altRhythmGuitarTrack, altTrackNumber,n._3,altVelocity,n._1,n._2))
    }
  }
}
