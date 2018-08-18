package com.beyondbell.bugisoft.music

import com.sedmelluq.discord.lavaplayer.player.AudioPlayer
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter
import com.sedmelluq.discord.lavaplayer.tools.FriendlyException
import com.sedmelluq.discord.lavaplayer.track.AudioTrack
import com.sedmelluq.discord.lavaplayer.track.AudioTrackEndReason
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue


class TrackScheduler(private val player: AudioPlayer) : AudioEventAdapter() {
	private val queue: BlockingQueue<AudioTrack> = LinkedBlockingQueue()

	override fun onPlayerPause(player: AudioPlayer) {
		// Player was paused
	}

	override fun onPlayerResume(player: AudioPlayer) {
		// Player was resumed
	}

	override fun onTrackStart(player: AudioPlayer, track: AudioTrack) {
		// A track started playing
	}

	override fun onTrackEnd(player: AudioPlayer, track: AudioTrack, endReason: AudioTrackEndReason) {
		if (endReason.mayStartNext) {
			// Start next track
		}

		// endReason == FINISHED: A track finished or died by an exception (mayStartNext = true).
		// endReason == LOAD_FAILED: Loading of a track failed (mayStartNext = true).
		// endReason == STOPPED: The player was stopped.
		// endReason == REPLACED: Another track started playing while this had not finished
		// endReason == CLEANUP: Player hasn't been queried for a while, if you want you can put a
		//                       clone of this back to your queue
	}

	override fun onTrackException(player: AudioPlayer, track: AudioTrack, exception: FriendlyException) {
		// An already playing track threw an exception (track end event will still be received separately)
	}

	override fun onTrackStuck(player: AudioPlayer, track: AudioTrack, thresholdMs: Long) {
		// Audio track has been unable to provide us any audio, might want to just start a new track

	}

	fun nextTrack() {
		player.startTrack(queue.poll(), false)
	}

	fun queue(track: AudioTrack) {
		if (!player.startTrack(track, true)) {
			queue.offer(track)
		}
	}

	fun skip(numberToSkip: Int) {
		var i = 0
		while (i < numberToSkip - 1 && i < queue.size() - 1) {
			queue.remove(queue.peek())
			i++
		}
		nextTrack()
	}
}