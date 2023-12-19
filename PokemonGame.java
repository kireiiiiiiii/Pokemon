//SITES USED
//https://emojicombos.com/pokemon-dot-art - pokemon ascii arts
//https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Pokemon%20%20%20Game - text 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketPermission;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import PokemonLibrary.*;

public class PokemonGame {
    public static final String USERPATH = "/Users/matejstastny/Library/CloudStorage/OneDrive-LakeWashingtonSchoolDistrict/1. AP CS/Pokemon";
    public static final String COLORRESET = "\u001B[0m";
    public static final String[] POKEMONLIST = { "pichu", "pikachu", "raichu", "bulbasaur", "eevee", "flareon" };
    public static final String[] POKEMONBASELIST = { "pichu", "bulbasaur", "eevee" };
    public static final String[] CLASSLIST = { "Electric", "Seed", "Normal", "Fire" };

    public static boolean customPokemon = false;
    public static String pokemonName;
    public static int pokemonHp;
    public static String pokemonColour;
    public static String pokemonImage;
    public static String pokemonClass;
    public static String pokemonType;
    public static String[] pokemonAbilities = new String[2];
    public static String pokemonStage;

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        PokemonLibrary library = new PokemonLibrary();
        File preset1 = new File("preset1.txt");
        // PROGRAM

        System.out.println(library.welcomeImage);
        String[] users = listUsers(USERPATH);
        File user = getUser(console, users, USERPATH);
        if (user == null) {
            user = createUser(console, users);
            // setUser(user, USERPATH);
        }

        if (scanForLast(preset1, console)) {
            String[] array = loadLastPokemon(preset1);
            if (array != null) {
                unpackArray(array);
                if (!laysInArray(pokemonType, POKEMONLIST) || !laysInArray(pokemonClass, CLASSLIST)) {
                    customPokemon = true;
                    System.out.println("Custom pokemon detected, some things might not work as intended!");
                }
            } else {
                System.out.println("File invalid:\n" + Arrays.toString(array) + COLORRESET);
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
                pokemonAbilities, pokemonHp);
        console(pokemon, library, console, user);

    }

    /**
     * Converts a string array to a String with elements being separated by coma and
     * space (', ')
     * 
     * @param array - parameter - its the array that is going to be printed
     * @return return all the strings in the array separated by commas and spaces
     */
    public static String arrayToString(String[] array, String divider, String start) {
        int lenght = array.length - 1;
        if (lenght < 0) {
            return "";
        }
        String output = "";
        for (int i = 0; i < lenght; i++) {
            output += start + array[i] + divider;
        }
        output += start + array[lenght];
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
                System.out.println("Invalid Pokemon, you can only choose " + arrayToString(list, ", ", "") + "...");
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
        System.out.print("What do you want to name your " + pokemonType + "?: ");
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
     * Assigns current variables to be used, doesnt workd for custom pokemons
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
        if (laysInArray(pokemon, POKEMONLIST)) {
            customPokemon = false;
        }

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
    public static void console(Pokemon pokemon, PokemonLibrary library, Scanner console, File user) {
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
                if (customPokemon) {
                    System.out.println("You can't evolve custom pokemons!");
                } else {
                    if (pokemonStage != null) {
                        changePokemon(pokemonStage, library);
                        pokemon.updatePokemon(pokemonName, pokemonType, pokemonClass, pokemonImage, pokemonColour,
                                pokemonAbilities);
                        System.out.println("Your pokemon evolved to " + pokemonType + "!");
                    } else {
                        System.out.println("This pokemon doesn't evolve further...");
                    }
                }
            } else if (commandInput.equalsIgnoreCase("delete account")) {
                deleteUser(user, console);
                break;
            } else {
                System.out.println("I didn't understand...");
                System.out.println("You can only use these commands:");
                System.out.println(
                        "     stats\n     ability 1\n     ability 2\n     evolve\n     image\n     close pokemon\n     delete account");
            }
        }
    }

    /**
     * Loads variables into an array accordning to 'example.txt' file
     * 
     * @param preset1 - file that the program will load from
     * @return - returns an array of variables according to 'example.txt', returns
     *         null if the file is invalid (shorter than expected)
     */
    public static String[] loadLastPokemon(File preset1) {
        assert (preset1.exists()) : "file does not exist (load last pokemon)";
        String[] variableArray = new String[9];
        try {
            Scanner fileScanner = new Scanner(preset1);
            for (int y = 0; y < 8; y++) {
                if (!fileScanner.hasNext()) {
                    return null;
                }
                variableArray[y] = fileScanner.nextLine();
            }
            if (!fileScanner.hasNext()) {
                variableArray[8] = "no image";
            } else {
                variableArray[8] = fileScanner.nextLine();
            }
            while (fileScanner.hasNextLine()) {
                variableArray[8] += "\n" + fileScanner.nextLine();
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.print("There was an error when handeling the file");
        }
        if (variableArray[4].equals("null")){
            variableArray[4] = null;
        }
        return variableArray;
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

    /**
     * Assigns all variables from the array created by scanForLast and assigns them
     * to proper variables according to 'example.txt'
     * 
     * @param array - the array its supposed to unpack
     */
    public static void unpackArray(String[] array) {
        assert (array.length == 9) : "Array does not have correct ammount of elements (unpackArray)";
        pokemonName = array[0];
        pokemonType = array[1];
        pokemonClass = array[2];
        pokemonHp = Integer.parseInt(array[3]);
        pokemonStage = array[4];
        pokemonColour = array[5];
        pokemonAbilities[0] = array[6];
        pokemonAbilities[1] = array[7];
        pokemonImage = array[8];
    }

    /**
     * Scans for a file, if it exists, it will scan for if its empty or not, if its
     * not it will ask the user if he wants to load his preset or not
     * 
     * @param preset1 - file that it scans for
     * @param console - scanner with system.in for answer of the user
     * @return - return false if the file should not load and true if it should load
     */
    public static boolean scanForLast(File preset1, Scanner console) {
        if (!preset1.exists()) {
            try {
                preset1.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occured when creating the file: " + preset1.getName());
            }
            return false;
        } else if (preset1.length() == 0) {
            return false;
        } else {
            System.out.print("Do you want to load your saved pokemon? (y/n): ");
            String answer = console.nextLine();
            while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
                System.out.println("Try typing 'y' for yes, or 'n' for no! ");
                System.out.print("(y/n): ");
                answer = console.nextLine();
            }
            if (answer.equalsIgnoreCase("y")) {
                System.out.println("Ok, the file will load!");
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * This method lists all users (*USER.txt files) in the folder
     * 
     * @param path - path of the folder where the user files are stored
     * @return - returnes an array of all users created it path
     */
    public static String[] listUsers(String path) {
        File dir = new File(path);
        int userCount = 0;
        for (File file : dir.listFiles()) {
            Scanner s;
            try {
                s = new Scanner(file);
                if (user(file.getName())) {
                    userCount++;
                }
            } catch (FileNotFoundException e) {
                // System.out.println("ERROR: File not found");
            }
        }
        String[] users = new String[userCount];
        int i = 0;
        for (File file : dir.listFiles()) {
            Scanner s;
            try {
                s = new Scanner(file);
                if (user(file.getName())) {
                    users[i] = file.getName().substring(0, file.getName().length() - 8);
                    i++;
                }
            } catch (FileNotFoundException e) {
                // System.out.println("File not found");
            }
        }
        return users;
    }

    /**
     * Checks if file is a user data file
     * 
     * @param file - name of the file its checking
     * @return - returnes true/false
     */
    public static boolean user(String file) {
        int lenght = file.length() - 1;
        return file.substring(lenght - 7).equals("USER.txt");
    }

    /**
     * Prompts user to select an account
     * 
     * @param console - Scanner with System.in
     * @param users   - array of names of current user accounts
     * @param path    - path of user files
     * @return - return a file object set to the file of the user selected
     */
    public static File getUser(Scanner console, String[] users, String path) {
        System.out.println(
                "Which user do you select?:\n" + arrayToString(users, "\n", "--") + "\nCREATE NEW USER" + "\n");
        String user = console.nextLine();
        while (!laysInArray(user, users) && !user.equalsIgnoreCase("Create new user")) {
            System.out.print("This user does not exist...\nTry another one: ");
            user = console.nextLine();
        }
        if (!user.equalsIgnoreCase("Create new user")) {
            System.out.println("Welcome back " + user + "!");
        } else {
            return null;
        }
        File currUser = new File(user + "USER.txt");
        return currUser;
    }

    /**
     * Prompts user to create his new account, it will create a new file named
     * 'accountnameUSER.txt'
     * 
     * @param console - scanner with System.in
     * @param users   - array of current user accounts
     * @return - returns a file obj set to the file of the newly created user
     */
    public static File createUser(Scanner console, String[] users) {
        System.out.print("Create a username: ");
        String username = console.nextLine();
        while (laysInArray(username, users)) {
            System.out.print("This username already exists...\nTry another one: ");
            username = console.nextLine();
        }
        File newUser = new File(username + "USER.txt");
        try {
            newUser.createNewFile();
            System.out.println("User created succesfully!");
        } catch (IOException e) {
            System.out.println("There was an error while creating new user file");
        }
        return newUser;
    }

    /**
     * It will delete the data file of the user, it will promt the user to confirm
     * its deletion
     * 
     * @param currUser - user which file will be deleted
     * @param console  - scanner with System.in
     */
    public static void deleteUser(File currUser, Scanner console) {
        System.out.print("Are you sure to delete your account? (y/n): ");
        String answer = console.nextLine();
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            System.out.println("I didn't understand...\nTry typing y/n: ");
            answer = console.nextLine();
        }
        if (answer.equalsIgnoreCase("n")) {

        } else {
            currUser.delete();
        }
    }
}
