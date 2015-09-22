package AminoAcidChords.SongStructure

import java.io.File
import javax.sound.midi.{MidiSystem, MidiEvent, ShortMessage, Sequence}

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
}

object MusicCommon extends MusicCommon{
  private val sequence = new Sequence(Sequence.PPQ, noteDivision)
  private val track = sequence.createTrack()

  private val inst = MidiSystem.getSynthesizer.getDefaultSoundbank.getInstruments

  def changeInstrument(trackNumber:Int, instrument:Int) = {
    addMidiEvent(ShortMessage.PROGRAM_CHANGE, trackNumber,  inst(instrument).getPatch.getProgram, inst(instrument).getPatch.getBank, 0)
  }

  def addNote(tracknumber:Int, note:Int, velocity: Int, start: Int, duration:Int) = {
    addMidiEvent(ShortMessage.NOTE_ON, tracknumber, note, velocity, start)
    addMidiEvent(ShortMessage.NOTE_OFF, tracknumber, note, velocity, start+duration)
  }

  def listInstruments = {
    for {i<-Range(0,inst.length)}{
      println(i +" "+inst(i))
    }
  }

  def writeMidi(file:String) = {
    val outputFile = new File(file)
    MidiSystem.write(sequence, 0, outputFile)
  }

  def playMidi(bpm:Float) = {
    val sequencer = MidiSystem.getSequencer
    sequencer.open()
    sequencer.setSequence(sequence)
    sequencer.setTempoInBPM(bpm)
    sequencer.setTrackMute(9, false)
    sequencer.start()
    Thread.sleep(sequencer.getMicrosecondLength / 1000)
    sequencer.stop()
    sequencer.close()
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
