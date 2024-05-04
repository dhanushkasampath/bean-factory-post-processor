package com.example.beanfactorypostprocessor.components;

import org.springframework.stereotype.Component;

@Component
public class Test {
}


/**
 * but before the bean creation I just want to control the bean definition
 * like what would be the scope
 * LazyInit?
 * autowireCandidate?
 *
 * in order to do so before the initialization of this bean,
 * I can trigger bean factory post processor
 */