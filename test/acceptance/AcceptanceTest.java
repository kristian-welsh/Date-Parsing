package acceptance;

import date.parsing.DateParser;
import org.junit.Test;
import static org.junit.Assert.*;

public class AcceptanceTest {
	private static String INPUT = "Marvin Lee Minsky at the Mathematics Genealogy Project; 20 May 2014\n" +
		"Marvin Lee Minsky at the AI Genealogy Project. {reprint 18 September 2011)\n" +
		"\"Personal page for Marvin Minsky\". web.media.mit.edu. Retrieved 23 June 2016.\n" +
		"Admin (January 27, 2016). \"Official Alcor Statement Concerning Marvin Minsky\". \n" +
		"	Alcor Life Extension Foundation. Retrieved 2016-04-07.\n" +
		"\"IEEE Computer Society Magazine Honors Artificial Intelligence Leaders\". \n" +
		"	DigitalJournal.com. August 24, 2011. Retrieved September 18, 2011. \n" +
		"	Press release source: PRWeb (Vocus).\n" +
		"\"Dan David prize 2014 winners\". May 15, 2014. Retrieved May 20, 2014.";
	private static String EXPECTED = "2011:\n" +
		"-08\n" +
		"-24 (1)\n" +
		"-09\n" +
		"-18 (2)\n" +
		"2014:\n" +
		"-05\n" +
		"-15 (1)\n" +
		"-20 (2)\n" +
		"2016:\n" +
		"-01\n" +
		"-27 (1)\n" +
		"-04\n" +
		"-07 (1)\n" +
		"-06\n" +
		"-23 (1)\n";
	
	@Test
	public void testCode() {
		DateParser p = new DateParser();
		String output = p.parse(INPUT);
		assertEquals(EXPECTED, output);
	}
}
