import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.builders.TextBuilderFactory;
import com.interview.formatedText.builders.types.WordSplitType;
import com.interview.formatedText.organizers.SplitOn2Cols;
import com.interview.formatedText.organizers.types.VerticalTextOrganizer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class NoSyllableTextBuilderTest {

    TextBuilder textBuilder;

    @Before
    public void init(){
        textBuilder = TextBuilderFactory.getTextBuilder(5,
                new SplitOn2Cols(new VerticalTextOrganizer()), WordSplitType.NoSyllable);

        textBuilder.setPadding(1);

    }

    @Test
    public void splitTextTest(){

        assertThat(textBuilder.splitText("Ala ma kota."))
                .isEqualTo(Arrays.asList("Ala   ","ma    ","kota. "));

        assertThat(textBuilder.splitText("Brzęczyszczykiewicz"))
                .isEqualTo(Arrays.asList("Brzęc ","zyszc ","zykie ","wicz  "));

        assertThat(textBuilder.setText("Brzęczyszczykiewicz").getFormattedText())
                .isEqualTo("Brzęc zykie \n"+
                           "zyszc wicz  \n");

    }
}
