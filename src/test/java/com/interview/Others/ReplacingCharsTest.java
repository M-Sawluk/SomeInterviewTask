package com.interview.Others;

import com.interview.ReplacingCharackters.ReplacingCharactersInString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Mike on 2017-04-13.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplacingCharsTest {

    @Autowired
    private ReplacingCharactersInString replacingCharactersInString;

    @Test
    public void contexLoads(){
        assertThat(replacingCharactersInString).isNotNull();
    }

    @Test
    public void checkReplaceCharsMethod(){

        assertThat(replacingCharactersInString.replaceChars("MichalSawlukGoodCoder" , 'o'))
                .isEqualTo("MichalSawlukG**dC*der");

        assertThat(replacingCharactersInString.replaceChars("",'y')).isEqualTo("");

        assertThat(replacingCharactersInString.  replaceChars(null,'y')).isEqualTo("");

    }


}
