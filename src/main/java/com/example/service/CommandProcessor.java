package com.example.service;

/**
 * @author salil.mamodiya
 * 02/06/21
 */
public abstract class CommandProcessor<I, R> {

    abstract R run(I data);

}
