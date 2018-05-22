package com.beyondbell.bugisoft.Minigames;

import com.beyondbell.bugisoft.RockPaperScissors.RockPaperScissors;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class GameModeEventHandler {
	static boolean value;
	static User author;

	public GameModeEventHandler(GuildMessageReceivedEvent event, boolean change) {
		value = change;
		author = event.getAuthor();
	}

	public GameModeEventHandler(GuildMessageReceivedEvent event) {
		if(value && event.getAuthor() == author) {
			new RockPaperScissors(event);
		}
	}
}