package lv.bc.io;

public class Topic {
	private String fromText;
	private String toText;
	private int count;

	public Topic(String fromText, String toText, int count) {
		super();
		this.fromText = fromText;
		this.toText = toText;
		this.count = count;
	}
	
	public String getFromText() {
		return fromText;
	}
	public void setFromText(String fromText) {
		this.fromText = fromText;
	}
	public String getToText() {
		return toText;
	}
	public void setToText(String toText) {
		this.toText = toText;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
