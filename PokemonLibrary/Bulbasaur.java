package PokemonLibrary;

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
    private static String stage = null;
    private static String[] abilities = {"Whine whip", "Razor leaf"};
    private static String colour = "\u001b[42m";

    public Bulbasaur(String name, int currHp) {
        super(name, type, element, image, colour, abilities, currHp, maxHp);
    }

    public Bulbasaur(String name) {
        super(name, type, element, image, colour, abilities, maxHp, maxHp);
    }
}
