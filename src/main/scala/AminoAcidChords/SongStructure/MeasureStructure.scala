package AminoAcidChords.SongStructure

import AminoAcidChords.SongStructure.Bass.Bass
import AminoAcidChords.SongStructure.ChordRoot.Chord
import AminoAcidChords.SongStructure.Drum.Drum
import AminoAcidChords.SongStructure.Melody.Melody
import AminoAcidChords.SongStructure.RhythmGuitar.RhythmGuitar

class MeasureStructure(c:Chord,b:Bass,d:Drum,m:Melody) extends RhythmGuitar with NoteDivision{
  val bassTrack = b.bassTrack(c.rootNotes._1, 0) ++ b.bassTrack(c.rootNotes._2, division*4)
  val rhythmGuitarTrack: Seq[rhythmTuple] = rhythmGuitarTrack(c.rootNotes._1, 0) ++ rhythmGuitarTrack(c.rootNotes._2, division * 4)
  val drumTrack = d.drumTrack
  val melodyTrack = m.melodyTrack
}
