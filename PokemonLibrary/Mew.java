package PokemonLibrary;

public class Mew extends Pokemon {
    private static String[] imageArray = {
            "                 .::..:                               ",
            "               .:..  ..                               ",
            "            .::    .:.                                ",
            "          .:.    ..:......:::::                       ",
            "         :..    .:::...      .-.                      ",
            "       .:.  :......           ..                      ",
            "    ..:. ...-.           ...  .:.                     ",
            "    .:.:.:.  :.        ..-:=-  ..                     ",
            "  .:.:.      ....-:.   ....--- ..                     ",
            " .:-         - -.++.    .= :: ...   ..:-==:-:...--=:..",
            ".::.         .....-.     .. .-::-:.:-::.           .:-",
            "::.          ..:..:.     ..-.::....::.             .:-",
            "-:               .--....:-.    ........           .::.",
            "-:............-::-..-  .=.     ...              .:... ",
            " .:.:----:.:-.   .:..:.:.=       -.           .::.:   ",
            "                 ....    =        ...       .:.:..    ",
            "                         =          ..:   :.:...      ",
            "                        .=     -.     ....:..         ",
            "                       .==     .:      :-.            ",
            "                       ...      .:      ..            ",
            "                       .-...     ...   .::            ",
            "                       ...:.-:.....:.... :.           ",
            "                       .=  :.  ...    .:. :.          ",
            "                        =   -.         :. .:.         ",
            "                        .-   -.        :.  .:.        ",
            "                         ..  .:.        ..  :.        ",
            "                         .:-..:.        :.   :.       ",
            "                           .::.         -.    -       ",
            "                                        ..: .:-       ",
            "                                         .::.-:       "
    };
    private static String image = saveImage(imageArray);
    private static String element = "Psychic";
    private static String type = "Mew";
    private static int maxHp = 60;
    private static String[] stageType = { "Mewtwo" };
    private static String[] abilities = { "Mysterious Tail", "Psyshot" };
    private static String colour = "\u001B[35m"; // purple

    public Mew(String name, int currHp) {
        super(name, type, element, image, colour, abilities, stageType, currHp, maxHp);
    }

    public Mew(String name) {
        super(name, type, element, image, colour, abilities, stageType, maxHp, maxHp);
    }
}
