package com.interview.Mailer;

import java.util.Date;

/**
 * Created by Mike on 2017-04-14.
 */
public class EMail implements Comparable<EMail> {

    private String recipient;

    private String text;

    private String subject;

    private Date sendingDate;

    public EMail(String recipient, String text, String subject) {
        this.recipient = recipient;
        this.text = text;
        this.subject = subject;
        this.sendingDate = new Date();
    }

    public EMail() {
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRecipient() {

        return recipient;
    }

    public String getText() {
        return text;
    }

    public String getSubject() {
        return subject;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    @Override
    public int compareTo(EMail o) {
        return sendingDate.compareTo(o.getSendingDate());
    }

    @Override
    public String toString() {
        return "EMail{" +
                "recipient='" + recipient + '\'' +
                ", text='" + text + '\'' +
                ", subject='" + subject + '\'' +
                ", sendingDate=" + sendingDate.getTime() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EMail)) return false;

        EMail eMail = (EMail) o;

        if (getRecipient() != null ? !getRecipient().equals(eMail.getRecipient()) : eMail.getRecipient() != null)
            return false;
        if (getText() != null ? !getText().equals(eMail.getText()) : eMail.getText() != null) return false;
        if (getSubject() != null ? !getSubject().equals(eMail.getSubject()) : eMail.getSubject() != null) return false;
        return getSendingDate() != null ? getSendingDate().equals(eMail.getSendingDate()) : eMail.getSendingDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getRecipient() != null ? getRecipient().hashCode() : 0;
        result = 31 * result + (getText() != null ? getText().hashCode() : 0);
        result = 31 * result + (getSubject() != null ? getSubject().hashCode() : 0);
        result = 31 * result + (getSendingDate() != null ? getSendingDate().hashCode() : 0);
        return result;
    }
}
