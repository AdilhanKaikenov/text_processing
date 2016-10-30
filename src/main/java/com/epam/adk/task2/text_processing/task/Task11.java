package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.Sentence;
import com.epam.adk.task2.text_processing.entity.Text;
import com.epam.adk.task2.text_processing.exception.ParsingException;
import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import com.epam.adk.task2.text_processing.parse.RegexTextParser;
import com.epam.adk.task2.text_processing.parse.TextParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 11.В каждом предложении текста исключить подстроку максимальной длины, начинающуюся
 * и заканчивающуюся заданными символами.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task11 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task11.class);
    private TextParser parser;
    private String start;
    private String end;

    public Task11(String start, String end) {
        if (parser == null){
            try {
                parser = new RegexTextParser();
            } catch (PropertyPathException e) {
                log.error("Error in Task11() constrictor: {}", e);
            }
        }
        this.start = start;
        this.end = end;
    }

    @Override
    public void run(Text text) {

        log.info("Task #11");

        //TODO

    }

    /**
     * The method for removing a string begins and ends with specified characters.
     *
     * @param sentence sentence.
     * @return the amended sentence (without substring).
     */
    public Sentence removeSubstring(Sentence sentence) throws ParsingException {
        String result = sentence.toString();
        int indexOf = result.indexOf(start);
        int lastIndexOf = result.lastIndexOf(end);

        if (indexOf != -1 && lastIndexOf != -1) {
            result = result.substring(0, indexOf) + result.substring(lastIndexOf + end.length(), result.length());
        }
        return parser.parseTo(Sentence.class, result);
    }
}
