package AminoAcidChords.SongStructure

import AminoAcidChords.SongStructure.Bass.Bass
import AminoAcidChords.SongStructure.ChordRoot.Chord
import AminoAcidChords.SongStructure.Drum.Drum
import AminoAcidChords.SongStructure.Melody.Melody

class MeasureStructure(c:Chord,b:Bass,d:Drum,m:Melody) extends MusicCommon {
  val rg = RhythmGuitar.RhythmGuitar

  def addTrack(measureOffset:Int) = {
    d.drumTrack(measureOffset)
    rg.addTrack(c.rootNotes._1, measureOffset, true)
    rg.addTrack(c.rootNotes._2, measureOffset, false)
    b.bassTrack(c.rootNotes._1, measureOffset, true)
    b.bassTrack(c.rootNotes._2, measureOffset, false)
    m.melodyTrack(measureOffset)
  }
}
