package com.interview.Mailer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Mike on 2017-04-14.
 */
@Component
public class MailerImpl implements Mailer {

    private MailsInBox<EMail> mailsInBox = new MailsInBox<>();

    Logger log = LoggerFactory.getLogger(MailerImpl.class);

    @Override
    public void enQueueTail(String sender,String recipient,String text,String subject) {
        EMail email = new EMail(recipient,text,subject);
        mailsInBox.addNew(sender,email);

    }

    @Override
    public void deQueueTail() {
        mailsInBox.deleteTail();
    }

    @Override
    public void deQueueHead() {
        mailsInBox.deleteHead();
    }

    @Override
    public NameMsgsPair<String,List<EMail>> peekTail() {
        if(mailsInBox.getLast()==null)
            throw new EmptyQeueuException("No new Messages");
        else
            return mailsInBox.getLast();
    }

    @Override
    public NameMsgsPair<String, List<EMail>> peekHead() {
        if(mailsInBox.getFirst()==null)
            throw new EmptyQeueuException("No new Messages");
        else
            return mailsInBox.getFirst();
    }

    @Override
    public List<EMail> getMessages(String sender) {
        List<EMail> list = new ArrayList<>();

        if(mailsInBox.getValue(sender)!=null){
            list.addAll(mailsInBox.getValue(sender));
            Collections.reverse(list);
            return list;
        }else
            throw new NoSuchUserException("Sender does not exist");
    }


}
