package by.edu.grsu.jkh.datamodel;
import java.io.Serializable;

public class AbstractModel implements Serializable {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(final Long id) {
		this.id = id;
	}
}
