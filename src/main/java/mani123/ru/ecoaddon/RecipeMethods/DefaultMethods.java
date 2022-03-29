package mani123.ru.ecoaddon.RecipeMethods;

public class DefaultMethods {

    public static String getAllCraftsCount() {
        return String.valueOf(Integer.parseInt(FurnaceRecipe.getCraftsCount().toString())
                + Integer.parseInt(StoneCutter.getCraftsCount().toString())
                + Integer.parseInt(CampfireRecipe.getCraftsCount().toString())
                + Integer.parseInt(SmokingRecipe.getCraftsCount().toString()));
    }

    public static String getAllCraftsNames() {
        return FurnaceRecipe.getCraftsNames().toString()
                + StoneCutter.getCraftsNames()
                + SmokingRecipe.getCraftsNames()
                + CampfireRecipe.getCraftsNames();
    }

}
