package pl.sda.spring.bean.quest;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class QuestTwo implements Quest{
    private String description = "QuestTwo";

    public void doQuest(){
        System.out.println(description);
    }
}
