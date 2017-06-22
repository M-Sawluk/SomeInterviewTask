import com.interview.formatedText.builders.TextBuilder;
import com.interview.formatedText.builders.TextBuilderFactory;
import com.interview.formatedText.builders.types.WordSplitType;
import com.interview.formatedText.organizers.SplitOn2Cols;
import com.interview.formatedText.organizers.types.VerticalTextOrganizer;
import com.interview.formatedText.sources.types.RestTextSource;
import com.interview.formatedText.sources.types.restTools.MyGistWithText;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by Mike on 2017-05-14.
 */
public class RestTextSourceTest {

    RestTextSource restTextSource;

    @Before
    public void init(){
        TextBuilder textBuilder = TextBuilderFactory.getTextBuilder(10,
                new SplitOn2Cols(new VerticalTextOrganizer()), WordSplitType.PolishSyllable);

        textBuilder.setPadding(5);

        restTextSource = new RestTextSource(textBuilder, new MyGistWithText(),"https://gist.githubu" +
                "sercontent.com/M-Sawluk/eb9cf670d957b2f97f214cf05072f1a1/raw/2c8a22" +
                "cad3ce5ed6e45f1949d0182a2d9bc54d5e/someText.json");

    }

    @Test
    public void obtainTextTest(){

        assertThat(restTextSource.obtainText()).contains("O premierze nowej Opery informowaliśmy");

    }

}
