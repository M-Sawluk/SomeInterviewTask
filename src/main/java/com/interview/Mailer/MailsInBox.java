package com.interview.Mailer;

import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by Mike on 2017-04-14.
 */
public class MailsInBox<T> {

    private Map<String,List<T>> list = new LinkedHashMap<String, List<T>>();

    public void addNew(String sender,T t){

        if(list.containsKey(sender)){
            List<T> senderList =list.get(sender);
            senderList.add(t);
            list.remove(sender);
            list.put(sender,senderList);
        }else{
            list.put(sender,new ArrayList<>(Arrays.asList(t)));
        }

    }

    public void deleteHead(){
        if(getFirstElement()!=null){
            list.remove(getFirstElement());
        }
    }

    public void deleteTail(){
        if(getLastElement()!=null) {
            list.remove(getLastElement());
        }
    }

    public NameMsgsPair<String,List<T>> getFirst(){
        String name=getFirstElement();
        if(name!=null) {
            NameMsgsPair<String,List<T>> tempList= new NameMsgsPair<>(name,list.get(name));
            return tempList;
        }else
            return null;
    }

    public NameMsgsPair<String,List<T>> getLast(){
        String name=getLastElement();
        if(name!=null) {
            NameMsgsPair<String,List<T>> tempList= new NameMsgsPair<>(name,list.get(name));
            return tempList;
        }else
            return null;
    }

    public List<T> getValue(String sender){

        if(list.containsKey(sender))
            return list.get(sender);
        else
            return null;
    }

    private String getFirstElement(){

        Iterator<String> it = list.keySet().iterator();
        if(it.hasNext())
           return it.next();
        else
            return null;

    }

    private String getLastElement(){

        List<String> keys = new LinkedList<>(list.keySet());

        if(keys.size()>0)
            return keys.get(keys.size()-1);
        else
            return null;
    }
}
