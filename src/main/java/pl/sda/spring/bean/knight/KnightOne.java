package pl.sda.spring.bean.knight;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.sda.spring.bean.quest.Quest;
import pl.sda.spring.bean.quest.QuestOne;
import pl.sda.spring.bean.quest.QuestTwo;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KnightOne implements Knight {

    private Quest questOne;


    @Override
    public void embarkQuest() {
        questOne.doQuest();
    }



}
