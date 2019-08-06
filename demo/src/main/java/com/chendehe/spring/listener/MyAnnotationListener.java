package com.chendehe.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author CDH
 * @since 2019/8/6 0:55
 */
@Service
public class MyAnnotationListener {

    @EventListener(classes = ApplicationEvent.class)
    public void listen(ApplicationEvent event) {
        System.out.println("@EventListener：" + event);
    }
}
