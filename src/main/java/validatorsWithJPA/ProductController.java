package validatorsWithJPA;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products")
public class ProductController  extends HttpServlet {

    @Inject
    ProductRepo productRepo;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        Integer quantity = Integer.valueOf(req.getParameter("quantity"));

        Product product = new Product(name,desc,quantity);

        productRepo.add(product);
    }
}
