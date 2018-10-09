package groups;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@WebServlet("/project")
public class ProjectController extends HttpServlet {

    @Inject
    Validator validator;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String title = req.getParameter("title");
        LocalDate date = null;
        try {
            date = LocalDate.parse(req.getParameter("date"));
        } catch (Exception e) {
            System.out.println("date was incorrect");
        }
        String description = req.getParameter("description");
        String owner = req.getParameter("owner");
        String saveType = req.getParameter("save");

        if (!(date == null)) {
            Project project = new Project(title, date, description, owner);

            if (saveType.equals("Draft")) {
                System.out.println("Draft group chosen");
                saveDraft(project);
            } else if (saveType.equals("Complete")) {
                System.out.println("Complete group chosen");
                saveComplete(project);
            }
        } else {
            System.out.println("Please enter correct date");
        }
        resp.sendRedirect(req.getContextPath());
    }

    public void saveDraft(Project project) {
        Set<ConstraintViolation<Project>> violations = validator.validate(project, Draft.class);
        printViolations(violations);
    }

    public void saveComplete(Project project) {
        Set<ConstraintViolation<Project>> violations = validator.validate(project, Full.class);
        printViolations(violations);
    }

    private <T> void printViolations(Set<ConstraintViolation<T>> set) {
        for (ConstraintViolation<T> v : set) {
            System.out.println(v.getPropertyPath() + " - " + v.getInvalidValue() + " - " + v.getMessage());
        }
    }
}
