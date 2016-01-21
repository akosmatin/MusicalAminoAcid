package AminoAcidComposition

/**
 * Created by Aaron Kosmatin on 7/12/15.
 * The main interface for midi generation
 */

import javax.sound.midi.Track

import AminoAcidComposition.AminoAcid.AminoAcidAbstract
import AminoAcidComposition.SongStructure.MusicCommon

object MidiInterface extends MusicCommon {
  val rhythmGuitarTrackIndex = mc.rhythmGuitarTrackIndex
  val altRhythmGuitarTrackIndex = mc.altRhythmGuitarTrackIndex
  val melodyTrackIndex = mc.melodyTrackIndex
  val altMelodyTrackIndex = mc.altMelodyTrackIndex
  val bassTrackIndex = mc.bassTrackIndex
  val altBassTrackIndex = mc.altBassTrackIndex
  val drumTrackIndex = mc.drumTrackIndex
  val altDrumTrackIndex = mc.altDrumTrackIndex

  val rhythmGuitarTrack = mc.rhythmGuitarTrack
  val altRhythmGuitarTrack = mc.altRhythmGuitarTrack
  val melodyTrack = mc.melodyTrack
  val altMelodyTrack = mc.altMelodyTrack
  val bassTrack = mc.bassTrack
  val altBassTrack = mc.altBassTrack
  val drumTrack = mc.drumTrack
  val altDrumTrack = mc.altDrumTrack

  /**
   * Generates the midi sequence for playing or saving.
   * @param sequence1 String of amino acids for the primary music part
   * @param sequence2 String of amino acids for the secondaty music part
   */
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

  /**
   * Plays the midi tracks
   * @param bpm Beats per minute, default is 120
   */
  def playMidi(bpm:Int = 120) = mc.playMidi(bpm)

  /**
   * Skip to a location in the midi track
   * @param location the tick number
   */
  def setLocation(location:Long) = mc.setLocation(location)


  /**
   * stops and clears the midi tracks
   * @return the tick where playback was stopped
   */
  def stopMidi() = mc.stopMidi()


  /**
   * Returns the list of supported midi instruments
   * @return the list of supported midi instruments
   */
  def listInstruments() = mc.listInstruments()


  /**
   * Change the instrument in a track before playback
   * @param track
   * @param trackNumber
   * @param instrument
   * @return
   */
  def setInstrument(track:Track, trackNumber:Int, instrument:Int) = mc.changeInstrument(track, trackNumber, instrument)


  /**
   * Mute track
   * @param trackIndex
   */
  def muteTrack(trackIndex:Int) = mc.muteTrack(trackIndex)

  /**
   * 
   * @param trackIndex
   */
  def soloTrack(trackIndex:Int) = mc.soloTrack(trackIndex)


  /**
   * 
   * @param filename
   * @return
   */
  def writeMidi(filename:String) = {
    mc.writeMidi(filename)
  }

  def changeVolume(track:Track, trackIndex:Int, volume:Int) = mc.changeVolume(track, trackIndex, volume)
}