package pl.sda.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.spring.bean.knight.Knight;
import pl.sda.spring.bean.knight.KnightOne;
import pl.sda.spring.bean.knight.KnightThree;
import pl.sda.spring.bean.knight.KnightTwo;
import pl.sda.spring.bean.quest.Quest;
import pl.sda.spring.bean.quest.QuestOne;
import pl.sda.spring.bean.quest.QuestThree;
import pl.sda.spring.bean.quest.QuestTwo;

@Configuration
public class JavaConfig {

    @Bean(name = "questOne")
    public Quest someQuest() {
        return new QuestOne();
    }

    @Bean(name = "questTwo")
    public Quest someQuest2() {
        return new QuestTwo();
    }

    @Bean(name = "questThree")
    public Quest someQuest3() {
        return new QuestThree();
    }

    @Bean(name = "knightOne")
    public Knight knightOne(Quest questOne) {
        return new KnightOne(questOne);
    }

    @Bean(name = "knightTwo")
    public Knight knightTwo(Quest questTwo) {
        return new KnightOne(questTwo);
    }

    @Bean(name = "knightThree")
    public Knight knightThree(Quest questOne, Quest questTwo, Quest questThree) {
        return new KnightThree(questOne, questTwo, questThree);
    }

}
