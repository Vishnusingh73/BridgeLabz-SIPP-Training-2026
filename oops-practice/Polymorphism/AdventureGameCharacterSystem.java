abstract class GameCharacter {
    String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public abstract void performAttack();
}

class Warrior extends GameCharacter {
    public Warrior(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " swings a sword with mighty force!");
    }
}

class Mage extends GameCharacter {
    public Mage(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " casts a powerful fireball!");
    }
}

class Archer extends GameCharacter {
    public Archer(String characterName) {
        super(characterName);
    }

    @Override
    public void performAttack() {
        System.out.println(characterName + " fires a precise arrow!");
    }
}

public class AdventureGameCharacterSystem {
    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Thorin"),
            new Mage("Luna"),
            new Archer("Robin"),
            new Warrior("Drogo")
        };

        startBattle(characters);
    }

    private static void startBattle(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        System.out.println("Battle started:");
        for (GameCharacter character : characters) {
            character.performAttack();
            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println();
        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }
}
