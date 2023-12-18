// package PokemonGame;

public class PokemonLibrary {
        StringBuilder sb = new StringBuilder();

        // PICHU VARIABLES

        public String pichuClass = "Electric";
        public String pichuType = "Pichu";
        public int pichuHp = 40;
        public String pichuStage = "pikachu";
        public String[] pichuAbilities = { "collect", "cry for help" };
        public String pichuColour = "\u001b[43m"; // yellow
        private String[] pichuImageArray = { "        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⣿",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣾⣿⣿⣿⣿⣿",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⠟⢻⣿⣿⣿⣿",
                        "⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⠿⠋⠀⠀⠈⢡⣿⣿⡇",
                        "⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣄⠀⠀⠀⠀⠀⠀⠟⠁⠀⠀⠀⠀⠀⣼⣿⣿⠁",
                        "⠀⠹⣿⣿⣿⠿⡄⠉⠉⠙⠛⠻⢿⠀⠀⠀⣀⡀⠀⠘⠄⠀⠀⠀⠀⢠⣿⣿⡟⠀",
                        "⠀⠀⠙⣿⣿⣷⡀⠀⠀⠀⠀⠀⢸⠤⠂⠁⠀⠀⠀⠀⠀⠀⠀⠠⡀⠚⠛⠛⠀⠀",
                        "⠀⠀⠀⠈⢿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢤⣄⠀⠐⡀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠻⣿⣿⣿⠦⢲⠁⠀⢀⢀⠀⠀⠀⠀⠀⠸⣾⡿⢃⣠⡅⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⢸⠀⠐⣷⣾⡇⠀⠀⠂⠀⡀⠀⠀⣾⣿⡇⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣠⣤⣌⠉⠀⠀⠒⠒⠊⠀⠀⠀⢙⣟⠤⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠻⣿⡇⠀⠀⠀⠀⠀⣀⣤⣶⠉⠀⠀⢠⠃⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠔⠀⠀⠉⠉⡽⣿⣿⣿⢿⣿⠁⠀⢀⠔⠁⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⢤⢤⢴⠀⠋⠀⠁⠀⠉⠀⠸⣠⣴⣤⡀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠘⠀⢣⠀⠀⠀⠀⠀⠀⢀⠿⣿⣿⣿⣦⡀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢄⠀⢀⠀⠀⠀⠀⠀⢀⠈⠀⠈⠻⣿⠟⠋",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠁⠀⢠⠀⠀⠐⡄⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠣⣀⣌⠇⠀⠀⠀⠀⠀" };
        public String pichuImage = saveImage(sb, pichuImageArray);
        public int pichuImageLines = pichuImageArray.length;

        // PIKACHU VARIABLES

        public String pikachuClass = "Electric";
        public String pikachuType = "Pikachu";
        public int pikachuHp = 60;
        public String pikachuStage = "raichu";
        public String[] pikachuAbilities = {"Lightning rod", "Thunder"};
        public String pikachuColour = "\u001b[43m"; // yellow
        private String[] pikachuImageArray = { "⠸⣷⣦⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⠀⠀⠀",
                        " ⠙⣿⡄⠈⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠔⠊⠉⣿⡿⠁⠀⠀⠀",
                        "⠀⠀⠈⠣⡀⠀⠀⠑⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠊⠁⠀⠀⣰⠟⠀⠀⠀⣀⣀",
                        "⠀⠀⠀⠀⠈⠢⣄⠀⡈⠒⠊⠉⠁⠀⠈⠉⠑⠚⠀⠀⣀⠔⢊⣠⠤⠒⠊⠉⠀⡜",
                        "⠀⠀⠀⠀⠀⠀⠀⡽⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠩⡔⠊⠁⠀⠀⠀⠀⠀⠀⠇",
                        "⠀⠀⠀⠀⠀⠀⠀⡇⢠⡤⢄⠀⠀⠀⠀⠀⡠⢤⣄⠀⡇⠀⠀⠀⠀⠀⠀⠀⢰⠀",
                        "  ⠀⠀⠀⠀⢀⠇⠹⠿⠟⠀⠀⠤⠀⠀⠻⠿⠟⠀⣇⠀⠀⡀⠠⠄⠒⠊⠁⠀",
                        "⠀⠀⠀⠀⠀⠀⢸⣿⣿⡆⠀⠰⠤⠖⠦⠴⠀⢀⣶⣿⣿⠀⠙⢄⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⢻⣿⠃⠀⠀⠀⠀⠀⠀⠀⠈⠿⡿⠛⢄⠀⠀⠱⣄⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⢸⠈⠓⠦⠀⣀⣀⣀⠀⡠⠴⠊⠹⡞⣁⠤⠒⠉⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⣠⠃⠀⠀⠀⠀⡌⠉⠉⡤⠀⠀⠀⠀⢻⠿⠆⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠰⠁⡀⠀⠀⠀⠀⢸⠀⢰⠃⠀⠀⠀⢠⠀⢣⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⢶⣗⠧⡀⢳⠀⠀⠀⠀⢸⣀⣸⠀⠀⠀⢀⡜⠀⣸⢤⣶⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠈⠻⣿⣦⣈⣧⡀⠀⠀⢸⣿⣿⠀⠀⢀⣼⡀⣨⣿⡿⠁⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠈⠻⠿⠿⠓⠄⠤⠘⠉⠙⠤⢀⠾⠿⣿⠟⠋" };
        public String pikachuImage = saveImage(sb, pikachuImageArray);
        public int pikachuImageLines = pikachuImageArray.length;

        // RAICHU VARIABLES

        public String raichuClass = "Electric";
        public String raichuType = "Raichu";
        public int raichuHp = 120;
        public String raichuStage = null;
        public String[] raichuAbilities = {"Thunder Shock", "Ace Spark"};
        public String raichuColour = "\u001b[43m"; // yellow
        private String[] raichuImageArray = { "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠛⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡏⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠃⠀⠼⣄⡀⠀⠀⠀⠀⠀⠀⠀",
                        "⠀⠀⠀⡴⠋⠳⣄⠀⠀⢀⢎⣔⠀⠀⠀⠀⠉⠳⣄⠀⠀⠀⠀⠀",
                        "⠀⢠⠞⠁⠀⠀⠀⠹⣶⢛⠘⡋⠀⢠⣎⣦⠀⠀⠈⠙⠲⢤⡀⠀",
                        "⣰⠏⠀⠀⠀⠀⠀⠀⢰⠀⠰⡤⡀⠀⢛⣋⠀⠀⠰⣄⣀⣠⣿⣆",
                        "⠛⠒⠶⠶⢶⡶⠄⢀⣨⢦⡀⠢⠃⠀⠸⣿⠇⠀⢰⠃⠉⠉⠉⠉",
                        "⠀⠀⠀⠰⠿⣤⣀⠛⢧⣌⡇⠀⠀⠀⠀⠀⠰⠉⠙⢳⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⣼⣣⣞⣽⣇⠀⠈⠑⢄⠀⠐⢄⣀⣸⠀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠈⠛⣿⣿⠁⠉⠠⡀⠀⠀⡆⠀⠀⠀⢹⡀⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠹⡿⠇⠀⠀⢈⠁⠊⠀⠀⠀⠀⠈⣇⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⣧⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⣸⠗⠀⣀⣦⣀⣤⣤⠴⠾⣄⡀⠺⡄⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀" };
        public String raichuImage = saveImage(sb, raichuImageArray);
        public int raichuImageLines = raichuImageArray.length;

        // BULBASAUR VARIABLES

        public String bulbasaurClass = "Seed";
        public String bulbasaurType = "Bulbasaur";
        public int bulbasaurHp = 70;
        public String bulbasaurStage = null;
        public String[] bulbasaurAbilies = {"Whine whip", "Razor leaf"};
        public String bulbasaurColour = "\u001b[42m";
        private String[] bulbasaurImageArray = { "         ⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⡀",
                        " ⠀⠀⢀⡀⠀⠀       ⠀⠠⠐⠂⠀⠁⠀⠀⠀⠀",
                        " ⠀⠰⡁⠐⢉⣉⣭⡍⠁⠂⠉⠘⡀ ⠀⠀⠀⠀⠂⠡⠀",
                        " ⢀⣊⠀⡄⠻⠿⠋⠀⠀⠀⠀⠀⢃⠀⠀⠀⠀⠀⠀⢀",
                        " ⡎⣾⠀⠁⣴⡆⠀⠡⢺⣿⣆⠀⢠⢱⣄⠀⠀⠀⠀⠈",
                        " ⡑⠟⠀⠀⠀⠀⠀⢀⣸⡿⠟⠀⠀⠈⢿⣿⡦⡀⠀⡰",
                        " ⠙⠔⠦⣤⣥⣤⣤⣤⡤⠆⠀⠀⠀⠀⢀⢀⠀⠈⠎⠀",
                        " ⠀⠀⠈⣰⡋⢉⠉⠁⠒⠂⢇⢠⡆⠀⠸⢴⣿⠀⠘⠀",
                        " ⠀⠀⠘⡿⠃⠀⠨⠒⢆⣸⣿⠁⠀⡠⡇⠈⠋⠀⠰⠀",
                        " ⠀⠀⠀⠛⠒⠒⠁⠀⠈⠷⡤⠤⠐⠀⠘⠒⠒⠖⠁⠀" };
        public String bulbasaurImage = saveImage(sb, bulbasaurImageArray);
        public int bulbasaurImageLines = bulbasaurImageArray.length;

        // EEVEE VARIABLES

        public String eeveeClass = "Normal";
        public String eeveeType = "Eevee";
        public int eeveeHp = 60;
        public String eeveeStage = "flareon";
        public String[] eeveeAbilities = {"Be Prepared", "Bite"};
        public String eeveeColour = "\u001b[47m";
        //TODO eevee picture
        public String eeveeImage = "Im sorry, but Eevee doesn't have a picture yet...";
        public int eeveeImageLines = 1;


        // FLAREON VARIABLES

        public String flareonClass = "Fire";
        public String flareonType = "Flaeron";
        public int flareonHp = 110;
        public String flareonStage = null;
        public String[] flareonAbilities = {"Bite", "Fire Spin"};
        public String flareonColor = "\u001b[41m";
        private String[] flareonImageArray = { "⠐⣶⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣷⠀",
                        "⠀⠸⡏⠙⠦⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣠⠖⠋⣸⠃⠀",
                        "⠀⠀⢻⠀⠀⠈⢳⡀⠀⠀⠀⢨⢢⠀⢠⠞⠁⠀⢠⡏⠀⠀",
                        "⠀⠀⠈⣧⠀⠀⠀⢻⡀⡠⠔⠊⠀⢣⡏⠀⠀⠀⡾⠀⠀⠀",
                        "⠀⠀⠀⠈⠓⠦⣴⣼⡏⠀⠀⠀⢠⣾⣤⣤⠶⠛⠁⢀⣿⠀",
                        "⠀⠀⠀⠀⠀⣶⠟⢻⣿⣦⣀⣤⣾⣿⡏⠙⢲⠀⠀⣾⣿⡇",
                        "⠀⠀⠀⠀⣸⠃⠀⢀⠀⢹⣿⣿⠃⢀⡇⠀⠘⣶⣶⣿⣿⠇",
                        "⠀⠀⠀⠀⢰⠀⠀⠈⠻⣿⣯⣿⡿⠟⠁⠀⠀⣿⣿⣿⡿⠀",
                        "⠀⠀⠀⠀⠙⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣽⣿⣿⣄⠀",
                        "⠀⠀⠀⠀⠀⢺⡀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⡟⠁⠀",
                        "⠀⠀⠀⠀⠀⠀⠈⣿⣦⣴⣴⣤⣶⣤⣾⣿⣿⣿⣿⡁⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⡿⣿⠟⠋⠉⠀⠀⠀",
                        "⠀⠀⠀⠀⠀⠀⠺⠿⢿⣿⠏⠻⣿⡿⠿⠇⠀⠀⠀⠀⠀⠀" };
        public String flareonImage = saveImage(sb, flareonImageArray);
        public int flareonImageLines = flareonImageArray.length;

        // WELCOME MESSAGE

        private String[] welcomeArray = {
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
        public String welcomeImage = saveImage(sb, welcomeArray);

        /**
         * Uses stringbuilder to join String elements in an array with "\n"
         * 
         * @param sb
         * @param imageField
         * @return
         */
        private String saveImage(StringBuilder sb, String[] imageField) {
                int lenght = imageField.length;
                int counter = 0;
                for (String s : imageField) {
                        sb.append(s);
                        counter++;
                        if (counter < lenght) {
                                sb.append("\n");
                        }
                }
                String output = sb.toString();
                sb.setLength(0);
                return output;
        }
}