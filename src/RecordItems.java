import java.util.HashMap;
import java.util.Scanner;

public class RecordItems {

	
	
	
	public static void main (String args[]) {
		HashMap<String, ItemDetail> records = new HashMap<String, ItemDetail>();
		System.out.println("item,\t\tnumber,\t\tbox num,\t\t[bag num]\t\t");
		System.out.println("comma-separated values");
		System.out.println("print \"exit\" to stop recording");
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.contains("exit")) {
				break;
			}
			String[] items = line.split(",");
			while (items.length < 3 || items.length > 4) {
				System.out.println("You entered " + items.length + " values. I think you missed a \",\" somewhere. Please re-enter the values");
				line = sc.nextLine(); 
				items = line.split(",");
			}
			String itemName = items[0].trim();
			int num = Integer.parseInt(items[1].trim());
			String boxNum = items[2].trim();
			System.out.println("got boxNum " + boxNum);
			String bagNum = "";
			if (items.length == 4) {
				bagNum = items[3].trim();
			}
			ItemDetail itemDetail = new ItemDetail(itemName, num, boxNum, bagNum);
			// If we haven't entered it, just add it
			if (!records.containsKey(itemName)) {
				records.put(itemName, itemDetail);
			// If it already exists, add the values
			} else {
				ItemDetail existingItemDetail = records.get(itemName);
				existingItemDetail.addNum(num);
				existingItemDetail.addBox(boxNum);
				existingItemDetail.addBag(bagNum);
			}
		}
		sc.close();
		
		// Print out the details in a table
		String format = "%20s %7s %15s %10s\n";
		System.out.format(format, "Item", "Number", "Box num", "Bag num");
		for (String itemName: records.keySet()) {
			ItemDetail itemDetail = records.get(itemName);
			System.out.format(format, 
					itemName, itemDetail.num, itemDetail.boxNum, itemDetail.bagNum);
		}
	}
	
	
}
