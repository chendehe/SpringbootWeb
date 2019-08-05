package com.chendehe.spring.transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author CDH
 * @since 2019/8/5 19:31
 */
@Service
public class TransactionService {

    @Transactional
    public String save() {
        System.out.println("save");
        return "---";
    }
}
