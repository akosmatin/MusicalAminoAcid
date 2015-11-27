package AminoAcidComposition.SongStructure.RhythmGuitar

import AminoAcidComposition.SongStructure.{Instrument, MusicCommon}

trait RhythmGuitarTrait extends Instrument with MusicCommon {
  protected val trackNumber = 0
  protected val altTrackNumber = 1
  protected val velocity = 70
  protected val altVelocity = 70

  protected val aMinor = Seq(45, 52, 57, 60, 64)
  protected val cMajor = Seq(48, 52, 55, 60, 64)
  protected val fMajor = Seq(41, 48, 53, 57, 60, 65)
  protected val gMajor = Seq(43, 47, 50, 55, 62, 67)

  protected def downStrokeCurry(chord: Seq[Int])(start: Int, duration: Int, velocity: Int) = {
    for (i <- chord.indices) yield {
      if (i == chord.length - 1) {
//        (start + i, duration - i, chord(i), (velocity * 1.1).toInt)
        (start, duration, chord(i), (velocity * 1.1).toInt)
      } else {
        (start, duration, chord(i), velocity)
//        (start + i, duration - i, chord(i), velocity)
      }
    }
  }

  protected def upStrokeCurry(chord: Seq[Int])(start: Int, duration: Int, velocity: Int) = {
    for (i <- chord.indices) yield {
      if (i == 0) {
        //this is wrong, duration should be changed too
//        (start + i, duration, chord(chord.length - 1 - i), (velocity * 1.1).toInt)
        (start, duration, chord(chord.length - 1 - i), (velocity * 1.1).toInt)
      } else {

        (start, duration, chord(chord.length - 1 - i), velocity)
      }
    }
  }
}
