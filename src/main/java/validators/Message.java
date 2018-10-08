package validators;

import utils.Language;

import javax.validation.constraints.NotNull;

public class Message {


    @NotNull
    private String title;

    @NotNull
    @NonVulgar(lang = {Language.ENG,Language.PL})
    private String content;

    public Message(@NotNull String title, @NotNull String content) {
        this.title = title;
        this.content = content;
    }

    public Message() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
