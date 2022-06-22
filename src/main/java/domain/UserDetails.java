package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserDetails {
		@Id
		private String username;
		private String password;
		@OneToMany(mappedBy = "details_id")
		private List<UserProduct> productId;


		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}


		public UserDetails() {
			// TODO Auto-generated constructor stub
		}

		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public List<UserProduct> getProductId() {
			return productId;
		}
		public void setProductId(List<UserProduct> productId) {
			this.productId = productId;
		}

		public UserDetails(String username, String password, List<UserProduct> productId) {
			super();
			this.username = username;
			this.password = password;
			this.productId = productId;
		}		
}
