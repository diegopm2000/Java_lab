package com.beanpostprocessor.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SampleBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("After of the initialization: " + beanName);
    return bean;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    System.out.println("Before of the initialization: " + beanName);
    return bean;
  }

}
