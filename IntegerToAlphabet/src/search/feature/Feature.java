package search.feature;


public abstract class Feature implements IFeature{
	
	String name;
	
	public Feature(String name) {
		super();
		this.name = name;
	}

	@Override
	public String name() {
		return name;
	}

}
