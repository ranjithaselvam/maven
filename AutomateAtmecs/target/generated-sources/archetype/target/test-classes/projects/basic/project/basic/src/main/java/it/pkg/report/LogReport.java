package it.pkg.report;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import it.pkg.constants.Constants;


/**
 * Which keeps track of the record when any event happens or any software run.
 * @author ranjitha.selvam
 *
 */

public class LogReport {
	static Logger logger = null;

	public static void info(String message) {
		PropertyConfigurator.configure(Constants.log_file);
		logger = Logger.getLogger(LogReport.class.getName());
		logger.info(message);
	}


}
