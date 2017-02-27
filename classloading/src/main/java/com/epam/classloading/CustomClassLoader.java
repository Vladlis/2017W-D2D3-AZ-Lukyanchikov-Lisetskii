package com.epam.classloading;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;

public class CustomClassLoader extends ClassLoader {

    private static final Logger LOG = Logger.getLogger(CustomClassLoader.class.getName());

    public CustomClassLoader() {
        super(Thread.currentThread().getContextClassLoader());
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        try {
            return super.loadClass(name, resolve);
        } catch (ClassNotFoundException ignored) {
            LOG.debug("Parent class loader failed to load " + name);
            try {
                byte[] classBytes = Files.readAllBytes(getPathToClass(name));
                return defineClass(name, classBytes, 0, classBytes.length);
            } catch (IOException | URISyntaxException ex) {
                throw new ClassNotFoundException("Failed to load " + name, ex);
            }
        }
    }

    private Path getPathToClass(String name) throws URISyntaxException, ClassNotFoundException {
        String[] split = name.split("\\.");
        URL classUrl = getResource(split[split.length - 1].concat(".class"));
        if (classUrl != null) {
            LOG.debug("Binary class is found: " + classUrl);
            return Paths.get(classUrl.toURI());
        }
        throw new ClassNotFoundException("Failed to find " + name);
    }
}
