package AminoAcidChords.SongStructure.RhythmGuitar

import AminoAcidChords.SongStructure.{NoteDivision, rhythmTuple}

trait RhythmGuitar extends NoteDivision{
  val aMinor = Seq(45, 52, 57, 60, 64)
  val cMajor = Seq(48, 52, 55, 60, 64)
  val fMajor = Seq(41, 48, 53, 57, 60, 65)
  val gMajor = Seq(43, 47, 50, 55, 62, 67)

  def rhythmGuitarTrack(rootNote:Int, offset: Int) = {
    val chord = rootNote match {
      case 45 => aMinor
      case 48 => cMajor
      case 41 => fMajor
      case 43 => gMajor
    }

    def downStroke(start:Int, stop:Int) = {
      for(i <- Range(0, chord.length - 1)) yield {
        rhythmTuple(start+i+offset, stop-i+offset, chord(i))
      }
    }

    def upStroke(start:Int, stop:Int) = {
      for(i <- Range(0, chord.length - 1)) yield {
        rhythmTuple(start+i+offset, stop-i+offset, chord(chord.length - 1 - i))
      }
    }

    downStroke(0,4*division) ++ upStroke((1.5*division).toInt,4*division) ++ downStroke(2*division,4*division) ++ upStroke((2.5*division).toInt,4*division) ++ downStroke(3*division,4*division) ++ upStroke((3.5*division).toInt, 4*division)
  }
}
