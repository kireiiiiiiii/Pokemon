import java.io.File;
import java.io.IOException;

public class Preset {

    private User owner;
    private File presetFile;

    public Preset(User owner) {
        this.owner = owner;
        String path = getPresetPath(owner);
        presetFile = setPreset(path);
    }

    public File getPreset() {
        return presetFile;
    }

    public User getOwner() {
        return owner;
    }

    private String getPresetPath(User owner)  {
        String path = owner.getPath();
        String username = owner.getUsername();
        return path + "/" + username + "PRESET.txt";
    }

    /**
     * Sets the user file, according to user, if the file for the preset doesn't
     * exist it will create it
     * 
     * @param user - user file of the current user
     * @return - returns the file of the preset of the user given in @param
     */
    private File setPreset(String path) {
        File preset = new File(path);
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
}
