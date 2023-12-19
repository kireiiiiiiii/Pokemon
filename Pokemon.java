//import java.util.Arrays;

public class Pokemon {
    private final String COLORRESET = "\u001B[0m";

    private String pokemonName;
    private String pokemonImage;
    private String pokemonType;
    private String pokemonClass;
    private String pokemonColour;
    private String[] pokemonAbilities = new String[1];
    private int pokemonHp;

    /**
     * Constructor for the pokemon obj.
     * 
     * @param pokemonName      - name of the pokemon, made by user (custom)
     * @param pokemonType      - type of pokemon, example 'pikachu'
     * @param pokemonClass     - class of pokemon, example 'electric'
     * @param pokemonImage     - ascii image of the pokemon
     * @param pokemonColour    - backround image of the pokemon
     * @param pokemonAbilities - an array of two abilities
     * @param pokemonHp        - int of hp of current pokemon
     */
    public Pokemon(String pokemonName, String pokemonType, String pokemonClass, String pokemonImage,
            String pokemonColour, String[] pokemonAbilities, int pokemonHp) {
        assert (pokemonAbilities.length == 2) : "pokemonAbilities array doesn't have two elements (constructor)";
        this.pokemonName = pokemonName;
        this.pokemonImage = pokemonImage;
        this.pokemonType = pokemonType;
        this.pokemonClass = pokemonClass;
        this.pokemonColour = pokemonColour;
        this.pokemonAbilities = pokemonAbilities;
        this.pokemonHp = pokemonHp;
        // System.out.println(Arrays.toString(pokemonAbilities));
    }

    /**
     * Overwrites the method toString() to return stats abt the pokemon
     */
    @Override
    public String toString() {
        return "Hi, I am a " + pokemonType + ", my name is " + pokemonName + " and I am a " + pokemonColour
                + pokemonClass + COLORRESET + " type Pokemon! I have " + pokemonHp + " HP!"
                + "\nMy abilities are:\n\t--" + pokemonColour
                + pokemonAbilities[0] + COLORRESET
                + "\n\t--" + pokemonColour + pokemonAbilities[1] + COLORRESET;
    }

    /**
     * prints the ascii art of the pokemon
     */
    public void image() {
        System.out.println(pokemonImage);
    }

    /**
     * prints into console, that pokemon used ability one
     */
    public void ability1() {
        System.out.println(
                pokemonType + " " + pokemonName + " uses " + pokemonColour + pokemonAbilities[0] + COLORRESET + "!");
    }

    /**
     * prints into console, that pokemon used ability two
     */
    public void ability2() {
        System.out.println(
                pokemonType + " " + pokemonName + " uses " + pokemonColour + pokemonAbilities[1] + COLORRESET + "!");
    }

    /**
     * Uptades the pokemon variables, used when evolvving the pokemon
     * 
     * @param pokemonName      - name of the pokemon, made by user (custom)
     * @param pokemonType      - type of pokemon, example 'pikachu'
     * @param pokemonClass     - class of pokemon, example 'electric'
     * @param pokemonImage     - ascii image of the pokemon
     * @param pokemonColour    - backround image of the pokemon
     * @param pokemonAbilities - an array of two abilities
     * @param pokemonImageLine - lines of ascii image count
     */
    public void updatePokemon(String pokemonName, String pokemonType, String pokemonClass, String pokemonImage,
            String pokemonColour, String[] pokemonAbilities) {
        assert (pokemonAbilities.length == 2) : "pokemonAbilities array doesn't have two elements (updatePokemon)";
        this.pokemonName = pokemonName;
        this.pokemonImage = pokemonImage;
        this.pokemonType = pokemonType;
        this.pokemonClass = pokemonClass;
        this.pokemonColour = pokemonColour;
        this.pokemonAbilities = pokemonAbilities;
    }
}
