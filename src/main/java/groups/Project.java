package groups;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

public class Project {


    @NotNull(groups = Draft.class)
    @Size(min = 3, groups = Draft.class)
    private String title;
    @NotNull(groups = Draft.class)
    @Past(groups = Draft.class)
    private LocalDate date;
    @NotNull(groups = Complete.class)
    @Size(min = 10, groups = Complete.class)
    private String description;
    @NotNull(groups = Complete.class)
    @Size(min = 3, groups = Complete.class)
    private String owner;


    public Project(String title, LocalDate date, String description, String owner) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.owner = owner;
    }

    public Project() {
    }


    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(title, project.title) &&
                Objects.equals(date, project.date) &&
                Objects.equals(description, project.description) &&
                Objects.equals(owner, project.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date, description, owner);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
