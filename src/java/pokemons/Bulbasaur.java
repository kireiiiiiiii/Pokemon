/*
 * Author: Matěj Šťastný
 * Date created: 12/17/2023
 * Github link: https://github.com/kireiiiiiiii/Pokemon
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package src.java.pokemons;

/**
 * Bulbosaur pokemon class
 * 
 */
public class Bulbasaur extends Pokemon {
    private static String[] imageArray = {
            "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⡀",
            " ⠀⠀⢀⡀⠀⠀       ⠀⠠⠐⠂⠀⠁⠀⠀⠀⠀",
            " ⠀⠰⡁⠐⢉⣉⣭⡍⠁⠂⠉⠘⡀ ⠀⠀⠀⠀⠂⠡⠀",
            " ⢀⣊⠀⡄⠻⠿⠋⠀⠀⠀⠀⠀⢃⠀⠀⠀⠀⠀⠀⢀",
            " ⡎⣾⠀⠁⣴⡆⠀⠡⢺⣿⣆⠀⢠⢱⣄⠀⠀⠀⠀⠈",
            " ⡑⠟⠀⠀⠀⠀⠀⢀⣸⡿⠟⠀⠀⠈⢿⣿⡦⡀⠀⡰",
            " ⠙⠔⠦⣤⣥⣤⣤⣤⡤⠆⠀⠀⠀⠀⢀⢀⠀⠈⠎⠀",
            " ⠀⠀⠈⣰⡋⢉⠉⠁⠒⠂⢇⢠⡆⠀⠸⢴⣿⠀⠘⠀",
            " ⠀⠀⠘⡿⠃⠀⠨⠒⢆⣸⣿⠁⠀⡠⡇⠈⠋⠀⠰⠀",
            " ⠀⠀⠀⠛⠒⠒⠁⠀⠈⠷⡤⠤⠐⠀⠘⠒⠒⠖⠁⠀"
    };
    private static String image = saveImage(imageArray);
    private static String element = "Seed";
    private static String type = "Bulbasaur";
    private static int maxHp = 70;
    private static String[] stageType = null;
    private static String[] abilities = { "Whine whip", "Razor leaf" };
    private static String colour = "\u001b[42m";

    public Bulbasaur(String name, int currHp) {
        super(name, type, element, image, colour, abilities, stageType, currHp, maxHp);
    }

    public Bulbasaur(String name) {
        super(name, type, element, image, colour, abilities, stageType, maxHp, maxHp);
    }
}
