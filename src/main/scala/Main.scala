/**
 * Created by doccali on 7/12/15.
 */

import java.io.File
import javax.sound.midi._

import AminoAcidChords.ChordStructure.Chord


object Main extends App {
  val measureLength = 3

  val sequence = new Sequence(Sequence.PPQ, 1)
  val track = sequence.createTrack()

  val testSeq = Seq('A','C','D','E','F','G','H','I','K','L','M','N','P','Q','R','S','T','V','W','Y')

  val thyA = "MKQYLELMQKVLDEGTQKNDRTGTGTLSIFGHQMRFNLQDGFPLVTTKRCHLRSIIHELLWFLQGDTNIAYLHENNVTIWDEWADENGDLGPVYGKQWRAWPTPDGRHIDQITTVLNQLKNDPDSRRIIVSAWNVGELDKMALAPCHAFFQFYVADGKLSCQLYQRSCDVFLGLPFNIASYALLVHMMAQQCDLEVGDFVWTGGDTHLYSNHMDQTHLQLSREPRPLPKLIIKRKPESIFDYRFEDFEIEGYDPHPGIKAPVAI"

  for{i <- Range(0,thyA.length)} {
    val aminoAcid = {
      val objectName = "AminoAcidChords." + thyA.charAt(i) + "$"
      val cons = Class.forName(objectName).getDeclaredConstructors();
      cons(0).setAccessible(true);
      cons(0).newInstance().asInstanceOf[Chord]
    }
    for {n<-aminoAcid.notes
          r<-aminoAcid.rhythm}{
      track.add(createNoteOnEvent(n, measureLength*i+r.measureOffset+1))
      track.add(createNoteOffEvent(n, measureLength*i+r.measureOffset+r.duaration+1))
    }
    for {n<-aminoAcid.voiceNotes
         r<-aminoAcid.voiceRhythm}{
      track.add(createNoteOnEvent(n, measureLength*i+r.measureOffset+1))
      track.add(createNoteOffEvent(n, measureLength*i+r.measureOffset+r.duaration+1))
    }
    for{r<-aminoAcid.baseRhythm} {
      track.add(createNoteOnEvent(aminoAcid.notes(0)-12, measureLength*i+r.measureOffset+1))
      track.add(createNoteOffEvent(aminoAcid.notes(0)-12, measureLength*i+r.measureOffset+r.duaration+1))
    }
  }

  val outputFile = new File("/home/doccali/thyA.mid")
  MidiSystem.write(sequence, 0 , outputFile)

  val sequencer = MidiSystem.getSequencer();
  sequencer.open();
  sequencer.setSequence(sequence)
  val bpm:Float = 140
  sequencer.setTempoInBPM(bpm)
  sequencer.start()
  Thread.sleep(sequencer.getMicrosecondLength/1000)
  sequencer.stop()
  sequencer.close()

  def createNoteOnEvent(nKey:Int, lTick:Long):MidiEvent = {
    return createNoteEvent(ShortMessage.NOTE_ON,nKey,64,lTick)
  }

  def createNoteOffEvent(nKey:Int, lTick:Long):MidiEvent = {
    return createNoteEvent(ShortMessage.NOTE_OFF, nKey, 0, lTick)
  }

  def createNoteEvent(nCommand:Int,nKey:Int,nVelocity:Int,lTick:Long):MidiEvent = {
    val message = new ShortMessage()
    try{
      message.setMessage(nCommand,
        0,
        nKey,
        nVelocity)
    }
    return new MidiEvent(message, lTick)
  }
}
