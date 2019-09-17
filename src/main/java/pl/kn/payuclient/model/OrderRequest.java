package pl.kn.payuclient.model;

import java.util.ArrayList;
import java.util.List;

public class OrderRequest {

    private String notifyUrl;
    private String customerIp;
    private String merchantPosId;
    private String description;
    private String currencyCode;
    private String totalAmount;
    private Buyer buyer;
    private Settings settings;
    private List<Product> products;

    private OrderRequest() {
    }

    public static class Builder {
        private String notifyUrl;
        private String customerIp;
        private String merchantPosId;
        private String description;
        private String currencyCode;
        private String totalAmount;
        private Buyer buyer;
        private Settings settings;
        private List<Product> products = new ArrayList<>();

        public Builder() {
        }

        public Builder notifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public Builder customerIp(String customerIp) {
            this.customerIp = customerIp;
            return this;
        }

        public Builder merchantPosId(String merchantPosId) {
            this.merchantPosId = merchantPosId;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder currencyCode(String currencyCode) {
            this.currencyCode = currencyCode;
            return this;
        }

        public Builder totalAmount(String totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Buyer.Builder buildBuyer() {
            return new Buyer.Builder(this);
        }

        public Builder setBuyer(Buyer buyer) {
            this.buyer = buyer;
            return this;
        }

        public Builder settings(Settings settings) {
            this.settings = settings;
            return this;
        }

        public Builder addProduct(Product product) {
            this.products.add(product);
            return this;
        }

        public OrderRequest build() {
            var order = new OrderRequest();
            order.notifyUrl = this.notifyUrl;
            order.customerIp = this.customerIp;
            order.merchantPosId = this.merchantPosId;
            order.description = this.description;
            order.currencyCode = this.currencyCode;
            order.totalAmount = this.totalAmount;
            order.buyer = this.buyer;
            order.settings = this.settings;
            order.products = this.products;
            return order;
        }
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public String getCustomerIp() {
        return customerIp;
    }

    public String getMerchantPosId() {
        return merchantPosId;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Settings getSettings() {
        return settings;
    }

    public List<Product> getProducts() {
        return products;
    }
}
