package validators;

import validators.beans.Message;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet("/message-servlet")
public class MessageServlet extends HttpServlet {

    @Inject
    Validator validator;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String title = req.getParameter("title");
        String content = req.getParameter("content");

        Message msg = new Message(title, content);

        writer.println("title: " + title);

        Set<ConstraintViolation<Message>> validation = validator.validate(msg);

        for (ConstraintViolation<Message> v : validation) {
            System.out.println(validator.validate(msg));
            System.out.println(v.getPropertyPath() + " - " + v.getInvalidValue() + " - " + v.getMessage());
            writer.println(v.getPropertyPath() + " - " + v.getInvalidValue() + " - " + v.getMessage());
        }
    }
}
