//SITES USED
//https://emojicombos.com/pokemon-dot-art - pokemon ascii arts
//https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Pokemon%20%20%20Game - text 

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PokemonsUI {
    public static final String[] POKEMONLIST = { "pichu", "pikachu", "raichu", "bulbasaur", "eevee", "flareon" };
    public static final String[] POKEMONBASELIST = { "pichu", "bulbasaur", "eevee" };

    public static String pokemonName;
    public static int pokemonHp;
    public static String pokemonColour;
    public static String pokemonImage;
    public static String pokemonClass;
    public static String pokemonType;
    public static String[] pokemonAbilities = new String[2];
    public static String pokemonStage;

    public static String[] lastArray = new String[20];

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        PokemonLibrary library = new PokemonLibrary();
        File preset1 = new File("preset1.txt");
        // PROGRAM

        System.out.println(library.welcomeImage);

        if (preset1.exists() && preset1.length() != 0) {
            lastArray = loadLastPokemon(preset1, console);
            if (lastArray != null) {
                unpackArray(lastArray, sb);
            } else {
                pokemonType = getPokemonType(console, POKEMONBASELIST);
                pokemonName = getName(console);
                changePokemon(pokemonType, library);
            }
        } else {
            pokemonType = getPokemonType(console, POKEMONBASELIST);
            pokemonName = getName(console);
            changePokemon(pokemonType, library);
        }
        Pokemon pokemon = new Pokemon(pokemonName, pokemonType, pokemonClass, pokemonImage, pokemonColour,
                pokemonAbilities);
        console(pokemon, library, console);

    }

    /**
     * Converts a string array to a String with elements being separated by coma and
     * space (', ')
     * 
     * @param array - parameter - its the array that is going to be printed
     * @return return all the strings in the array separated by commas and spaces
     */
    public static String arrayToString(String[] array) {
        int lenght = array.length - 1;
        if (lenght < 0) {
            return "";
        }
        String output = "";
        for (int i = 0; i < lenght; i++) {
            output += array[i] + ", ";
        }
        output += array[lenght];
        return output;
    }

    /**
     * Promts user to choose a pokemon type, than compares it with the list of
     * current pokemons, if the pokemon is not
     * in the list, it promts the user again
     * 
     * @param console - Scanner
     * @return - returns a String of the pokemon type
     */
    public static String getPokemonType(Scanner console, String[] list) {
        System.out.print("Choose your pokemon!: ");
        String pokemonType;
        while (true) {
            pokemonType = console.nextLine();
            if (laysInArray(pokemonType, list)) {
                System.out.println(pokemonType.substring(0, 1).toUpperCase() + pokemonType.substring(1) + " selected!");
                break;
            } else {
                System.out.println("Invalid Pokemon, you can only choose " + arrayToString(list) + "...");
            }
        }
        return pokemonType;
    }

    /**
     * Searches a String array if it contains target String with ignoring the case
     * 
     * @param search   - the string youre searching for
     * @param searched - the array that is being searched
     * @return - returns a boolean, true if found, false if not
     */
    public static boolean laysInArray(String search, String[] searched) {
        for (String element : searched) {
            if (search.equalsIgnoreCase(element)) {
                return true;
            }
        }
        return false;
    }

    public static String getName(Scanner console) {
        System.out.print("What do you want your " + pokemonType + "?: ");
        String name = console.nextLine();
        while (name.equalsIgnoreCase("") || name == null || name.equalsIgnoreCase(" ")) {
            System.out.println("Sorry, but you can't name your pokemon like this...");
            System.out.print("Try another one: ");
            name = console.nextLine();
        }
        System.out.println("Your " + pokemonType + " was named " + name + "! What a nice name!");
        return name;
    }

    /**
     * Assigns current variables to be used
     * 
     * @param pokemon - pokemon type, target pokemon, its variables will be assigned
     * @param library - library of pokemons
     */
    public static void changePokemon(String pokemon, PokemonLibrary library) {
        // pokemonHp = ;
        // pokemonColour = ;
        // pokemonImage = ;
        // pokemonClass = ;
        // pokemonType = ;
        // pokemonAbilities = ;
        // pokemonStageCount = ;

        if (pokemon.equalsIgnoreCase("pichu")) {
            pokemonHp = library.pichuHp;
            pokemonColour = library.pichuColour;
            pokemonImage = library.pichuImage;
            pokemonClass = library.pichuClass;
            pokemonType = library.pichuType;
            pokemonAbilities = library.pichuAbilities;
            pokemonStage = library.pichuStage;
        } else if (pokemon.equalsIgnoreCase("pikachu")) {
            pokemonHp = library.pikachuHp;
            pokemonColour = library.pikachuColour;
            pokemonImage = library.pikachuImage;
            pokemonClass = library.pikachuClass;
            pokemonType = library.pikachuType;
            pokemonAbilities = library.pikachuAbilities;
            pokemonStage = library.pikachuStage;
        } else if (pokemon.equalsIgnoreCase("raichu")) {
            pokemonHp = library.raichuHp;
            pokemonColour = library.raichuColour;
            pokemonImage = library.raichuImage;
            pokemonClass = library.raichuClass;
            pokemonType = library.raichuType;
            pokemonAbilities = library.raichuAbilities;
            pokemonStage = library.raichuStage;
        } else if (pokemon.equalsIgnoreCase("bulbasaur")) {
            pokemonHp = library.bulbasaurHp;
            pokemonColour = library.bulbasaurColour;
            pokemonImage = library.bulbasaurImage;
            pokemonClass = library.bulbasaurClass;
            pokemonType = library.bulbasaurType;
            pokemonAbilities = library.bulbasaurAbilies;
            pokemonStage = library.bulbasaurStage;
        } else if (pokemon.equalsIgnoreCase("eevee")) {
            pokemonHp = library.eeveeHp;
            pokemonColour = library.eeveeColour;
            pokemonImage = library.eeveeImage;
            pokemonClass = library.eeveeClass;
            pokemonType = library.eeveeType;
            pokemonAbilities = library.eeveeAbilities;
            pokemonStage = library.eeveeStage;
        } else if (pokemon.equals("flareon")) {
            pokemonHp = library.flareonHp;
            pokemonColour = library.flareonColor;
            pokemonImage = library.flareonImage;
            pokemonClass = library.flareonClass;
            pokemonType = library.flareonType;
            pokemonAbilities = library.flareonAbilities;
            pokemonStage = library.flareonStage;
        } else {
            assert (false) : "Variable assign failed, wrong pokemon type input";
        }
    }

    /**
     * The console for the Pokemon Game
     * 
     * @param pokemon - Pokemon Obj
     * @param library - Pokemon Library Obj.
     * @param console - User input Scanner
     */
    public static void console(Pokemon pokemon, PokemonLibrary library, Scanner console) {
        String commandInput;

        while (true) {
            System.out.print("\nWhat sould I do?: ");
            commandInput = console.nextLine();
            if (commandInput.equals("ability 1")) {
                pokemon.ability1();
            } else if (commandInput.equalsIgnoreCase("ability 2")) {
                pokemon.ability2();
            } else if (commandInput.equalsIgnoreCase("image")) {
                pokemon.image();
            } else if (commandInput.equalsIgnoreCase("stats")) {
                System.out.println(pokemon);
            } else if (commandInput.equalsIgnoreCase("close pokemon")) {
                System.out.print("Do you want to save your pokemon? (y/n): ");
                String answer = console.nextLine();
                while (true) {
                    if (answer.equalsIgnoreCase("y")) {
                        savePokemon("preset1.txt");
                        System.out.println("Pokemon saved succesfully!\nBye!");
                        break;
                    } else if (answer.equalsIgnoreCase("n")) {
                        System.out.println("Bye!");
                        break;
                    } else {
                        System.out.println("Answer y/n!: ");
                        answer = console.nextLine();
                    }
                }
                break;
            } else if (commandInput.equalsIgnoreCase("evolve")) {
                if (pokemonStage != null) {
                    changePokemon(pokemonStage, library);
                    pokemon.updatePokemon(pokemonName, pokemonType, pokemonClass, pokemonImage, pokemonColour,
                            pokemonAbilities);
                    System.out.println("Your pokemon evolved to " + pokemonType + "!");
                } else {
                    System.out.println("This pokemon doesn't evolve further...");
                }
            } else {
                System.out.println("I didn't understand...");
                System.out.println("You can only use these commands:");
                System.out.println(
                        "     stats\n     ability 1\n     ability 2\n     evolve\n     image\n     close pokemon");
            }
        }
    }

    /**
     * Loads variables into an array accordning to 'example.txt' file
     * 
     * @param preset1 - file that the program will load from
     * @param console - scanner with system.in for y/n
     * @return - returns an array of variables according to 'example.txt'
     */
    public static String[] loadLastPokemon(File preset1, Scanner console) {
        if (preset1.exists() && preset1.length() != 0) {
            System.out.print("Do you want to load your file? (y/n): ");
            String fileyn = "";
            String[] variableArray = new String[10];
            while (true) {
                fileyn = console.nextLine();
                if (fileyn.equalsIgnoreCase("y")) {
                    System.out.println("File loading...");
                    try {
                        Scanner fileScanner = new Scanner(preset1);
                        for (int y = 0; y < 9; y++) {
                            variableArray[y] = fileScanner.nextLine();
                        }
                        variableArray[9] = fileScanner.nextLine();
                        while (fileScanner.hasNextLine()) {
                            variableArray[9] += "\n" + fileScanner.nextLine();
                        }
                        break;
                    } catch (IOException e) {
                        System.out.print("There was an error when handeling the file");
                        break;
                    }
                } else if (fileyn.equalsIgnoreCase("n")) {
                    System.out.println("Ok!");
                    return null;
                } else {
                    System.out.print("Invalid answer, answe y/n: ");
                }
            }
            return variableArray;
        }
        return null;
    }

    /**
     * This method saves variables of the active pokemon according to the
     * 'example.txt' file
     * 
     * @param fileName - directory of the file to be saved in, it will overwrite the
     *                 file
     */
    public static void savePokemon(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(pokemonName + "\n" + pokemonType + "\n" + pokemonClass + "\n" + pokemonHp + "\n" + pokemonStage
                    + "\n" + pokemonColour + "\n" + pokemonAbilities[0] + "\n" + pokemonAbilities[1] + "\n"
                    + pokemonImage);
            fw.close();
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }

    public static void unpackArray(String[] array, StringBuilder sb) {
        assert (array.length == 10) : "Array does not have correct ammount of elements (unpackArray)";
        pokemonName = array[0];
        pokemonType = array[1];
        pokemonClass = array[2];
        pokemonHp = Integer.parseInt(array[3]);
        pokemonStage = array[4];
        pokemonColour = array[5];
        pokemonAbilities[0] = array[6];
        pokemonAbilities[1] = array[7];
        pokemonImage = array[9];
    }
}
