package lv.bc.io;

public class Word {
	private String fromText;
	private String toText;
	private int count;

	public Word(String fromText, String toText, int count) {
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

	@Override
	public String toString() {
		return "Word [fromText=" + fromText + ", toText=" + toText + ", count=" + count + "]";
	}
}
