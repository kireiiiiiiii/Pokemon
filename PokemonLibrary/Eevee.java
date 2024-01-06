package PokemonLibrary;

public class Eevee extends Pokemon {
    private static String image = "Im sorry, but Eevee doesn't have a picture yet...";
    private static String element = "Normal";
    private static String type = "Eevee";
    private static int maxHp = 60;
    private static String stage = "flareon";
    private static String[] abilities = {"Be Prepared", "Bite"};
    private static String colour = "\u001b[47m";

    public Eevee(String name, int currHp) {
        super(name, type, element, image, colour, abilities, currHp, maxHp);
    }

    public Eevee(String name) {
        super(name, type, element, image, colour, abilities, maxHp, maxHp);
    }
}
