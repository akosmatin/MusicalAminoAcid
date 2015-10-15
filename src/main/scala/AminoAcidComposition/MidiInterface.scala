package AminoAcidComposition

/**
 * Created by Aaron Kosmatin on 7/12/15.
 * This is the initial main that creates a midi track and converts a sequence of Amino Acids
 * into that track
 */

import AminoAcidComposition.AminoAcid.AminoAcidAbstract
import AminoAcidComposition.SongStructure.MusicCommon

object MidiInterface extends MusicCommon {
  val testSeq = "YWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYW"

  val thyA = "MKQYLELMQKVLDEGTQKNDRTGTGTLSIFGHQMRFNLQDGFPLVTTKRCHLRSIIHELLWFLQGDTNIAYLHENNVTIWDEWADENGDLGPVYGKQWRAWPTPDGRHIDQITTVLNQLKNDPDSRRIIVSAWNVGELDKMALAPCHAFFQFYVADGKLSCQLYQRSCDVFLGLPFNIASYALLVHMMAQQCDLEVGDFVWTGGDTHLYSNHMDQTHLQLSREPRPLPKLIIKRKPESIFDYRFEDFEIEGYDPHPGIKAPVAI"
  val betaGlobin =  "MVHLTPEEKSAVTALWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH"
  val betaGlobin2 = "MVHLTPVEVGGEALGWGKVNVDEVGGEALGRLLVVYPWTQRFFESFGDLSTPDAVMGNPKVKAHGKKVLGAFSDGLAHLDNLKGTFATLSELHCDKLHVDPENFRLLGNVLVCVLAHHFGKEFTPPVQAAYQKVVAGVANALAHKYH"

  override val rhythmGuitarTrackNumber = mc.rhythmGuitarTrackNumber
  override val altRhythmGuitarTrackNumber = mc.altRhythmGuitarTrackNumber
  override val melodyTrackNumber = mc.melodyTrackNumber
  override val altMelodyTrackNumber = mc.altMelodyTrackNumber
  override val bassTrackNumber = mc.bassTrackNumber
  override val altBassTrackNumber = mc.altBassTrackNumber

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

  def setInstrument(track:Int, instrument:Int) = {
    mc.changeInstrument(track, instrument)
  }

  def muteTrack(trackNumber:Int) = {
    mc.muteTrack(trackNumber)
  }

  def soloTrack(trackNumber:Int) = {
    mc.soloTrack(trackNumber)
  }
}
