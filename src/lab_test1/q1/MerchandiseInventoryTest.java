package lab_test1.q1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class MerchandiseInventoryTest{
	public static void main(String[] args) {
		ArrayList<Merchandise> MerchandiseInventory = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			
			String line;
			while((line = br.readLine())!=null) {
				if(line.isEmpty()) {
					continue;
				}
				String[] values = line.split(" ");
				String itemCode = values[0];
				int quantity = Integer.parseInt(values[1]);
				double unitPrice = Double.parseDouble(values[2]);
				MerchandiseInventory.add(new Merchandise(itemCode, quantity, unitPrice));
			}
			
			System.out.println("Before Sorting: ");
			display(MerchandiseInventory);
			
			
			System.out.println("After sorting by ItemId in ascending order: ");
			Collections.sort(MerchandiseInventory, new MerchandiseItemIdComparatorAsc());
			display(MerchandiseInventory);
			
			System.out.println("After sorting by Price in descending order: ");
			Collections.sort(MerchandiseInventory, new MerchandisePriceComparatorDesc());
			display(MerchandiseInventory);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		} 
	}
	
	public static void display(ArrayList<Merchandise> MerchandiseInventory) {
		for(Merchandise merchandise: MerchandiseInventory) {
			System.out.println(merchandise);
		}
		System.out.println();
	}
}
