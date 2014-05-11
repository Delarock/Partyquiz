package Players;

import java.util.ArrayList;

/**
 *
 * @author Morten
 */
public class PlayerList extends ArrayList<Player>{
    public PlayerList()
    {
        
        //int playerNumber = Game.SelectPlayersFXMLController.numberOfPlayers;
        
    }
    public void addPlayers(int Number){
        
        this.add(new Player(Game.SelectPlayersFXMLController.getName1()));
        this.add(new Player(Game.SelectPlayersFXMLController.getName2()));
        if (Number >=2)
            this.get(1).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName3()));
        if (Number >=3)
            this.get(2).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName4()));
        if (Number >=4)
            this.get(3).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName5()));
        if (Number >=5)
            this.get(4).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName6()));
        if (Number >=6)
            this.get(5).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName7()));
        if (Number >=7)
            this.get(6).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName8()));
        if (Number >=8)
            this.get(7).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName9()));
        if (Number >=9)
            this.get(8).setActive();
        this.add(new Player(Game.SelectPlayersFXMLController.getName10()));
        if (Number >=10)
            this.get(9).setActive();
    }
   
}
