package net.folab.java.snippets.reflection;

public class AccessPrivateField {

    private int privateToSet = 3;

    @SuppressWarnings("unused")
    private int privateToGet = 7;

    public int getPrivateToSet() {
        return privateToSet;
    }

    public void setPrivateToGet(int privateToGet) {
        this.privateToGet = privateToGet;
    }

}
