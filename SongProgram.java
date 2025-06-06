/**
 * SongProgram.java
 * @author Angel Grajeda
 * @since 2025-04-15
 * 
 * This class handles loading song data from a CSV file and then afterwards storing it in a HashMap,
 * and providing methods to search and display songs with a GUI or console output.
 */

//package hashingAndDocumentation;//comment this out if you do not need a package

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class SongProgram {

    // HashMap to store SongRecords with the song's ID as the key
    private HashMap<String, SongRecord> songMap;

    // Constructor
    /**
     * Default constructor initializes an empty song map.
     * Preconditions: none
     * Postconditions: songMap is initialized
     */
    public SongProgram() {
        songMap = new HashMap<>();
    }

    // Method to load songs from a CSV file
    /**
     * Loads song data from a CSV file.
     * Preconditions: filePath points to a valid CSV file formatted as expected
     * Postconditions: songMap is populated with SongRecord objects from the file
     * @param filePath the path to the CSV file
     */
    public void loadSongsFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            
            // Read and skip the header line
            br.readLine();
            
            while ((line = br.readLine()) != null) {
            	
            	//System.out.println(line);//for testing
                // Create a SongRecord from the line and add it to the map
                SongRecord song = new SongRecord(line);
                songMap.put(song.getId(), song);
            }
            System.out.println("Songs successfully loaded from CSV.");
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
    }
        
    // Method to retrieve a SongRecord by ID
    /**
     * Retrieves a song by its ID.
     * Preconditions: id is a non-null String
     * Postconditions: returns the SongRecord if found, null otherwise
     * @param id the song ID to search for
     * return the SongRecord with the given ID or null if not found
     */
    public SongRecord getSongById(String id) {
        return songMap.get(id);
    }

    // Method to print all songs (for debugging or display purposes)
    /**
     * Prints all songs to the console.
     * Preconditions: songMap is populated
     * Postconditions: each SongRecord is printed
     */
    public void printAllSongs() {
        for (SongRecord song : songMap.values()) {
            System.out.println(song);
        }
    }
    
    // GUI method to search for a song by ID
    /**
     * Opens a simple GUI for searching songs by ID.
     * Preconditions: songMap may or may not contain songs
     * Postconditions: GUI is displayed, user can search for songs by ID
     */
    public void openSearchGui() {
        // Create the main frame
        JFrame frame = new JFrame("Song Lookup");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold input and button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Label, Text Field, and Button
        JLabel label = new JLabel("Enter Song ID:");
        JTextField idField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        // Add label, text field, and button to panel
        panel.add(label);
        panel.add(idField);
        panel.add(searchButton);

        // Result area to display song details
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);

        // Add action listener for the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                SongRecord song = getSongById(id);
                if (song != null) {
                    resultArea.setText("Song Found:\n" + song.toString());
                } else {
                    resultArea.setText("Song with ID " + id + " not found.");
                }
            }
        });

        // Add panel to frame
        frame.add(panel);
        frame.setVisible(true);
    }

    // Main method to demonstrate functionality and open GUI
    /**
     * Alternate main method to open the GUI.
     * @param args command-line arguments
     */
    public static void main2(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Open GUI for searching songs by ID
        program.openSearchGui();
    }

    // Main method to demonstrate functionality
    /**
     * Main method to test CSV loading and song retrieval.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SongProgram program = new SongProgram();

        // Load songs from a CSV file
        String filePath = "data.csv";  // replace with actual file path
        program.loadSongsFromCSV(filePath);

        // Demonstrate retrieving a song by ID
        String testId = "4BJqT0PrAfrxzMOxytFOIz";  // replace with an actual ID from your file
        SongRecord song = program.getSongById(testId);
        if (song != null) {
            System.out.println("Retrieved song: " + song);
        } else {
            System.out.println("Song with ID " + testId + " not found.");
        }

        // Print all songs
        //program.printAllSongs();
    }
}

