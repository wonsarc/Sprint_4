public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if(name == null || name.length() < 3 || name.length() > 19) {
           return false;
        }

        if(getSpaceCount(name) != 1){
            return false;
        }

        if(name.startsWith(" ") || name.endsWith(" ")) {
            return false;
        }

        return true;

    }

    public int getSpaceCount(String row) {
        int spaceCount = 0;
        for (int i = 1; i <= row.length(); i++) {
            char space = row.charAt(i - 1);
            if (String.valueOf(space).equals(" ")) {
                spaceCount++;
            }
        }
        return spaceCount;
    }
}