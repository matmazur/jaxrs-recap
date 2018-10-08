package validators.beans;

import validators.annotations.Divided;

import javax.validation.constraints.Min;

public class NumberBean {

    @Divided(by = 2)
    @Min(4)
    private Integer num;

    public NumberBean() {
    }

    public NumberBean(@Min(4) Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
