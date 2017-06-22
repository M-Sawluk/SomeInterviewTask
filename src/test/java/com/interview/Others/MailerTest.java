package com.interview.Others;

import com.interview.Mailer.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Mike on 2017-04-14.
 */
public class MailerTest {

    private Mailer mailer;

    @Before
    public void init(){
        mailer=new MailerImpl();
    }

    @After
    public void destroy(){
        mailer=null;
    }

    @Test
    public void enQueueTailTest(){

        mailer.enQueueTail("Michal","Karol","Hello","Greeting");
        mailer.enQueueTail("Michal","Karol","Hallo","Greeting");
        mailer.enQueueTail("Michal","Karol","Hiho","Greeting");

        EMail email = new EMail("Karol","Hiho","Greeting");

        assertThat(mailer.getMessages("Michal").size()).isEqualTo(3);
        assertThat(mailer.getMessages("Michal").get(0)).isEqualTo(email);

    }

    @Test
    public void deQueueHeadTest(){

        mailer.enQueueTail("Michal","Karol","Hello","Greeting");
        mailer.enQueueTail("Karol","Michal","Hallo","Greeting");
        mailer.enQueueTail("Karol","Michal","Welcome","Greeting");
        mailer.enQueueTail("Tomek","Karol","Hiho","Greeting");

        EMail email = new EMail("Michal","Welcome","Greeting");

        mailer.deQueueHead();

        assertThat(mailer.peekHead().getName()).isEqualTo("Karol");
        assertThat(mailer.getMessages(mailer.peekHead().getName()).get(0)).isEqualTo(email);
    }

    @Test
    public void deQueueTailTest(){

        mailer.enQueueTail("Michal","Karol","Hello","Greeting");
        mailer.enQueueTail("Karol","Michal","Hallo","Greeting");
        mailer.enQueueTail("Tomek","Karol","Hiho","Greeting");

        mailer.deQueueTail();

        assertThat(mailer.peekTail().getName()).isEqualTo("Karol");
        assertThat(mailer.peekTail().getList().get(0).getText()).isEqualTo("Hallo");
    }

    @Test
    public void PeekHeadTest(){

        mailer.enQueueTail("Michal","Karol","Hello","Greeting");
        mailer.enQueueTail("Karol","Michal","Hallo","Greeting");
        mailer.enQueueTail("Michal","Karol","Hiho","Greeting");

        assertThat(mailer.peekHead().getName()).isEqualTo("Karol");
        assertThat(mailer.peekHead().getList().get(0).getText()).isEqualTo("Hallo");
    }

    @Test(expected = NoSuchUserException.class)
    public void NoSuchUserExceptionTest(){
        mailer.enQueueTail("Michal","Karol","Hello","Greeting");
        mailer.deQueueTail();
        mailer.getMessages("Michal");

    }

    @Test(expected = EmptyQeueuException.class)
    public void EmptyQeueuExcpetionTest(){

        mailer.enQueueTail("Michal","Karol","Hello","Greeting");
        mailer.deQueueTail();

        mailer.peekHead();

    }


}
