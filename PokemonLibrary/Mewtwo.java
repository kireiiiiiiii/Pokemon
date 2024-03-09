package PokemonLibrary;

public class Mewtwo extends Pokemon {
    private static String[] imageArray = {
            "                              :=--:.    .                 ",
            "                               :- ::.   --.               ",
            "                               :-  -=-==:.:               ",
            "                              .=.  .    .::               ",
            "                              =          :=               ",
            "                             -:   ..   .  :-              ",
            "                             :-    :=: .:  --             ",
            "                  :+. :=.     :+.  .::: - :=.             ",
            "                 .-    :-    *.:+-.      :-               ",
            "                  =.  .==:::.*==*=. +=-..-:               ",
            "              .:=+=++=. .==--==-:.::-=:=:.                ",
            "             .-:   --  :-.   +: ..      :=.               ",
            "    .----:--..-:   +:----.   -- ..    : ::-.              ",
            "  .--.     .-=--::---..---:::==.  .::.::.-.-.             ",
            " .=-  .--.    :=.             .--       ==:.:-=:          ",
            " :+  -=..-*.   .=:              :-.     ::.-=:  -:        ",
            " -- .=:   .+:   .=:              -:     .-:  :-. :-       ",
            " =- .=:    .=:    --            .-:      .::  .=. :=.     ",
            " :+  =-     :=.    :+         +-.  ..: :..-+=.  .= .--    ",
            " .+- :-.     -=     .==     +:        +.   .-==. *    =:  ",
            "  :+. --.     ==      .=+::+.         =.    ::.+-: .. .=- ",
            "   -+. -=.    .+-        :-.          --     -. %.+:-::=- ",
            "    -=.  =+:   .+:      .-:           -:    .-. +=*+..=:  ",
            "     ==.   .+-. .+:     --.           +     -:  *.  .:.   ",
            "      -=.    .-=..*-    -:           -:   .--  .+         ",
            "       :+:      --.-+:  ::         .-:   .-:  .+.         ",
            "        .+-      -- .-=-:-.       -=.  --:   :=.          ",
            "          :=:     *    :+-.     :*+---+.   .-=.           ",
            "           .-+-. :+     -:    .-:     ::  .--             ",
            "              .::.      -:    =.      =.  :-              ",
            "                       .-.   +      --==. :=.             ",
            "                      .--  --*:     ==. .: --.            ",
            "                     .--  :. =:      =-:=   .+:           ",
            "                    .=.   :.:+         .=     .++:...     ",
            "                  .=-      =.           .-:      ...:-.   ",
            "                :=:  ...   -:             :-.      .:=:   ",
            "                =:  .:     -:               --:.  ..-:    ",
            "                .=-::+.  .--                  .:---:.     ",
            "                   ...----.                               "
    };
    private static String image = saveImage(imageArray);
    private static String element = "Psychic";
    private static String type = "Mewtwo";
    private static int maxHp = 280;
    private static String[] stageType = null;
    private static String[] abilities = { "Psy Purge", "Star Raid" };
    private static String colour = "\u001B[35m"; // purple

    public Mewtwo(String name, int currHp) {
        super(name, type, element, image, colour, abilities, stageType, currHp, maxHp);
    }

    public Mewtwo(String name) {
        super(name, type, element, image, colour, abilities, stageType, maxHp, maxHp);
    }
}
