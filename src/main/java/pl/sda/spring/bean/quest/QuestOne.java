package pl.sda.spring.bean.quest;

import lombok.*;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class QuestOne implements Quest{
    private String description = "QuestOne";

    public void doQuest(){
        System.out.println(description);
    }
}
