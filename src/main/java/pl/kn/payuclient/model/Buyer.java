package pl.kn.payuclient.model;

public class Buyer {

    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String language;

    private Buyer(String email, String phone, String firstName, String lastName, String language) {
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    public static class Builder {
        private OrderRequest.Builder orderRequestBuilder;

        private String email;
        private String phone;
        private String firstName;
        private String lastName;
        private String language;

        Builder(OrderRequest.Builder orderRequestBuilder) {
            this.orderRequestBuilder = orderRequestBuilder;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder language(String language) {
            this.language = language;
            return this;
        }

        public OrderRequest.Builder setBuyer() {
            orderRequestBuilder.setBuyer(new Buyer(email, phone, firstName, lastName, language));
            return orderRequestBuilder;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLanguage() {
        return language;
    }
}
