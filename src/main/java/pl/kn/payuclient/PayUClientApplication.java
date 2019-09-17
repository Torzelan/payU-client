package pl.kn.payuclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.kn.payuclient.model.OrderRequest;
import pl.kn.payuclient.model.Product;
import pl.kn.payuclient.model.Settings;

@SpringBootApplication
public class PayUClientApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(PayUClientApplication.class, args);
        var payUClient = ctx.getBean(PayUClient.class);
        payUClient.authorize("145227", "12f071174cb7eb79d4aac5bc2f07563f");

        var settings = new Settings();
        settings.setInvoiceDisabled(true);

        var product = new Product();
        product.setName("Wireless Mouse for Laptop");
        product.setUnitPrice("15000");
        product.setQuantity("1");

        var orderRequest = new OrderRequest.Builder()
                .notifyUrl("https://your.eshop.com/notify")
                .customerIp("127.0.0.1")
                .merchantPosId("300746")
                .description("RTV market")
                .currencyCode("PLN")
                .totalAmount("21000")
                .buildBuyer().email("john.doe@example.com").phone("654111654").firstName("John").lastName("Doe").language("pl").setBuyer()
                .settings(settings)
                .addProduct(product)
                .build();
        var response = payUClient.order(orderRequest);
    }

}
