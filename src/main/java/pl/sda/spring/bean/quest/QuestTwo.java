package pl.sda.spring.bean.quest;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class QuestTwo implements Quest{
    private String description = "QuestTwo";

    public void doQuest(){
        System.out.println(description);
    }
}
