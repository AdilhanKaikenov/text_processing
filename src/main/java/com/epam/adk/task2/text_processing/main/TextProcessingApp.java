package com.epam.adk.task2.text_processing.main;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.exception.ParsingException;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.exception.ReadingException;
import com.epam.adk.task2.text_processing.io.TextReader;
import com.epam.adk.task2.text_processing.parse.RegexTextParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created on 22.10.2016.
 *
 * The class with main method.
 *
 * @author Kaikenov Adilhan.
 */
public final class TextProcessingApp {

    private static final Logger log = LoggerFactory.getLogger(TextProcessingApp.class);

    private static final int FILE_PATH = 0;
    private static final int CHARSET = 1;

    /**
     * Application starting point.
     *
     * @param args input arguments array.
     */
    public static void main(String[] args) throws ReadingException, PropertyPathException, ParsingException {

        if (args.length != 2) {
            throw new IllegalArgumentException("Specify the file path and charset");
        }

        String pathParam = args[FILE_PATH];
        String charsetName = args[CHARSET];

        TextReader reader = new TextReader();
        String sourceString = reader.read(pathParam, charsetName);
        log.info("\n{}", sourceString);

        RegexTextParser textParser = new RegexTextParser();
        Text parsedText = textParser.parse(sourceString);
        log.info("\n{}", parsedText);

    }
}
