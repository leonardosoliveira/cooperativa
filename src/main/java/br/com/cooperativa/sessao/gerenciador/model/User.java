package br.com.cooperativa.sessao.gerenciador.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	private Boolean enabled;
	
	@ElementCollection
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "username"))
	private Set<Authority> authorities = new HashSet<>();
	
	
	@Embeddable
	public class Authority  {

	    private String authority;

	    public Authority() {
	    }

	    public Authority(String authority) {
	        this.authority = authority;
	    }
	}    
	
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	
	

}
