package com.beyondbell.bugisoft.EventHandling;

import com.beyondbell.bugisoft.EventHandling.GuildEventHandlers.GuildEventDelegator;
import com.beyondbell.bugisoft.EventHandling.JDAEventHandlers.JDAEventDelegator;
import com.beyondbell.bugisoft.EventHandling.UserEventsHandler.UserEventDelegator;
import net.dv8tion.jda.core.events.Event;
import net.dv8tion.jda.core.events.guild.GenericGuildEvent;
import net.dv8tion.jda.core.events.user.GenericUserEvent;
import net.dv8tion.jda.core.hooks.EventListener;

public final class BotEventListener implements EventListener {
	@Override
	public final void onEvent(final Event event) {
		if (event instanceof GenericGuildEvent) {
			new GuildEventDelegator((GenericGuildEvent) event);
		} else if (event instanceof GenericUserEvent) {
			new UserEventDelegator((GenericUserEvent) event);
		} else {
			new JDAEventDelegator(event);
		}
	}
}
