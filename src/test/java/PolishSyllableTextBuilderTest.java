import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.builders.TextBuilderFactory;
import com.interview.formatedText.builders.types.WordSplitType;
import com.interview.formatedText.organizers.SplitOn2Cols;
import com.interview.formatedText.organizers.types.VerticalTextOrganizer;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PolishSyllableTextBuilderTest {

    TextBuilder textBuilder;

    @Before
    public void init(){
        textBuilder = TextBuilderFactory.getTextBuilder(10,
                new SplitOn2Cols(new VerticalTextOrganizer()), WordSplitType.PolishSyllable);

        textBuilder.setPadding(5);

    }


    @Test
    public void addPaddingTest(){
        assertThat(textBuilder.addPadding("Ala ma kota").length()).isEqualTo(15);
        assertThat(textBuilder.addPadding("Ala ma kota")).isEqualTo("Ala ma kota    ");
        assertThat(textBuilder.addPadding(" Ala ma kota")).isEqualTo("Ala ma kota    ");
        assertThat(textBuilder.addPadding("   Ala ma kota")).isEqualTo("Ala ma kota    ");
        assertThat(textBuilder.addPadding("    Ala ma kota")).isEqualTo("    Ala ma kota");
    }

    @Test
    public void splitTextTest(){

        assertThat(textBuilder.splitText("Ala ma kota, a Tomasz"))
                .isEqualTo(Arrays.asList("Ala ma ko-     ","ta, a To-      ","masz           "));

        assertThat(textBuilder.splitText("    Ala ma kota, a Tomasz"))
                .isEqualTo(Arrays.asList("    Ala        ","ma kota, a     ","Tomasz         "));


        assertThat(textBuilder.splitText("Ala ma kota.    Tomasz lokomotywe."))
                .isEqualTo(Arrays.asList("Ala ma ko-     ","ta.            ","               ",
                        "Tomasz lo-     ","komotywe.      "));

    }

}
