package com.example.beanfactorypostprocessor.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        System.out.println("####"+beanDefinitionNames.length);//155
        for(String beanDefinitionName : beanDefinitionNames){
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            System.out.println("***********:"+beanDefinition);

            //what we need to understand here is before the bean initialize, we can get the control and modify the bean definition
            if(beanDefinition.getBeanClassName() != null && (beanDefinition.getBeanClassName().endsWith("Test"))){
                    beanDefinition.setScope("prototype");
                    beanDefinition.setLazyInit(true);
            }
            System.out.println("***********:"+beanDefinition);
        }
    }
}


/**
 *
 * Bean definition of Test before modifying
 * ***********:Generic bean: class [com.example.beanfactorypostprocessor.components.Test]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodNames=null; destroyMethodNames=null; defined in file [/home/dhanushka/Documents/example-repos/bean-factory-post-processor/target/classes/com/example/beanfactorypostprocessor/components/Test.class]
 *
 * Bean definition of Test after modifying
 * ***********:Generic bean: class [com.example.beanfactorypostprocessor.components.Test]; scope=prototype; abstract=false; lazyInit=true; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodNames=null; destroyMethodNames=null; defined in file [/home/dhanushka/Documents/example-repos/bean-factory-post-processor/target/classes/com/example/beanfactorypostprocessor/components/Test.class]
 *
 *
 */
