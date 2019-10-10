#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.report;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import ${package}.constants.Constants;


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
