package Entity;

public class WaterGate {
	private String id;
	private String name_gate;
	private String buildtime;
	private String responsible;
	private String longitude;
	private String dimensionality;
	private String intro;

	

	public WaterGate(String name_gate, String id, String buildtime, String responsible, String longitude,
			String dimensionality, String intro) {
		super();
		this.id = id;
		this.name_gate = name_gate;
		this.buildtime = buildtime;
		this.responsible = responsible;
		this.longitude = longitude;
		this.dimensionality = dimensionality;
		this.intro = intro;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName_gate() {
		return name_gate;
	}
	
	public void setName_gate(String name_gate) {
		this.name_gate = name_gate;
	}
	
	public String getBuildtime() {
		return buildtime;
	}
	
	public void setBuildtime(String buildtime) {
		this.buildtime = buildtime;
	}
	
	public String getResponsible() {
		return responsible;
	}
	
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getDimensionality() {
		return dimensionality;
	}
	
	public void setDimensionality(String dimensionality) {
		this.dimensionality = dimensionality;
	}
	
	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
}
