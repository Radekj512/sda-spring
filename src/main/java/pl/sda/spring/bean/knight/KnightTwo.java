package pl.sda.spring.bean.knight;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import pl.sda.spring.bean.quest.Quest;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
public class KnightTwo implements Knight {
    private Quest questOne;
    private Quest questTwo;

    @Override
    public void embarkQuest() {
        questOne.doQuest();
        questTwo.doQuest();
    }
}
