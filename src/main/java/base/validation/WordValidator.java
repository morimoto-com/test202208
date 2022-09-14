package base.validation;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WordValidator implements ConstraintValidator<Word, String>{
    Word word;

    @Override
    public void initialize(Word word) {
        this.word = word;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // 任意のバリデーション処理を実装
        // NULLor空の場合はチェックしない（チェックは@NotNullに任せる）
        if (StringUtils.isEmpty(value)) {
            return true;
        }
        return Arrays.asList(word.value()).contains(value);
    }
}
