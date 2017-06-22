import com.interview.formatedText.builders.WordSplitter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WordSplitterTest {

    @Test
    public void isSplittableTest(){

        assertThat(WordSplitter.isSplittable("Krzak")).isEqualTo(false);
        assertThat(WordSplitter.isSplittable("żółw")).isEqualTo(false);

        assertThat(WordSplitter.isSplittable("się")).isEqualTo(true);
        assertThat(WordSplitter.isSplittable("ksiądz")).isEqualTo(true);
        assertThat(WordSplitter.isSplittable("Brzęczyszczykiewicz")).isEqualTo(true);

    }

    @Test
    public void shitIfUnsplittableGroupTest(){
        assertThat(WordSplitter.shitIfUnsplittableGroup("Brzęczyszczykiewicz",5)).isEqualTo(4);
        assertThat(WordSplitter.shitIfUnsplittableGroup("Brzęczyszczykiewicz",8)).isEqualTo(9);
        assertThat(WordSplitter.shitIfUnsplittableGroup("machina",3)).isEqualTo(2);
    }

    @Test
    public void consonantsGroupPatternTest(){

        assertThat(WordSplitter.consonantsGroupPattern("Tomasz")).isEqualTo("Tomasz");
        assertThat(WordSplitter.consonantsGroupPattern("Brzęczyszczykiewicz"))
                .isEqualTo("Brzę czysz czykiewicz");

        assertThat(WordSplitter.consonantsGroupPattern("Namiot")).isEqualTo("Namiot");
        assertThat(WordSplitter.consonantsGroupPattern("Informatyka"))
                .isEqualTo("In for matyka");

        assertThat(WordSplitter.consonantsGroupPattern("portfel"))
                .isEqualTo("por tfel");

    }

    @Test
    public void vowelConsonantPatternTest(){
        assertThat(WordSplitter.vowelConsonantPattern("Brzęczyszczykiewicz"))
                .isEqualTo("Brzę czy szczy kie wicz");

        assertThat(WordSplitter.vowelConsonantPattern("Tomasz")).isEqualTo("To masz");
        assertThat(WordSplitter.vowelConsonantPattern("Natalia")).isEqualTo("Na ta lia");
        assertThat(WordSplitter.vowelConsonantPattern("Grzegorz")).isEqualTo("Grze gorz");
        assertThat(WordSplitter.vowelConsonantPattern("Namiot")).isEqualTo("Na miot");
    }

    @Test
    public void splitWordOnSyllablesToOffsetTest(){

        assertThat(WordSplitter.splitWordOnSyllablesToOffset("Brzęczyszczykiewicz" ,7))
                .isEqualTo(new ArrayList<>(Arrays.asList("Brzę-","czyszczykiewicz")));

        assertThat(WordSplitter.splitWordOnSyllablesToOffset("Brzęczyszczykiewicz" ,10))
                .isEqualTo(new ArrayList<>(Arrays.asList("Brzęczysz-","czykiewicz")));

        assertThat(WordSplitter.splitWordOnSyllablesToOffset("Brzęczyszczykiewicz" ,18))
                .isEqualTo(new ArrayList<>(Arrays.asList("Brzęczyszczykie-","wicz")));

        assertThat(WordSplitter.splitWordOnSyllablesToOffset("Ala" ,2))
                .isEqualTo(new ArrayList<>(Arrays.asList("A-","la")));

        assertThat(WordSplitter.splitWordOnSyllablesToOffset("piłka" ,2))
                .isEqualTo(new ArrayList<>(Arrays.asList("piłka")));

    }

    @Test
    public void forcedSplitToOffsetTest(){

        assertThat(WordSplitter.forcedSplitToOffset("Brzęczyszczykiewicz" ,2))
                .isEqualTo(new ArrayList<>(Arrays.asList("Br","zęczyszczykiewicz")));

        assertThat(WordSplitter.forcedSplitToOffset("Brzęczyszczykiewicz" ,10))
                .isEqualTo(new ArrayList<>(Arrays.asList("Brzęczyszc","zykiewicz")));

        assertThat(WordSplitter.forcedSplitToOffset("Ala" ,2))
                .isEqualTo(new ArrayList<>(Arrays.asList("Al","a")));


    }

    @Test
    public void splitSentenceWithTabsTest(){

        String testString1 = "    Ala ma kota,    a Tomasz namiot";
        assertThat(WordSplitter.splitSentenceWithTabs(testString1))
                .isEqualTo(new ArrayList<>(Arrays.asList("    Ala ma kota,",
                        "    a Tomasz namiot")));

        String testString2 = "    Ala ma kota, a Tomasz namiot";
        assertThat(WordSplitter.splitSentenceWithTabs(testString2))
                .isEqualTo(new ArrayList<>(Arrays.asList("    Ala ma kota, a Tomasz ",
                        "namiot")));

        String testString3 = "Ala ma kota,    a Tomasz namiot";
        assertThat(WordSplitter.splitSentenceWithTabs(testString3))
                .isEqualTo(new ArrayList<>(Arrays.asList("Ala ma kota,",
                        "    a Tomasz namiot")));

        String testString4 = "    Ala";
        assertThat(WordSplitter.splitSentenceWithTabs(testString4))
                .isEqualTo(new ArrayList<>(Arrays.asList("    ",
                        "Ala")));


    }

    @Test
    public void splitSentenceOnSyllablesToOffsetTest(){

        String testString = "Ala ma kota, a Tomasz namiot";

        assertThat(WordSplitter.splitSentenceOnSyllablesToOffset(testString,25))
                .isEqualTo(new ArrayList<>(Arrays.asList("Ala ma kota, a Tomasz na-",
                        "miot")));

        assertThat(WordSplitter.splitSentenceOnSyllablesToOffset(testString,23))
                .isEqualTo(new ArrayList<>(Arrays.asList("Ala ma kota, a Tomasz",
                        "namiot")));

        assertThat(WordSplitter.splitSentenceOnSyllablesToOffset(testString,19))
                .isEqualTo(new ArrayList<>(Arrays.asList("Ala ma kota, a To-",
                        "masz namiot")));

        assertThat(WordSplitter.splitSentenceOnSyllablesToOffset(testString,15))
                .isEqualTo(new ArrayList<>(Arrays.asList("Ala ma kota, a",
                        " Tomasz namiot")));

        assertThat(WordSplitter.splitSentenceOnSyllablesToOffset(testString,9))
                .isEqualTo(new ArrayList<>(Arrays.asList("Ala ma ko-",
                        "ta, a Tomasz namiot")));

        assertThat(WordSplitter.splitSentenceOnSyllablesToOffset(testString,5))
                .isEqualTo(new ArrayList<>(Arrays.asList("Ala",
                        " ma kota, a Tomasz namiot")));

    }

}
