package AminoAcidChords.ChordStructure

trait ChordBuilder extends Rhythm {
  val scale = Seq(
    55, 57, 59, 60, 62, 64, 66,
    67, 69, 71, 72, 74, 76, 78,
    79)
  val root: Int

  implicit def note2root(n: Char): Int = {
    val noteMap = Map(
      'g' -> 0,
      'a' -> 1,
      'b' -> 2,
      'c' -> 3,
      'd' -> 4,
      'e' -> 5,
      'f' -> 6)
    noteMap(n)
  }

  def notes: Seq[Int]

  def voiceNotes: Seq[Int]
}
