package dev.skyherobrine.sa_lab05.controllers;

import com.google.gson.Gson;
import dev.skyherobrine.sa_lab05.models.OrderProduct;
import dev.skyherobrine.sa_lab05.models.Person;
import dev.skyherobrine.sa_lab05.models.Product;
import dev.skyherobrine.sa_lab05.services.impl.OrderProductService;
import dev.skyherobrine.sa_lab05.services.impl.PersonService;
import dev.skyherobrine.sa_lab05.services.impl.ProductService;
import dev.skyherobrine.sa_lab05.utils.ConvertToJson;
import dev.skyherobrine.sa_lab05.utils.EncodeDecodeMessage;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("/order-product")
public class OrderProductController {
    @Autowired
    private OrderProductService ops;
    @Autowired
    private PersonService personService;
    @Autowired
    private ProductService productService;
    @Autowired
    private JmsTemplate template;

    @GetMapping
    public ModelAndView directToIndex() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("products", productService.findAll());
        return mav;
    }

    @PostMapping("/order")
    public ModelAndView makeOrder(HttpServletRequest request) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String productID = request.getParameter("product");
        String quantity = request.getParameter("quantity");

        Person person = personService.findPersonByPhone(phone).orElse(null);
        if (person == null)
            person = new Person(name, gender.equalsIgnoreCase("Male"), address, phone, email);
        Product product = productService.findById(Long.parseLong(productID)).orElse(null);

        OrderProduct op = new OrderProduct(LocalDate.now(), person, product, Integer.parseInt(quantity));
        String textEncode = EncodeDecodeMessage.encodeMessage(ConvertToJson.convertObjectToJson(op));

        TextMessage message = (TextMessage) template.sendAndReceive("order_product", (Session session) -> session.createTextMessage(textEncode));

        mav.addObject("products", productService.findAll());
        mav.addObject("status", message.getText().equalsIgnoreCase("Success") ? "S" : "F");
        return mav;
    }
}
