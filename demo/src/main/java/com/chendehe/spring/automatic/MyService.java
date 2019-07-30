package com.chendehe.spring.automatic;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author CDH
 * @since 2019/7/30 17:46
 */
public interface MyService {}
@Service
@Primary
class Aaa implements MyService {}
@Service
class Bbb implements MyService {}
