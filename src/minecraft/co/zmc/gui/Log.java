package co.zmc.gui;

import java.util.logging.Level;

public class Log {

	public static void info(String log) {
		ZephyrGUI.logger.log(Level.INFO, log);
	}
	
}
