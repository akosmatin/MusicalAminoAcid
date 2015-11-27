package AminoAcidComposition

/**
 * Created by Aaron Kosmatin on 7/12/15.
 * This is the initial main that creates a midi track and converts a sequence of Amino Acids
 * into that track
 */

import javax.sound.midi.Track

import AminoAcidComposition.AminoAcid.AminoAcidAbstract
import AminoAcidComposition.SongStructure.MusicCommon

object MidiInterface extends MusicCommon {
//  val testSeq = "YWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYW"

//  val thyA = "MKQYLELMQKVLDEGTQKNDRTGTGTLSIFGHQMRFNLQDGFPLVTTKRCHLRSIIHELLWFLQGDTNIAYLHENNVTIWDEWADENGDLGPVYGKQWRAWPTPDGRHIDQITTVLNQLKNDPDSRRIIVSAWNVGELDKMALAPCHAFFQFYVADGKLSCQLYQRSCDVFLGLPFNIASYALLVHMMAQQCDLEVGDFVWTGGDTHLYSNHMDQTHLQLSREPRPLPKLIIKRKPESIFDYRFEDFEIEGYDPHPGIKAPVAI"
//  val betaGlobin =  "MVHLTPEEKSAVTALWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH"
//  val betaGlobin2 = "MVHLTPVEVGGEALGWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH"

  val rhythmGuitarTrackIndex = 0
  val altRhythmGuitarTrackIndex = 1
  val melodyTrackIndex = 2
  val altMelodyTrackIndex = 3
  val bassTrackIndex = 4
  val altBassTrackIndex = 5
  val drumTrackIndex = 6
  val altDrumTrackIndex = 7

  val rhythmGuitarTrack = mc.rhythmGuitarTrack
  val altRhythmGuitarTrack = mc.altRhythmGuitarTrack
  val melodyTrack = mc.melodyTrack
  val altMelodyTrack = mc.altMelodyTrack
  val bassTrack = mc.bassTrack
  val altBassTrack = mc.altBassTrack
  val drumTrack = mc.drumTrack
  val altDrumTrack = mc.altDrumTrack

  def createMidi(sequence1:String, sequence2:String) = {
    if (!sequence1.isEmpty) {
      _createMidi(sequence1)
    }
    if (!sequence2.isEmpty) {
      _createMidi(sequence2, true)
    }

    def _createMidi(seq:String, alt:Boolean = false) = {
      for (i <- seq.indices) {
        val aminoAcid = {
          val objectName = "AminoAcidComposition.AminoAcid." + seq.charAt(i) + "$"
          val cons = Class.forName(objectName).getDeclaredConstructors
          cons(0).setAccessible(true)
          cons(0).newInstance().asInstanceOf[AminoAcidAbstract]
        }
        aminoAcid.addTracks(measure * i, alt)
      }
    }
  }

  def playMidi(bpm:Int = 120) = {
    mc.playMidi(bpm)
  }

  def setLocation(location:Long) = {
    mc.setLocation(location)
  }

  def stopMidi() = {
    mc.stopMidi()
  }

  def listInstruments() = {
    mc.listInstruments()
  }

  def setInstrument(track:Track, trackNumber:Int, instrument:Int) = {
    mc.changeInstrument(track, trackNumber, instrument)
  }

  def muteTrack(trackIndex:Int) = {
    mc.muteTrack(trackIndex)
  }

  def soloTrack(trackIndex:Int) = {
    mc.soloTrack(trackIndex)
  }

  def writeMidi(filename:String) = {
    mc.writeMidi(filename)
  }
}
