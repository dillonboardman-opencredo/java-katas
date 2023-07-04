package com.opencredo.dillonboardman.kata.service.consumer;

import com.opencredo.dillonboardman.kata.service.locator.ServiceLocator;
import com.opencredo.dillonboardman.kata.service.provider.api.FileSort;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileSort fileSort = ServiceLocator.findSingle();
        System.out.println("Single sort: " + fileSort);

        List<FileSort> fileSorts = ServiceLocator.findAll();
        System.out.println("# all sorts: " + fileSorts.size());
    }
}