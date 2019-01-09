package coolGame;

import java.util.ArrayList;

public class Room {

	String name;
	String description;
	ArrayList<Item> itemlist = new ArrayList<Item>();

	static void createAllRooms (ArrayList<Room> roomList) {
		//CREATE FIRST ROOM
		Room r = new Room();
		r.name = "prison";
		r.description = "You are in the prison, Chateau D'If. A maximum security prison on an island in the middle of nowhere.";
		roomList.add(r);

		//CREATE SECOND ROOM
		r = new Room();
		r.name = "hallway";
		r.description = "";
		roomList.add(r);

		//CREATE THIRD ROOM
		r = new Room();
		r.name = "";
		r.description = "";
		roomList.add(r);

		//CREATE FOURTH ROOM
		r = new Room();
		r.name = "";
		r.description = "";
		roomList.add(r);
	}

}
