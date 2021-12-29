package metier.entities;

	import java.io.Serializable;

	public class LoginEntity implements Serializable {
	 
	    private String email;
	    private String password;
	    private String role;

	    public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
	}
