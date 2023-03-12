package restAssuredTest;


import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AssertJexamples {

    @Test
    public void collectionTest(){
        List<String> actualCollection = new ArrayList<>(4);
       // actualCollection = Lis("one", "two", "three", "four"); //в этой версии Java не работает

        List<String> expectedCollection = new ArrayList<>(4);
      // expectedCollection = Lis("one", "two", "three", "four"); //в этой версии Java не работает

        Assertions.assertThat(actualCollection)  //сравнение 2-х коллекций с игнором порядка
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expectedCollection);

        Assertions.assertThat(actualCollection) //проверка, что в коллекции есть стринг
                .contains("one");

        Assertions.assertThat(actualCollection) //проверка, что все эл-ты коллекции больше 2-х символов
                .allMatch(element ->element.length()>2);
        Assertions.assertThat(actualCollection) //проверка размера коллекции
                .hasSize(4);
    }
}
