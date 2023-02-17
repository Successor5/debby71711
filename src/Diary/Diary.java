package Diary;

import jdk.internal.foreign.abi.Binding;

import java.util.ArrayList;

public class Diary {
  public  ArrayList<Entry> entries = new ArrayList<>();

    public void createEntry(String title, String body) {
        Entry entry = new Entry(title, body);
        entries.add(entry);
    }
    public String viewEntry(int ID) {
        ID = ID - 1;
        validateID(ID);
        return String.format("""
                ------------------------------
                TITLE: %s
                ------------------------------
                BODY: %s
                ------------------------------
                """, entries.get(ID).getTitle(), entries.get(ID).getBody());
    }


    public  void validateID(int ID) {
        if (ID < 0 || ID > entries.size()){
            throw new IndexOutOfBoundsException("invalid ID");
        }
    }

    public  int countEntry() {
        return entries.size();
    }

    public void editEntryBody(String body, int ID) {
        ID -= 1;
        validateID(ID);
        entries.get(ID).setBody(body);
    }

    public void editEntryTitle(String title, int ID) {
        ID-=1;
        validateID(ID);
        entries.get(ID).setTitle(title);
    }

    public void deleteEntry(int ID) {
        ID -= 1;
        validateID(ID);
        entries.remove(ID);
    }
    public int numberOfEntries() {

        return entries.size();
    }


}

