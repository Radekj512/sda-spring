package pl.sda.spring.bean.knight;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.sda.spring.bean.quest.Quest;
import pl.sda.spring.bean.quest.QuestOne;
import pl.sda.spring.bean.quest.QuestTwo;

@ToString
@Component
public class KnightOne implements Knight {

    private Quest questOne;

    @Autowired
    public KnightOne(@Qualifier("questTwo") Quest quest) {
        this.questOne = quest;
    }

    @Override
    public void embarkQuest() {
        questOne.doQuest();
    }



}
