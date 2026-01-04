abstract class User {
    protected String userId;
    protected String username;
    protected String password;
    protected String fullName;
    protected String role;
    protected String email;
    
    public User(String userId, String username, String password, 
               String fullName, String role, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.email = email;
    }
    
    // Getters
    public String getUserId() { return userId; }
    public String getFullName() { return fullName; }
    public String getRole() { return role; }
    
    // Authentication Methods
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public void logout() {
        System.out.println(fullName + " has logged out.");
    }
    
    public void updateProfile(String fullName, String email) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        }
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        }
    }
    
    public abstract void performRoleSpecificTasks();
    
    @Override
    public String toString() {
        return String.format("User[ID: %s, Name: %s, Role: %s]", 
            userId, fullName, role);
    }
}