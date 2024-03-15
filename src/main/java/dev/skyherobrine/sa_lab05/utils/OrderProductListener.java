package dev.skyherobrine.sa_lab05.utils;

import dev.skyherobrine.sa_lab05.models.OrderProduct;
import dev.skyherobrine.sa_lab05.models.Person;
import dev.skyherobrine.sa_lab05.services.impl.OrderProductService;
import dev.skyherobrine.sa_lab05.services.impl.PersonService;
import jakarta.jms.Message;
import jakarta.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class OrderProductListener {

    @Autowired
    private OrderProductService ops;
    @Autowired
    private PersonService personService;
    @Autowired
    private JavaMailSender mailSender;

    @JmsListener(destination = "order_product")
    public String receiveOrder(final Message message) throws Exception {
        String textMessage = "";
        if(message instanceof TextMessage) {
            //Read message
            TextMessage tm = (TextMessage) message;
            textMessage = tm.getText();

            //Decode message to OrderProduct
            OrderProduct op = (OrderProduct) ConvertToObject.convertJsonToOject(EncodeDecodeMessage.decodeMessage(textMessage), OrderProduct.class);

            //Check quantity to enough
            if(op.getProduct().getQuantity() - op.getQuantity() < 0) {
                return "Failed";
            }

            //Make order:
            personService.save(op.getPerson());
            ops.save(op);

            //Send email
            SimpleMailMessage smm = new SimpleMailMessage();
            smm.setFrom("skyherobrine13092003@gmail.com");
            smm.setTo(op.getPerson().getEmail());
            smm.setSubject("Status Order Your Product");
            smm.setText("Your order has been received and is being processed. Thank you for your order!");
            mailSender.send(smm);
        }
        return "Success";
    }
}
