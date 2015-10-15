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

  val rhythmGuitarTrackNumber = 0
  val altRhythmGuitarTrackNumber = 3
  val melodyTrackNumber = 2
  val altMelodyTrackNumber = 4
  val bassTrackNumber = 1
  val altBassTrackNumber = 5
}

object MusicCommon extends MusicCommon{
  private val sequence = new Sequence(Sequence.PPQ, noteDivision)
  private val track: Track = sequence.createTrack()
  private val sequencer = MidiSystem.getSequencer

  private val inst = MidiSystem.getSynthesizer.getDefaultSoundbank.getInstruments

  def changeInstrument(trackNumber:Int, instrument:Int) = {
    addMidiEvent(ShortMessage.PROGRAM_CHANGE, trackNumber,  inst(instrument).getPatch.getProgram, inst(instrument).getPatch.getBank, sequencer.getTickPosition)
  }

  def muteTrack(trackNumber:Int) = {
    if(sequencer.getTrackMute(trackNumber)){
      sequencer.setTrackMute(trackNumber,false)
    } else {
      sequencer.setTrackMute(trackNumber,true)
    }
  }

  def soloTrack(trackNumber:Int) = {
    if(sequencer.getTrackSolo(trackNumber)){
      sequencer.setTrackSolo(trackNumber,false)
    } else {
      sequencer.setTrackSolo(trackNumber,true)
    }
  }

  def addNote(trackNumber:Int, note:Int, velocity: Int, start: Int, duration:Int) = {
    addMidiEvent(ShortMessage.NOTE_ON, trackNumber, note, velocity, start)
    addMidiEvent(ShortMessage.NOTE_OFF, trackNumber, note, velocity, start+duration)
  }

  def listInstruments() = {
    inst.map(_.getName)
  }

  def writeMidi(file:String) = {
    val outputFile = new File(file)
    MidiSystem.write(sequence, 0, outputFile)
  }

  def playMidi(bpm:Float) = {
    sequencer.open()
    sequencer.setSequence(sequence)
    sequencer.setTempoInBPM(bpm)
    sequencer.setTrackMute(9, false)
    sequencer.start()

  }

  def stopMidi() = {
    sequencer.stop()
    sequencer.close()
    while(track.size()!=0){
      track.remove(track.get(0))
    }
  }

  //param1 and param2 are poorly named, they are respectively
  //note and velocity for adding notes
  //program and bank for changing instrument
  //something and something for changing tempo
  private def addMidiEvent(midiCommand: Int, trackNumber: Int, param1: Int, param2: Int, location: Long) = {
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
