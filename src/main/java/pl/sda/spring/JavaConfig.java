package pl.sda.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan("pl.sda.spring")
public class JavaConfig {
}
