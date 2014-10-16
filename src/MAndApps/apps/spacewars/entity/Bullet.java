package MAndApps.apps.spacewars.entity;

import MAndApps.apps.spacewars.Entity;
import MAndApps.apps.spacewars.entity.bullet.BasicPlayerBullet;
import MAndApps.apps.spacewars.entity.bullet.PlayerExplodeBullet;
import MAndApps.apps.spacewars.entity.bullet.PlayerImpactBullet;
import MAndApps.apps.spacewars.entity.bullet.PlayerPiercingBullet;

public abstract class Bullet extends Entity {
	//these are the bullet identities. i think its fairly self explanatory..
	//public static final int NAME_OF_BULLET_TYPE = some_number_not_being_used_as_another_id;
	public static final int BASIC = 0;
	public static final int PLAYER_PIERCE_ONE = 1;
	public static final int PLAYER_PIERCE_TWO = 2;
	public static final int PLAYER_PIERCE_THREE = 3;
	public static final int PLAYER_PIERCE_FOUR = 4;
	public static final int PLAYER_PIERCE_FIVE = 5;
	public static final int PLAYER_PIERCE_SIX = 6; 
	public static final int PLAYER_PIERCE_SEVEN = 7; 
	public static final int PLAYER_PIERCE_EIGHT = 8;
	public static final int PLAYER_PIERCE_NINE = 9;
	public static final int PLAYER_PIERCE_TEN = 10; 
	public static final int PLAYER_EXPLOSIVE_ONE = 11;
	public static final int PLAYER_EXPLOSIVE_TWO = 12;
	public static final int PLAYER_EXPLOSIVE_THREE = 13;
	public static final int PLAYER_EXPLOSIVE_FOUR = 14;
	public static final int PLAYER_EXPLOSIVE_FIVE = 15;
	public static final int PLAYER_EXPLOSIVE_SIX = 16;
	public static final int PLAYER_EXPLOSIVE_SEVEN = 17;
	public static final int PLAYER_EXPLOSIVE_EIGHT = 18;
	public static final int PLAYER_EXPLOSIVE_NINE = 19;
	public static final int PLAYER_EXPLOSIVE_TEN = 20;
	public static final int PLAYER_IMPACT_ONE = 21;
	public static final int PLAYER_IMPACT_TWO = 22;
	public static final int PLAYER_IMPACT_THREE = 23;
	public static final int PLAYER_IMPACT_FOUR = 24;
	public static final int PLAYER_IMPACT_FIVE = 25;
	public static final int PLAYER_IMPACT_SIX = 26;
	public static final int PLAYER_IMPACT_SEVEN = 27;
	public static final int PLAYER_IMPACT_EIGHT = 28;
	public static final int PLAYER_IMPACT_NINE = 29;
	public static final int PLAYER_IMPACT_TEN = 30;
	public static final int PLAYER_GODMODE = 31;
	public Bullet(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

    /**
     * bullet class now references here to get the cool down for the current bullet
     * updates upon ammo change or initialization of a gun type.
     * @param bulletType
     * @return
     */
    public static int getCooldown(int bulletType){
        switch (bulletType){
            case BASIC:
                return 25;
            case PLAYER_PIERCE_ONE:
                return 20;
            case PLAYER_PIERCE_TWO:
                return 18;
            case PLAYER_PIERCE_THREE:
                return 16;
            case PLAYER_PIERCE_FOUR:
                return 14;
            case PLAYER_PIERCE_FIVE:
                return 12;
            case PLAYER_PIERCE_SIX:
                return 10;
            case PLAYER_PIERCE_SEVEN:
                return 8;
            case PLAYER_PIERCE_EIGHT:
                return 6;
            case PLAYER_PIERCE_NINE:
                return 4;
            case PLAYER_PIERCE_TEN:
                return 2;
            case PLAYER_EXPLOSIVE_ONE:
                return 50;
            case PLAYER_EXPLOSIVE_TWO:
                return 48;
            case PLAYER_EXPLOSIVE_THREE:
                return 46;
            case PLAYER_EXPLOSIVE_FOUR:
                return 44;
            case PLAYER_EXPLOSIVE_FIVE:
                return 42;
            case PLAYER_EXPLOSIVE_SIX:
                return 40;
            case PLAYER_EXPLOSIVE_SEVEN:
                return 38;
            case PLAYER_EXPLOSIVE_EIGHT:
                return 36;
            case PLAYER_EXPLOSIVE_NINE:
                return 34;
            case PLAYER_EXPLOSIVE_TEN:
                return 32;
            case PLAYER_GODMODE:
                return 0;
            default:
                return 25;
        }
    }
	
	public static Bullet getNewBullet(int bulletType, int x, int y, int direction){
		switch(bulletType){
		//this is the literal bit that goes through and indexes what to do
		//with certain IDs that you defined above..
		//formatting is simple, cases can not go after the default so
		//they must be added in between it and the last "case"
		
		//return new PlayerPiercingBullet(direction, x, y, 2);
		
		//this returns a new pierce bullet at position x(this parameter
		//was passed via the function...) and y(also passed), with a 
		//direction, direction(also passed in..), with a pierce amount of
		//whatever is entered in place of the 2.
		//inside the parenthesis, in the returns, are called
		//"arguments" or "parameters". 
		case BASIC:
			return new BasicPlayerBullet(direction, x, y);
		case PLAYER_PIERCE_ONE:
			return new PlayerPiercingBullet(direction, x, y, 2, false);
		case PLAYER_PIERCE_TWO:
			return new PlayerPiercingBullet(direction, x, y, 3, false);
		case PLAYER_PIERCE_THREE:
			return new PlayerPiercingBullet(direction, x, y, 4, false);
		case PLAYER_PIERCE_FOUR:
			return new PlayerPiercingBullet(direction, x, y, 5, false);
		case PLAYER_PIERCE_FIVE:
			return new PlayerPiercingBullet(direction, x, y, 6, false);
		case PLAYER_PIERCE_SIX:
			return new PlayerPiercingBullet(direction, x, y, 7, false);
		case PLAYER_PIERCE_SEVEN:
			return new PlayerPiercingBullet(direction, x, y, 8, false);
		case PLAYER_PIERCE_EIGHT:
			return new PlayerPiercingBullet(direction, x, y, 9, false);
		case PLAYER_PIERCE_NINE:
			return new PlayerPiercingBullet(direction, x, y, 10, false);
		case PLAYER_PIERCE_TEN:
			return new PlayerPiercingBullet(direction, x, y, 15, true);	
		case PLAYER_EXPLOSIVE_ONE:
			return new PlayerExplodeBullet(direction, x, y, 2);
		case PLAYER_EXPLOSIVE_TWO:
			return new PlayerExplodeBullet(direction, x, y, 3);
		case PLAYER_EXPLOSIVE_THREE:
			return new PlayerExplodeBullet(direction, x , y, 4);
		case PLAYER_EXPLOSIVE_FOUR:
			return new PlayerExplodeBullet(direction, x, y, 5);
		case PLAYER_EXPLOSIVE_FIVE:
			return new PlayerExplodeBullet(direction, x, y, 6);
		case PLAYER_EXPLOSIVE_SIX:
			return new PlayerExplodeBullet(direction, x, y, 7);
		case PLAYER_EXPLOSIVE_SEVEN:
			return new PlayerExplodeBullet(direction, x, y, 8);
		case PLAYER_EXPLOSIVE_EIGHT:
			return new PlayerExplodeBullet(direction, x, y, 9);
		case PLAYER_EXPLOSIVE_NINE:
			return new PlayerExplodeBullet(direction, x, y, 10);
		case PLAYER_EXPLOSIVE_TEN:
			return new PlayerExplodeBullet(direction, x, y, 15); 
		case PLAYER_IMPACT_ONE:
			return new PlayerImpactBullet(direction, x, y, 1);
		case PLAYER_IMPACT_TWO:
			return new PlayerImpactBullet(direction, x, y, 2);
		case PLAYER_IMPACT_THREE:
			return new PlayerImpactBullet(direction, x, y, 3);
		case PLAYER_IMPACT_FOUR:
			return new PlayerImpactBullet(direction, x, y, 4);
		case PLAYER_IMPACT_FIVE:
			return new PlayerImpactBullet(direction, x, y, 5);
		case PLAYER_IMPACT_SIX:
			return new PlayerImpactBullet(direction, x, y, 6);
		case PLAYER_IMPACT_SEVEN:
			return new PlayerImpactBullet(direction, x, y, 7);
		case PLAYER_IMPACT_EIGHT:
			return new PlayerImpactBullet(direction, x, y, 8);
		case PLAYER_IMPACT_NINE:
			return new PlayerImpactBullet(direction, x, y, 9);
		case PLAYER_IMPACT_TEN:
			return new PlayerImpactBullet(direction, x, y, 10);
		case PLAYER_GODMODE:
			return new PlayerExplodeBullet(direction, x, y, 200);
		default://if the bullet type passed in for this function is not one of the above cases..
			return new BasicPlayerBullet(direction, x, y);//return it a basic bullet.
		}
	}
	
	public abstract boolean getAlive();
	public abstract int getDamage();
    public abstract int getWIDTH();
    public abstract int getHEIGHT();
}
