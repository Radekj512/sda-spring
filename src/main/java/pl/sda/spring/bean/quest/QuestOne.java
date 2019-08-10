package pl.sda.spring.bean.quest;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestOne implements Quest{
    private String description = "QuestOne";

    public void doQuest(){
        System.out.println(description);
    }
}
