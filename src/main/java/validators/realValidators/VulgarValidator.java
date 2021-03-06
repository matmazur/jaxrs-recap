package validators.realValidators;

import validators.utils.Language;
import validators.annotations.NonVulgar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VulgarValidator implements ConstraintValidator<NonVulgar, String> {

    private Language[] languages;

    @Override
    public void initialize(NonVulgar annotation) {
        this.languages = annotation.lang();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean valid = true;
        for (Language lang : languages) {
            if (lang == Language.PL)
                valid &= plFilter(value);
            if (lang == Language.ENG)
                valid &= enFilter(value);
        }
        return valid;
    }

    private boolean plFilter(String text) {
        List<String> badWords = Arrays.asList("kurwa", "dupa");
        return generalFilter(text, badWords);
    }

    private boolean enFilter(String text) {
        List<String> badWords = Arrays.asList("fuck", "ass");
        return generalFilter(text, badWords);
    }

    private boolean generalFilter(String text, List<String> badWords) {
        List<String> found = badWords
                .stream()
                .filter(text::contains)
                .collect(Collectors.toList());
        return found.isEmpty();
    }
}