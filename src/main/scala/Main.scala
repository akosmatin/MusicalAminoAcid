/**
 * Created by Aaron Kosmatin on 7/12/15.
 * This is the initial main that creates a midi track and converts a sequence of Amino Acids
 * into that track
 */

import java.io.File
import javax.sound.midi._

import AminoAcidChords.AminoAcidAbstract
import AminoAcidChords.SongStructure.MusicCommon

object Main extends App with MusicCommon {
  mc.listInstruments
  val testSeq = "YWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYWYW"

  val thyA = "MKQYLELMQKVLDEGTQKNDRTGTGTLSIFGHQMRFNLQDGFPLVTTKRCHLRSIIHELLWFLQGDTNIAYLHENNVTIWDEWADENGDLGPVYGKQWRAWPTPDGRHIDQITTVLNQLKNDPDSRRIIVSAWNVGELDKMALAPCHAFFQFYVADGKLSCQLYQRSCDVFLGLPFNIASYALLVHMMAQQCDLEVGDFVWTGGDTHLYSNHMDQTHLQLSREPRPLPKLIIKRKPESIFDYRFEDFEIEGYDPHPGIKAPVAI"

  for (i <- Range(0, thyA.length)) {
    val aminoAcid = {
      val objectName = "AminoAcidChords." + thyA.charAt(i) + "$"
      val cons = Class.forName(objectName).getDeclaredConstructors
      cons(0).setAccessible(true)
      cons(0).newInstance().asInstanceOf[AminoAcidAbstract]
    }
    aminoAcid.addTracks(measure*i)
  }

  mc.writeMidi("/home/doccali/thyA.mid")

  mc.playMidi(120)
}
