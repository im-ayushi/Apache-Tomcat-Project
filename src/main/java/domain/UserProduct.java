package domain;

import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class UserProduct {
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.image);
		return base64Image;
		}
		public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
		}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sno;

	private String name;
	private String quantity;
	private int size;
	@Lob
	private byte[] image;
	
	@Transient
	private String base64Image;
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@ManyToOne	
	private UserDetails details_id;
	
	public UserProduct() {
		super();
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public UserDetails getDetails_id() {
		return details_id;
	}
	public void setDetails_id(UserDetails details_id) {
		this.details_id = details_id;
	}
	public UserProduct(int sno, String name, String quantity, UserDetails details_id, int size) {
		super();
		this.sno = sno;
		this.name = name;
		this.quantity = quantity;
		this.details_id = details_id;
		this.size = size;
	}	
}
