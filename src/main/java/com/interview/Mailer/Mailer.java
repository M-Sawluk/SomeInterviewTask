package com.interview.Mailer;

import java.util.List;
import java.util.Map;

/**
 * Created by Mike on 2017-04-14.
 */
public interface Mailer {

    void enQueueTail(String sender,String recipient,String text,String subject);

    void deQueueTail();

    void deQueueHead();

    NameMsgsPair<String,List<EMail>> peekTail();

    NameMsgsPair<String,List<EMail>> peekHead();

    List<EMail> getMessages(String sender);

}
