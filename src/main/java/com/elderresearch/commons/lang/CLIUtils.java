/*******************************************************************************
 * Copyright (c) 2016 Elder Research, Inc.
 * All rights reserved.
 *******************************************************************************/
package com.elderresearch.commons.lang;

import java.util.Arrays;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import lombok.val;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

/**
 * Convenience utilities when using {@link JCommander} to parse command-line arguments.
 * 
 * @author <a href="mailto:dimeo@datamininglab.com">John Dimeo</a>
 * @since Nov 15, 2016
 */
@Log4j2
@UtilityClass
public class CLIUtils {
	/**
	 * Parses command-line arguments using JCommander, printing out the usage if there are any problems.
	 * @param args the command line args
	 * @param objs one or more objects annotated with JCommander
	 * @return whether or not the arguments parsed successfully
	 * @see JCommander#addObject(Object)
	 */
	public boolean parseArgs(String[] args, Object... objs) {
		val jc = new JCommander();
		Arrays.asList(objs).forEach(jc::addObject);
 		return parseArgs(args, jc);
	}
	
    /**
     * Parses a series of separate "commands"- each one being an annotated with {@link JCommander}. The first arg is
     * considered the command name and the subsequent args are specific to that command.
     * @param args the command line args
     * @param shared optionally a shared parameter object common to all commands
     * @param commands one or more commands annotated with JCommander
     * @param <T> the common type among all commands
     * @return the parsed command (one of the objects passed as the parameter) or <tt>null</tt> if there was a problem
     * parsing the arguments
     * @see JCommander#addCommand(Object)
     */
    @SafeVarargs
    public <T> T parseCommands(String[] args, Object shared, T... commands) {
        val jc = new JCommander();
        LambdaUtils.accept(shared, jc::addObject);
        Arrays.asList(commands).forEach(jc::addCommand);
        if (parseArgs(args, jc)) {
            val pc = jc.getParsedCommand();
            if (pc == null) {
                jc.usage();
                return null;
            }
            
            JCommander jcc = jc.getCommands().get(pc);
            return Utilities.cast(Utilities.first(jcc.getObjects()));
        }
        return null;
    }
	
	/**
	 * Parses command-line arguments using JCommander, printing out the usage if there are any problems.
	 * @param args the command line args
	 * @param jc the JCommander object, with any annotated objects and/or commands added
	 * @return whether or not the arguments parsed successfully
	 * @see JCommander#addCommand(Object)
	 * @see JCommander#addObject(Object)
	 */
	public boolean parseArgs(String[] args, JCommander jc) {
		try {
 			jc.parse(args);
		} catch (ParameterException ex) {
			log.warn("Argument error: {}", ex.getMessage());
			jc.usage();
			return false;
		}
		return true;
	}
}
