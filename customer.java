class Customer {
    private String customerId;
    private String fullName;
    private String phone;
    private String email;
    private int loyaltyPoints;
    private List<Sale> purchaseHistory;
    
    public Customer(String customerId, String fullName, String phone, String email) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.loyaltyPoints = 0;
        this.purchaseHistory = new ArrayList<>();
    }
    
    // Getters
    public String getCustomerId() { return customerId; }
    public String getFullName() { return fullName; }
    public int getLoyaltyPoints() { return loyaltyPoints; }
    
    // Business Methods
    public void addLoyaltyPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }
    
    public void redeemPoints(int points) {
        if (points > 0 && points <= loyaltyPoints) {
            loyaltyPoints -= points;
        }
    }
    
    public void updateProfile(String fullName, String phone, String email) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        }
        if (phone != null && !phone.trim().isEmpty()) {
            this.phone = phone;
        }
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        }
    }
    
    public void addPurchase(Sale sale) {
        purchaseHistory.add(sale);
        // Add loyalty points based on purchase amount
        int points = (int)(sale.getFinalAmount() / 10);
        addLoyaltyPoints(points);
    }
    
    public List<Sale> getPurchaseHistory() {
        return new ArrayList<>(purchaseHistory);
    }
    
    @Override
    public String toString() {
        return String.format("Customer[ID: %s, Name: %s, Points: %d]", 
            customerId, fullName, loyaltyPoints);
    }
}