package AminoAcidChords.SongStructure.RhythmGuitar

import AminoAcidChords.SongStructure.MusicCommon

object RhythmGuitar extends MusicCommon{
  mc.changeInstrument(0, 24)
  private val trackNumber = 0
  private val velocity = 60

  private val aMinor = Seq(45, 52, 57, 60, 64)
  private val cMajor = Seq(48, 52, 55, 60, 64)
  private val fMajor = Seq(41, 48, 53, 57, 60, 65)
  private val gMajor = Seq(43, 47, 50, 55, 62, 67)

  def addTrack(rootNote:Int, measureOffset: Int, firstChord: Boolean) = {
    val chord = rootNote match {
      case 45 => aMinor
      case 48 => cMajor
      case 41 => fMajor
      case 43 => gMajor
    }

    def downStroke(start:Int, duration:Int) = {
      for(i <- Range(0, chord.length)) yield {
        if(i==chord.length-1) {
          (start + i, duration - i, chord(i), (velocity*1.1).toInt)
        }else{
          (start + i, duration - i, chord(i), velocity)
        }
      }
    }

    def upStroke(start:Int, duration:Int) = {
      for(i <- Range(0, chord.length )) yield {
        if(i==0) {
          (start + i, duration, chord(chord.length - 1 - i), (velocity*1.1).toInt)
        }else{
          (start + i, duration, chord(chord.length - 1 - i), velocity)
        }
      }
    }

    val rhythmTrack = if(firstChord){
      downStroke(one, half) ++ downStroke(two, quarter) ++ downStroke(twoAnd, eighth) ++ upStroke(twoAnd+sixteenth, sixteenth)
    } else {
      downStroke(three, half) ++ downStroke(threeAnd, dottedQuarter) ++ downStroke(four, quarter) ++ downStroke(fourAnd, eighth)
    }

    for (n<-rhythmTrack) {
      mc.addNote(trackNumber, n._3, n._4, measureOffset + n._1, n._2)
    }
  }
}
