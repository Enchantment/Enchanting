package Engine.Game;

import java.util.Scanner;

import Engine.Game.Utilities.Maths.Vector.Vec2f;

public class CommandInterpreter {
	public static void interpretCommand(String command){
		Scanner scanner = new Scanner(command);
		String action = scanner.next();
		switch(action){
			case "kick":{
				//Kick player <playername>
				String playerName = scanner.next();	
				break;
			}
			case "ban":{
				//Ban player <playername>
				String playerName = scanner.next();
				break;
			}
			case "pardon":{
				//Pardon player <playername>
				String playerName = scanner.next();
				break;
			}	
			case "give":{
				//Give player <playername><item><ammount>
				String playerName = scanner.next();
				int itemID = scanner.nextInt();
				int ammount = 1;
				if(scanner.hasNextInt()) ammount = scanner.nextInt();
				break;	
			}
			case "spawn":{
				//Spawn Monster/Object at said location. Must check if there's an object in there.
				String entity = scanner.next();
				Vec2f entityLocation = new Vec2f(scanner.nextInt(), scanner.nextInt());
				break;
			}
			case "suicide":{
				//Kill player
				break;
			}
			case "tp":{
				//tp player <playername> to location <x><y>
				String playerName = scanner.next();
				break;
			}
			case "xp":{
				//give player <playername> <ammount> of xp
				String playerName = scanner.next();
				int xp = scanner.nextInt();
				break;
			}
			case "debug":{
				//Set's debug mode on/off <on|off>
				String state = scanner.next();
				break;
			}
			case "time":{
				//Set time at...
				break;
			}
			default:
				break;
		}
	}
}
