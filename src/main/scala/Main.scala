/**
 * Created by Aaron Kosmatin on 7/12/15.
 * This is the initial main that creates a midi track and converts a sequence of Amino Acids
 * into that track
 */

import java.io.File
import javax.sound.midi._

import AminoAcidChords.AminoAcidAbstract
import AminoAcidChords.SongStructure.NoteDivision

object Main extends App with NoteDivision {
  val measureLength = division*8
  val sequence = new Sequence(Sequence.PPQ, division)
  val track = sequence.createTrack()

  val synth = MidiSystem.getSynthesizer
  synth.open()

  val inst = synth.getDefaultSoundbank.getInstruments


  val Track0ToGuitar = new ShortMessage
  Track0ToGuitar.setMessage(ShortMessage.PROGRAM_CHANGE, 0, inst(24).getPatch.getProgram, inst(24).getPatch.getBank)
  track.add(new MidiEvent(Track0ToGuitar, 0))
  val Track1ToBass = new ShortMessage
  Track1ToBass.setMessage(ShortMessage.PROGRAM_CHANGE, 1, inst(33).getPatch.getProgram, inst(33).getPatch.getBank)
  track.add(new MidiEvent(Track1ToBass, 0))
  val Track2ToLead = new ShortMessage
  Track2ToLead.setMessage(ShortMessage.PROGRAM_CHANGE, 2, inst(12).getPatch.getProgram, inst(12).getPatch.getBank)
  track.add(new MidiEvent(Track2ToLead, 0))

  for {i<-Range(0,inst.length)}{
    println(i +" "+inst(i))
  }


  val testSeq = "YWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYW"

  val thyA = "MKQYLELMQKVLDEGTQKNDRTGTGTLSIFGHQMRFNLQDGFPLVTTKRCHLRSIIHELLWFLQGDTNIAYLHENNVTIWDEWADENGDLGPVYGKQWRAWPTPDGRHIDQITTVLNQLKNDPDSRRIIVSAWNVGELDKMALAPCHAFFQFYVADGKLSCQLYQRSCDVFLGLPFNIASYALLVHMMAQQCDLEVGDFVWTGGDTHLYSNHMDQTHLQLSREPRPLPKLIIKRKPESIFDYRFEDFEIEGYDPHPGIKAPVAI"

  for {i <- Range(0, thyA.length)} {
    val aminoAcid = {
      val objectName = "AminoAcidChords." + thyA.charAt(i) + "$"
      val cons = Class.forName(objectName).getDeclaredConstructors
      cons(0).setAccessible(true)
      cons(0).newInstance().asInstanceOf[AminoAcidAbstract]
    }
    for {n <- aminoAcid.tracks.rhythmGuitarTrack} {
      track.add(createNoteOnEvent(n.note, measureLength * i + n.measureOffset, 0, 60))
      track.add(createNoteOffEvent(n.note, measureLength * i + n.measureOffset + n.duration, 0))
    }
    for {n <- aminoAcid.tracks.drumTrack} {
      if (n.note == 42) {
        track.add(createNoteOnEvent(n.note, measureLength * i + n.measureOffset, 9, 60))
      } else {
        track.add(createNoteOnEvent(n.note, measureLength * i + n.measureOffset, 9, 120))
      }
      track.add(createNoteOffEvent(n.note, measureLength * i + n.measureOffset + n.duration, 9))
    }
    for {n <- aminoAcid.tracks.bassTrack} {
      track.add(createNoteOnEvent(n.note, measureLength * i + n.measureOffset, 1, 100))
      track.add(createNoteOffEvent(n.note, measureLength * i + n.measureOffset + n.duration, 1))
    }
    for {n <- aminoAcid.tracks.melodyTrack} {
      track.add(createNoteOnEvent(n.note, measureLength * i + n.measureOffset, 2, 50))
      track.add(createNoteOffEvent(n.note, measureLength * i + n.measureOffset + n.duration, 2))
    }
  }

  val outputFile = new File("/home/doccali/thyA.mid")
  MidiSystem.write(sequence, 0, outputFile)

  val sequencer = MidiSystem.getSequencer
  sequencer.open()
  sequencer.setSequence(sequence)
  val bpm: Float = 220
  sequencer.setTempoInBPM(bpm)
  sequencer.start()
  Thread.sleep(sequencer.getMicrosecondLength / 1000)
  sequencer.stop()
  sequencer.close()

  def createNoteOnEvent(nKey: Int, lTick: Long, track:Int, velocity:Int): MidiEvent = {
    createNoteEvent(ShortMessage.NOTE_ON, nKey, velocity, lTick, track)
  }

  def createNoteOffEvent(nKey: Int, lTick: Long, track:Int, velocity:Int=0): MidiEvent = {
    createNoteEvent(ShortMessage.NOTE_OFF, nKey, velocity, lTick,track)
  }

  def createNoteEvent(nCommand: Int, nKey: Int, nVelocity: Int, lTick: Long, track:Int): MidiEvent = {
    val message = new ShortMessage()
    try {
      message.setMessage(nCommand,
        track,
        nKey,
        nVelocity)
    }
    new MidiEvent(message, lTick)
  }
}
