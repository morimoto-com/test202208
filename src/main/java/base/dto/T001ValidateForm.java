package base.dto;

import base.constants.ValidationGroup.Button1;
import base.constants.ValidationGroup.Button2;
import base.validation.Word;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;

@Getter
@Setter
public class T001ValidateForm {

    @Size(min= 1, max = 4, message = "{t001.validation.range}", groups = Button1.class)
    private String text1;

    @Word(value = {"あ", "い"} , groups = {Button1.class, Button2.class})
    private String text2;

    @AssertTrue(message = "{t001.validation.multiRequired}" , groups = Button2.class)
    // 必ずpublic booleanにする
    // lombokの場合boolean型のgetterはisXXXXなのでメソッド名はisから始める
    public boolean isTextEmpty(){
        // ここに任意の相関チェックを実装
        if (StringUtils.isEmpty(text1) && StringUtils.isEmpty(text2)) {
            return false;
        }
        return true;
    }
}
