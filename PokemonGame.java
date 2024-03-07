//Author: Matěj Šťastný
//GitHub link: https://github.com/rasix007/Pokemon

//SITES USED
//https://emojicombos.com/pokemon-dot-art - pokemon ascii arts
//https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Pokemon%20%20%20Game - text 
//https://stackoverflow.com/questions/10819469/hide-input-on-command-line - hide password

import java.io.File;
import java.io.FileInputStream;
import java.io.Console;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import PokemonLibrary.*;

public class PokemonGame {
    public static final String COLORRESET = "\u001B[0m";
    public static final String[] POKEMONLIST = { "pichu", "pikachu", "raichu", "bulbasaur", "eevee", "flareon" };
    public static final String[] BASE_POKEMONS = { "pichu", "bulbasaur", "eevee" };
    public static final String[] CLASSLIST = { "Electric", "Seed", "Normal", "Fire" };

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        File preset;
        File user;
        Pokemon pokemon;
        String path = getPath();

        printWelcome();
        user = setUser(console, path);
        preset = setPreset(user);

        String name = "";
        int hp = 0;
        String type = "";

        if (scanForLast(preset, user, console)) {
            int presetIndex = getPresetIndex(preset, console);
            String[] array = loadPokemon(preset, presetIndex);
            if (array != null) {
                name = array[1];
                hp = Integer.parseInt(array[2]);
                type = array[3].toLowerCase();
                pokemon = changePokemon(name, type, hp);
            } else {
                System.out.println("File invalid:\n" + Arrays.toString(array) + COLORRESET);
                type = getType(console, BASE_POKEMONS);
                name = getName(console);
                pokemon = changePokemon(name, type, -1);
            }
        } else {
            type = getType(console, BASE_POKEMONS);
            name = getName(console);
            pokemon = changePokemon(name, type, -1);
        }
        console(pokemon, console, user, preset);
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
     * Prints welcome ascii art
     */
    public static void printWelcome() {
        String[] welcomeArray = {
                "|------------------------------------------------------------------------------------------|",
                "|                                                                                          |",
                "| __________       __                                      ________                        |",
                "| \\______   \\____ |  | __ ____   _____   ____   ____      /  _____/_____    _____   ____   |",
                "|  |     ___/  _ \\|  |/ // __ \\ /     \\ /  _ \\ /    \\    /   \\  ___\\__  \\  /     \\_/ __ \\  |",
                "|  |    |  (  <_> )    <\\  ___/|  Y Y  (  <_> )   |  \\   \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  |",
                "|  |____|   \\____/|__|_ \\\\___  >__|_|  /\\____/|___|  /    \\______  (____  /__|_|  /\\___  > |",
                "|                      \\/    \\/      \\/            \\/            \\/     \\/      \\/     \\/  |",
                "|                                                                                          |",
                "|------------------------------------------------------------------------------------------|",
                " "
        };
        System.out.print(arrayToString(welcomeArray, "\n", ""));
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

    /**
     * Promts the user to name his pokemon
     * 
     * @param console - Scanner with system.in
     * @return - returns a string of the name
     */
    public static String getName(Scanner console) {
        System.out.print("What do you want to name your pokemon?: ");
        String name = console.nextLine();
        while (name.equalsIgnoreCase("") || name == null || name.equalsIgnoreCase(" ")) {
            System.out.println("Sorry, but you can't name your pokemon like this...");
            System.out.print("Try another one: ");
            name = console.nextLine();
        }
        System.out.println("Your pokemon was named " + name + "! What a nice name!");
        return name;
    }

    /**
     * Creates an object of the pokemon that the user selects
     * 
     * @param console - Scanner with System.in
     * @param name    - name of the pokemon, will be used as a param to the new onj.
     * @return - returns the pokemon obj.
     */
    public static Pokemon changePokemon(String name, String type, int hp) {
        type = type.toLowerCase();
        Pokemon pokemon = null;
        switch (type) {
            case "pichu":
                pokemon = new Pichu(name, hp);
                break;
            case "bulbasaur":
                pokemon = new Bulbasaur(name, hp);
                break;
            case "eevee":
                pokemon = new Eevee(name, hp);
                break;
            case "raichu":
                pokemon = new Raichu(name, hp);
                break;
            case "pikachu":
                pokemon = new Pikachu(name, hp);
                break;
            case "flareon":
                pokemon = new Flareon(name, hp);
                break;
            default:
                assert(false) : "changePokemon failed - wrong type: " + type;
        }
        return pokemon;
    }

    /**
     * Prompts user to choose a pokemon from a list
     * 
     * @param console - scanner with system.in
     * @param list    - list that he has to choose from
     * @return - string of type in lowercase
     */
    public static String getType(Scanner console, String[] list) {
        System.out.print("Choose your pokemon!: ");
        String type = console.nextLine().toLowerCase();
        while (!laysInArray(type, list)) {
            System.out.println("You can't choose that pokemon...\nPlease choose from "
                    + arrayToString(list, "", ", ").substring(2) + "...");
            type = console.nextLine().toLowerCase();
        }
        System.out.println(type.substring(0, 1).toUpperCase() + type.substring(1) + " selected!");
        return type;
    }

    /**
     * Prompts user to select his user, if valid enter password, if valid and in
     * less than number of attempts, than pass and assign file
     * If user types create new user, that create new user
     * TODO make exceptions to password, message with no password, also no naming
     * with spaces
     * 
     * @param console - scanner with system.in
     * @return - returns the file of the user
     */
    public static File setUser(Scanner console, String userPath) {
        File user = null;
        while (true) {
            String[] usersList = listUsers(userPath);
            user = getUser(console, usersList, userPath); // returns null if new user selected
            // new user
            if (user == null) {
                user = createUser(console, usersList);
                if (setPassword(user, console)) {
                    return user; // returns user if succesful
                } else {
                    user.delete(); // delets the file, so no empty files
                }
                // setUser(user, USERPATH);
            }
            // old user
            else {
                if (getPassword(user, console, 5)) {
                    return user; // returns the user if succesful
                } else {
                } // else - try again
            }
        }
    }

    /**
     * The console for the Pokemon Game
     * 
     * @param pokemon - Pokemon Obj
     * @param library - Pokemon Library Obj.
     * @param console - User input Scanner
     */
    public static void console(Pokemon pokemon, Scanner console2, File user, File preset) {
        String commandInput;
        Scanner console = new Scanner(System.in);
        Pokemon evolvePokemon;
        // TODO fix, so it uses normalPokemon
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
                pokemon.stats();
            } else if (commandInput.equalsIgnoreCase("close pokemon") || commandInput.equalsIgnoreCase("exit")) {
                System.out.print("Do you want to save your pokemon? (y/n): ");
                String answer = console.nextLine();
                while (true) {
                    if (answer.equalsIgnoreCase("y")) {
                        savePokemon(preset, user, pokemon);
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
                evolvePokemon = evolve(pokemon, console);
                if (evolvePokemon != null) {
                    pokemon = evolvePokemon;
                }
            } else if (commandInput.equalsIgnoreCase("delete account")) {
                deleteUser(user, preset, console);
                break;
            } else if (commandInput.equalsIgnoreCase("save pokemon")) {
                savePokemon(preset, user, pokemon);
                System.out.println("Pokemon saved sucesfully!");
            } else if (commandInput.equalsIgnoreCase("new pokemon")) {
                if (!savePokemon(preset, user, pokemon)){
                    System.out.print("Pokemon wasn't saved sucsfully... Do you want to continue? (y/n): ");
                    String input = console.nextLine();
                    while (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) {
                        System.out.println("Answer 'y' for yes and 'n' for no: ");
                        input = console.nextLine();
                    }
                    if (input.equalsIgnoreCase("y")) {
                        String type = getType(console, BASE_POKEMONS);
                        String name = getName(console);
                        pokemon = changePokemon(name, type, -1);
                    }
                }
                else {
                    String type = getType(console, BASE_POKEMONS);
                    String name = getName(console);
                    pokemon = changePokemon(name, type, -1);
                }
            } else {
                System.out.println("I didn't understand...");
                System.out.println("You can only use these commands:");
                System.out.println(
                        "     stats\n     ability 1\n     ability 2\n     evolve\n     new pokemon\n     image\n     close pokemon\n     save pokemon\n     delete account");
            }
        }
    }

    /**
     * Evolves the pokemon, asks user for confirmation, if the pokemon has more evolves, it asks the user for which one should be used
     * @param pokemon - current pokemon used
     * @param console - scanner with system.in
     * @return - returns the pokemon that evolved, or null if the user didnt confirm the evolve
     */
    public static Pokemon evolve(Pokemon pokemon, Scanner console) {
        String[] stageType = pokemon.getStageType();
        Pokemon evolved;
        if (stageType == null) {
            System.out.println("This pokemon doesn't evolve...");
            return null;
        }
        else if (stageType.length == 1) {
            System.out.print("Do you want to evolve your " + pokemon.getType() + " to " + stageType[0] + "? (y/n):");
            String answer = console.nextLine();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.print("I didn't understand...\nAnswer 'y' or 'n': ");
                answer = console.nextLine();
            }
            if (answer.equalsIgnoreCase("y")){
                evolved = changePokemon(pokemon.getName(), stageType[0], -1);
                System.out.println(evolved.getName() + " evolved to " + evolved.getType() + "!");
                return evolved;
            }
            else {
                return null;
            }
        }
        else {
            System.out.print("This pokemon can evolve to " + arrayToString(stageType, " or ", "") + ".\nWhich one do you want to evolve to?:");
            String answerType = console.nextLine();
            while (!laysInArray(answerType, stageType)) {
                System.out.print("You can only choose from " + arrayToString(stageType, ",", "") + "...\nTry again: ");
                answerType = console.nextLine();
            }
            System.out.print("Do you want to evolve your " + pokemon.getType() + " to " + answerType + "? (y/n): ");
            String answer = console.nextLine();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
                System.out.print("I didn't understand...\nAnswer 'y' or 'n': ");
                answer = console.nextLine();
            }
            if (answer.equalsIgnoreCase("y")){
                evolved = changePokemon(pokemon.getName(), answerType, -1);
                System.out.println(evolved.getName() + " evolved to " + evolved.getType() + "!");
                return evolved;
            }
            else {
                return null;
            }
        }
    }

    /**
     * Sets the user file, according to user, if the file for the preset doesn't exist it will create it
     * @param user - user file of the current user
     * @return - returns the file of the preset of the user given in @param
     */
    public static File setPreset(File user) {
        String username = readFileLine(user, 1);
        File preset = new File(username + "PRESET.txt");
        if (preset.exists()) {
            return preset;
        } else {
            try {
                preset.createNewFile();
            } catch (IOException e) {
                System.out.println("IO error");
            }
            return preset;
        }
    }

    /**
     * Counts the number of lines a file has
     * @param file - the file you want to read
     * @return - returns a int with the lines count
     */
    public static int countFileLines(File file) {
        if (!file.exists()) {
            System.out.print("File does not exist");
            return -1;
        }
        int lines = 0;
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                lines++;
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.print("There was an error when handeling the file");
            return -1;
        }
        return lines;
    }

    /**
     * TODO
     * @param preset
     * @param console
     * @return
     */
    public static int getPresetIndex(File preset, Scanner console) {
        if (!preset.exists()) {
            System.out.print("File does not exist");
            return -1;
        }
        int presetIndex = 0;
        boolean validInput = false;
        int presetCount = countFileLines(preset)/4;
        System.out.print("What pokemon do you select? ");
        while (!validInput) {
            System.out.println("Enter a number according to:");
            for (int i = 1; i <= presetCount; i++) {
                int currFileLine = i * 4;
                System.out.println("     " + i + ". " + readFileLine(preset, currFileLine));
            }
            System.out.print("\n> ");
            if (console.hasNextInt()) {
                presetIndex = console.nextInt();
                if (presetIndex > presetCount) {
                    System.out.println("I don't understand...");
                    console.next(); // consume the invalid input
                }
                else {
                    validInput = true;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                console.next(); // consume the invalid input
            }
        }
        System.out.println(readFileLine(preset, presetIndex * 4) + " selected!");
        return presetIndex;
    }

    /**
     * Returns a string of a line in a .txt file, prints error message if failed and
     * returns null
     * 
     * @param file - the file its reading
     * @param line - number of line its reading
     * @return
     */
    public static String readFileLine(File file, int line) {
        int lines = 0;
        if (!file.exists()) {
            System.out.print("File does not exist");
            return null;
        }
        if (line <= 0) {
            System.out.println("Not valid line (<=0)");
            return null;
        }
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                lines++;
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.print("There was an error when handeling the file");
            return null;
        }
        if (line > lines) {
            //System.out.println("Line out of index");
            return null;
        }
        try {
            int currLine = 1;
            Scanner fileScanner = new Scanner(file);
            String currString = "";
            while (fileScanner.hasNextLine()) {
                currString = fileScanner.nextLine();
                if (currLine == line) {
                    return currString;
                }
                currLine++;
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.print("There was an error when handeling the file");
            return null;
        }
        System.out.println("HUH");
        return null;
    }

    /**
     * This method saves variables of the active pokemon according to the
     * 'example.txt' file
     * 
     * @param fileName - directory of the file to be saved in, it will overwrite the
     *                 file
     */
    public static boolean savePokemon(File preset, File user, Pokemon pokemon) {
        assert (user.exists()) : "savePokemon - user file does not exist";
        int presetCount = countFileLines(preset)/4;
        if (presetCount >= 6) {
            System.out.println("Six pokemons already saved!");
            return false;
        }
        String userName = readFileLine(user, 1);
        int currHp = pokemon.getHp();
        String name = pokemon.getName();
        String type = pokemon.getType();
        try {
            FileWriter fw = new FileWriter(preset, true);
            if (presetCount == 0) {
                fw.write(userName + "\n" + name + "\n" + currHp + "\n" + type);
            }
            else {
                fw.write("\n" + userName + "\n" + name + "\n" + currHp + "\n" + type);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("IO exception");
            return false;
        }
        return true;
    }

    /**
     * Loads variables into an array accordning to 'example.txt' file
     * 
     * @param preset1 - file that the program will load from
     * @return - returns an array of variables according to 'example.txt', returns
     *         null if the file is invalid (shorter than expected)
     */
    public static String[] loadPokemon(File preset, int index) {
        assert (preset.exists()) : "file does not exist (load last pokemon)";
        
        //preset index param validity check
        int presetCount = countFileLines(preset)/4;
        if (index > presetCount) {
            System.out.println("Preset index invalid: " + index + " File Index Count: " + presetCount);
            return null;
        }

        String[] variableArray = new String[4];
        try {
            Scanner fileScanner = new Scanner(preset);
            for (int y = 0; y < 4; y++) {
                int currFileLine = ((index - 1) * 4) + 1 + y;
                variableArray[y] = readFileLine(preset, currFileLine);
            }
        } catch (IOException e) {
            System.out.print("There was an error when handeling the file");
        }
        return variableArray;
    }

    /**
     * Scans for a file, if it exists, it will scan for if its empty or not, if its
     * not it will ask the user if he wants to load his preset or not
     * 
     * @param preset1 - file that it scans for
     * @param console - scanner with system.in for answer of the user
     * @return - return false if the file should not load and true if it should load
     */
    public static boolean scanForLast(File preset, File user, Scanner console) {
        if (!preset.exists()) {
            try {
                preset.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occured when creating the file: " + preset.getName());
            }
            return false;
        } else if (preset.length() == 0) {
            return false;
        } else if (!readFileLine(preset, 1).equalsIgnoreCase(readFileLine(user, 1))) {
            return false;
        } else {
            // System.out.print("Do you want to load your saved pokemon? (y/n): ");
            // String answer = console.nextLine();
            // while (!(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("n"))) {
            //     System.out.println("Try typing 'y' for yes, or 'n' for no! ");
            //     System.out.print("(y/n): ");
            //     answer = console.nextLine();
            // }
            // if (answer.equalsIgnoreCase("y")) {
            //     System.out.println("Ok, the file will load!");
            //     return true;
            // } else {
            //     return false;
            // }
            return true;
        }
    }

    /**
     * This method finds the current java file name
     * 
     * @return returns a string "fileName.java"
     */
    public static String getFileName() {
        // Get the name of the class (excluding the package) and append ".java"
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        String fileName = className + ".java";
        return fileName;
    }

    /**
     * Returns a string with the current path of the folder
     * 
     * @return String with path
     */
    public static String getPath() {
        String fileName = getFileName();
        int nameLenght = fileName.length();
        File folder = new File(fileName);
        String absolutePath = folder.getAbsolutePath();
        int pathLenght = absolutePath.length();
        return absolutePath.substring(0, pathLenght - nameLenght - 1);
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
    private static boolean user(String file) {
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
            FileWriter fw = new FileWriter(newUser);
            fw.append(username);
            fw.close();
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
    public static void deleteUser(File currUser, File currPreset, Scanner console) {
        System.out.print("Are you sure to delete your account? (y/n): ");
        String answer = console.nextLine();
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")) {
            System.out.println("I didn't understand...\nTry typing y/n: ");
            answer = console.nextLine();
        }
        if (answer.equalsIgnoreCase("n")) {

        } else {
            String path = currUser.getAbsolutePath();
            boolean wasSuccesful = currUser.delete();
            if (!wasSuccesful) { 
                System.out.println("File deletion unsuccesful, path to file: " + path);
            }
            if (currPreset.exists()) {
                wasSuccesful = currPreset.delete();
                path = currPreset.getAbsolutePath();
                if (!wasSuccesful) {
                    System.out.println("File deletion unsuccesful, path to file: " + path);
                }
            }
        }
    }

    /**
     * Encrypts a string
     * 
     * @param target - target string
     * @return - returns the encrypted String
     */
    public static String encrypt(String target) {
        String SECRET_KEY = "ThisIsASecretKey";
        String INIT_VECTOR = "RandomInitVector";
        try {
            IvParameterSpec iv = new IvParameterSpec(INIT_VECTOR.getBytes("UTF-8"));
            SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, iv);

            byte[] encrypted = cipher.doFinal(target.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Prompts user to enter password to the account he selected
     * 
     * @param user        - the file that the user selected
     * @param console     - scanner with system.in
     * @param maxAttempts - maximum ammount of wrong password attempts
     * @return - returns boolean, true if password correct, false if not
     */
    public static boolean getPassword(File user, Scanner console, int maxAttempts) {
        Console passwordReader = System.console();
        String password = readFileLine(user, 2);
        if (password == null) {
            return setPassword(user, console);
        }
        else {
            String input = "";
            int attempts = 0;
            System.out.print("Enter password: ");
            input = encrypt(new String(passwordReader.readPassword()));
            while (!input.equals(password) && attempts < maxAttempts) {
                System.out.println(
                        "Incorrect  password, try again... \n" + (maxAttempts - attempts) + " attempts remaining: ");
                input = encrypt(new String(passwordReader.readPassword()));
                attempts++;
            }
            if (input.equals(password)) {
                System.out.println("Password correct!");
                return true;
            } else {
                System.out.println("Too many tries...");
                return false;
            }
        }
    }

    /**
     * Sets password to a user
     * 
     * @param user    - the user the method is setting the pasword to
     * @param console - scanner with system.in
     * @return - returns a boolean, true if password settings succesful, false if
     *         not
     */
    public static boolean setPassword(File user, Scanner console) {
        Console passwordReader = System.console();
        String password = "";
        String confirm = "";
        System.out.print("Create password: ");
        password = encrypt(new String(passwordReader.readPassword()));
        System.out.print("Confirm password: ");
        confirm = encrypt(new String(passwordReader.readPassword()));
        int attempts = 0;
        while (!password.equals(confirm) && attempts < 6) {
            System.out.print("Passwords don't match...\nTry again: ");
            confirm = encrypt(new String(passwordReader.readPassword()));
            attempts++;
        }
        if (!password.equals(confirm)) {
            System.out.println("Too many attempts, try again.");
            return false;
        } else {
            try {
                FileWriter fw = new FileWriter(user, true);
                fw.append("\n" + password);
                fw.close();
            } catch (IOException e) {
                System.out.println("IOException");
                return false;
            }
            System.out.println("Password set sucesfully!");
            return true;
        }
        }
}
