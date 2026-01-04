class Admin extends User {
    
    public Admin(String userId, String username, String password, 
                String fullName, String email) {
        super(userId, username, password, fullName, "Admin", email);
    }
    
    // Admin-specific methods
    public void manageUsers(List<User> users, User userToManage, String action) {
        System.out.println("Admin managing user: " + userToManage.getFullName());
        if ("disable".equals(action)) {
            System.out.println("User disabled");
        } else if ("enable".equals(action)) {
            System.out.println("User enabled");
        }
    }
    
    public void systemConfiguration(String configType, String value) {
        System.out.println("Configuring system: " + configType + " = " + value);
    }
    
    public void backupData(String backupLocation) {
        System.out.println("Backing up data to: " + backupLocation);
        // Implementation for data backup
    }
    
    public Report generateReport(String reportType) {
        Report report = new Report(reportType);
        return report;
    }
    
    @Override
    public void performRoleSpecificTasks() {
        System.out.println("Admin tasks: User management, system configuration, backups");
    }
}