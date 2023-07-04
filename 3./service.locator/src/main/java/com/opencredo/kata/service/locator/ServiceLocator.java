package com.opencredo.kata.service.locator;

import com.opencredo.kata.service.provider.api.FileSort;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class ServiceLocator {
    public static FileSort findSingle() {
        ServiceLoader<FileSort> loader = ServiceLoader.load(FileSort.class);
        for (FileSort fileSort : loader)
            return fileSort;
        return null;
    }

    public static List<FileSort> findAll() {
        List<FileSort> fileSorts = new ArrayList<>();
        ServiceLoader<FileSort> loader = ServiceLoader.load(FileSort.class);
        for (FileSort fileSort : loader)
            fileSorts.add(fileSort);
        return fileSorts;
    }
}
