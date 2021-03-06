package com.epam.adk.task2.text_processing.util;

import com.epam.adk.task2.text_processing.exception.PropertyPathException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

/**
 * PropertyLoader class created on 25.10.2016.
 *
 * @author Kaikenov Adilkhan
 */
public final class PropertyLoader {

    private static final Logger log = LoggerFactory.getLogger(PropertyLoader.class);

    public Properties getProperties(String propertyName) throws PropertyPathException {
        log.debug("Entering getProperties: Property file name = '{}'", propertyName);
        Properties properties = new Properties();
        try (InputStream in = PropertyLoader.class.getClassLoader().getResourceAsStream(propertyName)) {
            log.debug("Load {} file", propertyName);
            properties.load(in);
        } catch (Exception e) {
            log.error("Invalid path to property file : {}", propertyName);
            throw new PropertyPathException(MessageFormat.format("Error reading file. {0}.", propertyName));
        }
        return properties;
    }
}
