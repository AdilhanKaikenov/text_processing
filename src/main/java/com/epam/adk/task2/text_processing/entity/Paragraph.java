package com.epam.adk.task2.text_processing.entity;

import java.util.List;

/**
 * Paragraph class created on 23.10.2016.
 *
 * @author Kaikenov Adilkhan.
 * @see TextComposite
 */
public class Paragraph extends AbstractTextComposite<Sentence> {

    @Override
    public Paragraph clone() {
        Paragraph paragraph = new Paragraph();
        for (Sentence sentence : this.getComponents()) {
            paragraph.add(sentence.clone());
        }
        return paragraph;
    }

    @Override
    public void toSourceString(StringBuilder builder) {
        int index = 0;
        List<Sentence> components = getComponents();
        for (int i = 0; i < components.size(); i++) {
            index = i;
            Sentence sentence = components.get(i);
            if (sentence != null) {
                builder.append(sentence.toSourceString());
            }
        }
        builder.append((index != components.size()) ? "\n" : "");
    }

    @Override
    public String toString() {
        return this.toSourceString();
    }
}
