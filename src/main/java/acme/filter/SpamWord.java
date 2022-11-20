package acme.filter;


public class SpamWord {
	
	private final String name;
	
	private final double weight;
	
	private final String boost;
	
	public SpamWord(final String name, final double weight, final String boost) {
		super();
		this.name = name;
		this.weight = weight;
		this.boost = boost;
	}


	public String getName() {
		return this.name;
	}

	
	public double getWeight() {
		return this.weight;
	}

	
	public String getBoost() {
		return this.boost;
	}

}
