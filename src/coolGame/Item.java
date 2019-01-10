//Create the items and add them to the item array list

package coolGame;

import java.util.ArrayList;

public class Item {
	String name;
	String description;

	static void createAllItems (ArrayList<Item> itemList) {
		Item i = new Item();
		i.name = "Food";
		itemList.add(i);

		i = new Item();
		i.name = "Knife";
		itemList.add(i);

		i = new Item();
		i.name = "Spoon";
		itemList.add(i);

		i = new Item();
		i.name = "Bed";
		itemList.add(i);

		i = new Item();
		i.name = "Prisoner";
		itemList.add(i);

		i = new Item();
		i.name = "Map";
		itemList.add(i);

		i = new Item();
		i.name = "Boat";
		itemList.add(i);
	}

}
