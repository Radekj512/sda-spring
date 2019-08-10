package pl.sda.spring.bean.knight;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import pl.sda.spring.bean.quest.Quest;

@Component

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KnightThree implements Knight {
    private Quest questOne;
    private Quest questTwo;
    private Quest questThree;

    @Override
    public void embarkQuest() {
        questOne.doQuest();
        questTwo.doQuest();
        questThree.doQuest();
    }
}
