package lv.bc.io;

public class Word {
	private int key;
	private String fromText;
	private String toText;
	private int count;
	
	public Word(){
		
	}
	public Word(int key, String fromText, String toText, int count) {
		super();
		this.key = key;
		this.fromText = fromText;
		this.toText = toText;
		this.count = count;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
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
		return "Word [key=" + key + " fromText=" + fromText + ", toText=" + toText + ", count=" + count + "]";
	}
	

}
