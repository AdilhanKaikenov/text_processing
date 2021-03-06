package com.epam.adk.task2.text_processing.task;

import com.epam.adk.task2.text_processing.entity.*;
import com.epam.adk.task2.text_processing.util.Printer;
import com.epam.adk.task2.text_processing.util.TextComponentIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 5.В каждом предложении текста поменять местами первое слово с последним, не изменяя длины предложения.
 *
 * @author Kaikenov Adilkhan
 * @see Task
 */
public final class Task5 implements Task {

    private static final Logger log = LoggerFactory.getLogger(Task5.class);

    @Override
    public void run(Text text) {

        log.info("Task #5");

        int indexOfFirst = 0;
        int indexOfLast = 0;

        Text textClone = text.clone();

        TextComponentIterator iterator = new TextComponentIterator(textClone);

        while (iterator.hasNext()) {
            TextComponent component = iterator.next();

            if (component instanceof Sentence) {

                Sentence sentence = (Sentence) component;
                List<SentenceComponent> components = sentence.getComponents();

                Word firstWord = sentence.getFirstWord(); // the first word
                Word lastWord = sentence.getLastWord(); // the last word

                indexOfFirst = components.indexOf(firstWord); // index of the first word
                indexOfLast = components.lastIndexOf(lastWord); // index of the last word

                // move the first and last word
                sentence.set(indexOfFirst, lastWord);
                sentence.set(indexOfLast, firstWord);

                Printer.print(sentence);
            }
        }
        log.info("");
    }
}
