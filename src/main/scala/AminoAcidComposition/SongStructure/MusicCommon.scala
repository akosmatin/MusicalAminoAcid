package AminoAcidComposition.SongStructure

import java.io.File
import javax.sound.midi._

trait MusicCommon {
  val mc = MusicCommon
  val noteDivision = 64

  val one = 0
  val oneAnd = noteDivision/2
  val two = noteDivision
  val twoAnd = 3*noteDivision/2
  val three = 2*noteDivision
  val threeAnd = 5*noteDivision/2
  val four = 3*noteDivision
  val fourAnd = 7*noteDivision/2
  val measure = 4*noteDivision

  val sixteenth = noteDivision/4
  val eighth = noteDivision/2
  val quarter = noteDivision
  val dottedQuarter = 3*noteDivision/2
  val half = 2*noteDivision
  val dottedHalf = 5*noteDivision/2
}

object MusicCommon extends MusicCommon{
  private val sequence = new Sequence(Sequence.PPQ, noteDivision)
  private val sequencer = MidiSystem.getSequencer

  val rhythmGuitarTrack = sequence.createTrack()
  val altRhythmGuitarTrack = sequence.createTrack()
  val melodyTrack = sequence.createTrack()
  val altMelodyTrack = sequence.createTrack()
  val bassTrack = sequence.createTrack()
  val altBassTrack = sequence.createTrack()
  val drumTrack = sequence.createTrack()
  val altDrumTrack = sequence.createTrack()
//  val altRhythmGuitarTrack = sequence.createTrack()
//  val altMelodyTrack = sequence.createTrack()
//  val altBassTrack = sequence.createTrack()
//  val altDrumTrack = sequence.createTrack()

  private val inst = MidiSystem.getSynthesizer.getDefaultSoundbank.getInstruments

  def changeInstrument(track:Track, trackNumber:Int, instrument:Int) = {
    addMidiEvent(track, ShortMessage.PROGRAM_CHANGE, trackNumber,  inst(instrument).getPatch.getProgram, inst(instrument).getPatch.getBank, sequencer.getTickPosition)
  }

  def muteTrack(trackIndex:Int) = {
    if(sequencer.getTrackMute(trackIndex)){
      sequencer.setTrackMute(trackIndex,false)
    } else {
      sequencer.setTrackMute(trackIndex,true)
    }
  }

  def soloTrack(trackIndex:Int) = {
    if(sequencer.getTrackSolo(trackIndex)){
      sequencer.setTrackSolo(trackIndex,false)
    } else {
      sequencer.setTrackSolo(trackIndex,true)
    }
  }

  def addNote(track:Track, trackNumber:Int, note:Int, velocity: Int, start: Int, duration:Int) = {
    addMidiEvent(track, ShortMessage.NOTE_ON, trackNumber, note, velocity, start)
    addMidiEvent(track, ShortMessage.NOTE_OFF, trackNumber, note, velocity, start+duration)
  }

  def listInstruments() = {
    inst.map(_.getName)
  }

  def writeMidi(file:String) = {
    val outputFile = new File(file)
    if(outputFile.exists()){
      outputFile.delete()
      outputFile.createNewFile()
    }
    MidiSystem.write(sequence, 1, outputFile)
  }

  def playMidi(bpm:Float) = {
    sequencer.open()
    sequencer.setSequence(sequence)
    sequencer.setTempoInBPM(bpm)
    sequencer.setTrackMute(9, false)
    sequencer.start()
  }

  def stopMidi() = {
    val location = try {
      val current = sequencer.getTickPosition
      sequencer.stop()
      sequencer.close()
      current
    }catch{
      case _ => 0
    }
    for (track <- Seq(rhythmGuitarTrack, altRhythmGuitarTrack, melodyTrack, altMelodyTrack, bassTrack, altBassTrack, drumTrack, altDrumTrack)) {
      while (track.size() != 0) {
        track.remove(track.get(0))
      }
    }
    location
  }

  def setLocation(location:Long) = {
    sequencer.setTickPosition(location)
  }

  //param1 and param2 are poorly named, they are respectively
  //note and velocity for adding notes
  //program and bank for changing instrument
  //something and something for changing tempo
  private def addMidiEvent(track: Track, midiCommand: Int, trackNumber: Int, param1: Int, param2: Int, location: Long) = {
    val message = new ShortMessage()
    try {
      message.setMessage(midiCommand,
        trackNumber,
        param1,
        param2)
    }
    track.add(new MidiEvent(message, location))
  }
}
