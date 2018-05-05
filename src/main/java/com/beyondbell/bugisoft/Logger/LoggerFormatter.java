package com.beyondbell.bugisoft.Logger;

import java.util.ArrayList;

public class LoggerFormatter {

	/**
	 * Breaks Up a Log Message Entry Into It's Corresponding Components
	 * @param entry Line of the Log to Break
	 * @return 0-Message_ID ; 1-Author_ID ; 2-Message_Contents
	 */
	public String[] getEntryComponents(String entry) {
		String[] components = new String[3];
		ArrayList<String> componentsList = new ArrayList<>();

		StringBuilder currentComponent = new StringBuilder();
		for (int i = 0; i < entry.length(); i++) {
			if (entry.charAt(i) == '|') {
				componentsList.add(currentComponent.toString());
				// Trim Off Last Space
				currentComponent.delete(currentComponent.length() - 1, currentComponent.length());
				currentComponent = new StringBuilder();
			} else {
				currentComponent.append(entry.charAt(i));
			}
		}
		componentsList.add(currentComponent.toString());


		if (componentsList.size() != components.length) {
			// TODO Cry
		} else {
			for (int i = 0; i < components.length; i++) {

			}
		}



		return components;
	}

	public static String getCorrespondingLogMessage(String messageId, String authorId, String message) {
		return messageId + " | " + authorId + " | " + message;
	}

	public static String getIDFromLogMessage(String logMessage) {
		StringBuilder id = new StringBuilder();
		for (int i = 0; i < logMessage.length(); i++) {
			if (logMessage.charAt(i) == '|') {
				break;
			}
			id.append(logMessage.charAt(i));
		}
		return id.toString();
	}
}