package AminoAcidComposition.SongStructure

import AminoAcidComposition.SongStructure.Bass.BassTrait
import AminoAcidComposition.SongStructure.ChordRoot.Chord
import AminoAcidComposition.SongStructure.Drum.DrumTrait
import AminoAcidComposition.SongStructure.Melody.MelodyTrait
import AminoAcidComposition.SongStructure.RhythmGuitar.RhythmGuitarTrait

class MeasureStructure(c:Chord,b:BassTrait,d:DrumTrait,m:MelodyTrait,rg:RhythmGuitarTrait) extends MusicCommon {
  def addTrack(measureOffset:Int, alternateTrack:Boolean = false) = {
    for{n <-
          d.getTrack(c.rootNotes._1, alternateTrack) ++
          rg.getTrack(c.rootNotes._1, alternateTrack, firstChord = true) ++
          rg.getTrack(c.rootNotes._2, alternateTrack, firstChord = false) ++
          b.getTrack(c.rootNotes._1, alternateTrack, firstChord = true) ++
          b.getTrack(c.rootNotes._2, alternateTrack, firstChord = false) ++
          m.getTrack(c.rootNotes._1, alternateTrack)
    } {
      mc.addNote(n.track, n.note, n.velocity, measureOffset + n.start, n.duration)
    }
  }
}
