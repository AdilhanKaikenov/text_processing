package com.epam.adk.task2.text_processing.parse;

import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.entity.TextComposite;
import com.epam.adk.task2.text_processing.exception.ParsingException;

/**
 * Interface TextParser created on 26.10.2016.
 *
 * @author Kaikenov Adilkhan.
 */
public interface TextParser {

    /**
     * The method for parsing source string.
     *
     * @param source target source string to parseTo.
     * @return Text instance.
     * @throws ParsingException
     */
    Text parse(String source) throws ParsingException;

    /**
     * The method for parsing source string.
     *
     * @param compositeClass TextComposite type class which we need to parseTo.
     * @param source target source string to parseTo.
     * @param <T> type parameterization.
     * @return <T extends TextComposite> T instance.
     * @throws ParsingException
     */
    <T extends TextComposite> T parseTo(Class<T> compositeClass, String source) throws ParsingException;
}
