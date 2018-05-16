package com.beyondbell.bugisoft.EventHandling.GuildEventHandlers;

import net.dv8tion.jda.core.events.guild.GenericGuildEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public final class GuildEventDelegator {
	public GuildEventDelegator(final GenericGuildEvent event) {
		if (event instanceof GuildMessageReceivedEvent) {
			new GuildMessageReceivedEventHandler((GuildMessageReceivedEvent) event);
		} else if (event instanceof GuildVoiceJoinEvent) {
			new GuildVoiceJoinEventHandler((GuildVoiceJoinEvent) event);
		} else if (event instanceof GuildVoiceLeaveEvent) {
			new GuildVoiceLeaveEventHandler((GuildVoiceLeaveEvent) event);
		}
	}
}