package hu.nive.ujratervezes.io.phonebook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Phonebook {


    public void exportPhonebook(Map<String, String> contacts, String output) {

        List<String> result = new ArrayList<>(contacts.keySet());

        if (result.isEmpty() || result == null || output == null) {
            throw new IllegalArgumentException();
        }

        File file = new File(output);
        BufferedWriter bw = null;

        try {

            bw = new BufferedWriter(new FileWriter(file));

            for (Map.Entry<String, String> entry :
                    contacts.entrySet()) {

                bw.write(entry.getKey() + ": "
                        + entry.getValue());

                bw.newLine();
            }
            bw.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {

            try {
                assert bw != null;
                bw.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    }
