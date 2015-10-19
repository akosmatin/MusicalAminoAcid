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
    for (i <- Range(0, sequence1.length)) {
      val aminoAcid = {
        val objectName = "AminoAcidComposition.AminoAcid." + sequence1.charAt(i) + "$"
        val cons = Class.forName(objectName).getDeclaredConstructors
        cons(0).setAccessible(true)
        cons(0).newInstance().asInstanceOf[AminoAcidAbstract]
      }
      aminoAcid.addTracks(measure*i)
    }

    for (i <- Range(0, sequence2.length)) {
      val aminoAcid = {
        val objectName = "AminoAcidComposition.AminoAcid." + sequence2.charAt(i) + "$"
        val cons = Class.forName(objectName).getDeclaredConstructors
        cons(0).setAccessible(true)
        cons(0).newInstance().asInstanceOf[AminoAcidAbstract]
      }
      aminoAcid.addTracks(measure * i, true)
    }
  }

  def playMidi(bpm:Int = 120) = {
    mc.playMidi(bpm)
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
}
