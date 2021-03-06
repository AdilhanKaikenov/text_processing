package com.epam.adk.task2.text_processing.util;

import com.epam.adk.task2.text_processing.entity.TextComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * Printer class Created on 29.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public final class Printer {

    private static final Logger log = LoggerFactory.getLogger(Printer.class);

    /**
     * The method for displaying list of composite as a numbered.
     *
     * @param list     list of composite.
     * @param numbered boolean true for numbering, false for not.
     * @param <E>      type parameterization.
     */
    public static <E extends TextComponent> void print(Collection<E> list, boolean numbered) {
        if (!list.isEmpty() && numbered) {
            int i = 1;
            for (TextComponent composite : list) {
                log.info("{}){}", i++, composite.toString().trim());
            }
            log.info("");
        } else {
            print(list);
        }
    }

    /**
     * The method for displaying list of composite.
     *
     * @param list list of composite.
     * @param <E>  type parameterization.
     */
    public static <E extends TextComponent> void print(Collection<E> list) {
        if (!list.isEmpty()) {
            for (TextComponent composite : list) {
                log.info(composite.toString().trim());
            }
            log.info("");
        }
    }

    /**
     * The method for displaying text.
     *
     * @param component component to be displayed to the console.
     */
    public static void print(TextComponent component) {
        log.info(component.toSourceString());
    }
}
