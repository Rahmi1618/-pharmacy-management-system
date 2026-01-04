class Pharmacist extends User {
    private String licenseNumber;
    
    public Pharmacist(String userId, String username, String password, 
                     String fullName, String email, String licenseNumber) {
        super(userId, username, password, fullName, "Pharmacist", email);
        this.licenseNumber = licenseNumber;
    }
    
    public String getLicenseNumber() { return licenseNumber; }
    
    // Pharmacist-specific methods
    public boolean validatePrescription(Prescription prescription) {
        System.out.println("Pharmacist validating prescription: " + prescription.getPrescriptionId());
        return prescription.validate();
    }
    
    public void manageInventory(Inventory inventory) {
        System.out.println("Pharmacist managing inventory");
        List<Medicine> lowStock = inventory.getLowStockMedicines();
        if (!lowStock.isEmpty()) {
            System.out.println("Low stock alert for: " + lowStock);
        }
    }
    
    public Report generateReport(String reportType) {
        Report report = new Report(reportType);
        System.out.println("Pharmacist generated report: " + reportType);
        return report;
    }
    
    @Override
    public void performRoleSpecificTasks() {
        System.out.println("Pharmacist tasks: Prescription validation, inventory management");
    }
}