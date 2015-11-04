
public class ItemDetail {
	String name;
	int num;
	String boxNum;
	String bagNum;
	
	public ItemDetail(String name, int num, String boxNum, String bagNum) {
		this.name = name;
		this.num = num;
		this.boxNum = boxNum;
		this.bagNum = bagNum;
	}
	
	public void addBox(String boxNum) {
		this.boxNum += ", " + boxNum;
	}
	
	public void addBag(String bagNum) {
		if (!bagNum.equals("")) {
			this.bagNum += ", " + bagNum;
		}
	}
	
	public void addNum(int num) {
		this.num += num;
	}
	
	//TODO: change boxNum and bagNum to arrayList<Integer> and sort it when done
	
}
