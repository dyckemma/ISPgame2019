/*Create the rooms and add them to the array list
 * provide function of each room
 */

package coolGame;

import java.util.ArrayList;

public class Room {

	String name;
	String description;
	static int currentroom = 0;
	ArrayList<Item> itemlist = new ArrayList<Item>();

	static void createAllRooms (ArrayList<Room> roomList) {
		Room r = new Room();
		r.name = "prison";
		r.description = "You are in the prison, Chateau D'If. A maximum security prison on an island in the middle of nowhere.";
		roomList.add(r);

		r = new Room();
		r.name = "hallway";
		r.description = "You made it to the hallway. The walls are mossy and you smell sweat mixed with the metallic smell of the guards' armour and the beautiful, natural musk of the prison itself.";
		roomList.add(r);

		r = new Room();
		r.name = "front of prison";
		r.description = "You are in front of the prison.";
		roomList.add(r);

		r = new Room();
		r.name = "back of prison";
		r.description = "You are behind the prison.";
		roomList.add(r);
	}
	
	

}
