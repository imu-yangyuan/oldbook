package bean;

/**
 * School entity. @author MyEclipse Persistence Tools
 */

public class School implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String place;
	private String type;
	private String properties;

	// Constructors

	/** default constructor */
	public School() {
	}

	/** full constructor */
	public School(String name, String place, String type, String properties) {
		this.name = name;
		this.place = place;
		this.type = type;
		this.properties = properties;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProperties() {
		return this.properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

}