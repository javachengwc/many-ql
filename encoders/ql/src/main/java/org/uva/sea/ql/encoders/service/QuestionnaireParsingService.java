package org.uva.sea.ql.encoders.service;

import java.io.IOException;

import org.uva.sea.ql.encoders.model.Questionnaire;

/**
 * Service for parsing questionnaire input files.
 * 
 * @author Pim Tegelaar
 */
public interface QuestionnaireParsingService {

	/**
	 * Parses the input file and creates a questionnaire.
	 * 
	 * @param location
	 *            the location of the input file.
	 * @return The {@link Questionnaire} that was parsed from the input file.
	 */
	Questionnaire parse(String location) throws IOException;

}