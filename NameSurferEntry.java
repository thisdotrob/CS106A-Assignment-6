/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

	/* Constructor: NameSurferEntry(line) */
	/**
	 * Creates a new NameSurferEntry from a data line as it appears
	 * in the data file.  Each line begins with the name, which is
	 * followed by integers giving the rank of that name for each
	 * decade.
	 */
	public NameSurferEntry(String line) {
		/* Create a new array for storing the name's ranks */
		ranks = new int[NDECADES];
		
		/* Get the index of the first space and use to remove and 
		 * name from the start of the line and store separately */
		int space = line.indexOf(" ");
		name = line.substring(0,space).toLowerCase();
		line = line.substring(space + 1);
		
		/* Divide the remaining line up into separate strings for each
		 * rank, parse these to ints and store in the ranks array */
		for (int i = 0; i < ranks.length; i++) {
			
			
			space = line.indexOf(" ");
			String rank = "";
			
			/* If there are no more spaces left in the line ( space = -1 ) then 
			 * there is only one rank remaining, and so no need to split the line */
			if (space != -1) {
				rank = line.substring(0,space);
				line = line.substring(space + 1);
			} else {
				rank = line;
			}
			
			/* Parse the rank to an int and store in the ranks array */
			ranks[i] = Integer.parseInt(rank);
			
			
		}		
		
	}

	/* Method: getName() */
	/** Returns the name associated with this entry. */
	public String getName() {
		return name;
	}

	/* Method: getRank(decade) */
	/**
	 * Returns the rank associated with an entry for a particular
	 * decade.  The decade value is an integer indicating how many
	 * decades have passed since the first year in the database,
	 * which is given by the constant START_DECADE.  If a name does
	 * not appear in a decade, the rank value is 0.
	 */
	public int getRank(int decade) {
		return ranks[decade];
	}

	/* Method: toString() */
	/**
	 * Returns a string that makes it easy to see the value of a
	 * NameSurferEntry.
	 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		String entryAsString = "";
		for (int i = 0; i < ranks.length; i++) {
			entryAsString += ranks[i] + " ";
		}
		entryAsString = name + " [ " + entryAsString + "]";
		return entryAsString;
	}
	
	// Instance variables
	private String name;
	private int[] ranks;
}

