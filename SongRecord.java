/**
* SongRecord.java
* @author Angel Grajeda
* @since 2025-04-15
*  This class represents a single song's data with various musical features,
* metadata, and information parsed from a CSV string.
*/

//package hashingAndDocumentation;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;

public class SongRecord {
    // Instance variablesjava
    private double valence;
    private int year;
    private double acousticness;
    private List<String> artists;
    private double danceability;
    private int durationMs;
    private double energy;
    private int explicit;
    private String id;
    private double instrumentalness;
    private int key;
    private double liveness;
    private double loudness;
    private int mode;
    private String name;
    private int popularity;
    private String releaseDate;
    private double speechiness;
    private double tempo;

    /**
     * Default constructor that creates a song with placeholder/default values.
     * Precondition: none
     * Postcondition: all fields are initialized with default values
     */
    public SongRecord() {
        this.valence = 0.0;
        this.year = 0;
        this.acousticness = 0.0;
        this.artists = Arrays.asList("Unknown Artist");
        this.danceability = 0.0;
        this.durationMs = 0;
        this.energy = 0.0;
        this.explicit = 0;
        this.id = "";
        this.instrumentalness = 0.0;
        this.key = 0;
        this.liveness = 0.0;
        this.loudness = 0.0;
        this.mode = 0;
        this.name = "Unknown Title";
        this.popularity = 0;
        this.releaseDate = "0";
        this.speechiness = 0.0;
        this.tempo = 0.0;
    }

    /**
     * Constructor that parses a CSV string to initialize the song's fields.
     * Precondition: data is a valid comma-separated string with 19 values
     * Postcondition: fields are set based on the parsed data
     * @param data the CSV line representing one song's data
     */    
        public SongRecord(String data) {
        String[] fields = data.split(","); // Assuming comma-separated values
        
    	//fields = data.split(",");//means no quotes in the record
    	
    	/*System.out.println("fields length " + fields.length);
    	for(int i = 0; i < fields.length; i++) {
        	System.out.println("fields " + i + " = " + fields[i]);
        }*/
    	this.valence = Double.parseDouble(fields[0]);
        this.year = Integer.parseInt(fields[1]);
        this.acousticness = Double.parseDouble(fields[2]);
        this.artists = Arrays.asList(fields[3].replaceAll("[\\[\\]']", "").split(";"));
        this.danceability = Double.parseDouble(fields[4]);
        this.durationMs = Integer.parseInt(fields[5]);
        this.energy = Double.parseDouble(fields[6]);
        this.explicit = Integer.parseInt(fields[7]);
        this.id = fields[8];
        this.instrumentalness = Double.parseDouble(fields[9]);
        this.key = Integer.parseInt(fields[10]);
        this.liveness = Double.parseDouble(fields[11]);
        this.loudness = Double.parseDouble(fields[12]);
        this.mode = Integer.parseInt(fields[13]);
        this.name = fields[14];
        this.popularity = Integer.parseInt(fields[15]);
        this.releaseDate = fields[16];
        this.speechiness = Double.parseDouble(fields[17]);
        this.tempo = Double.parseDouble(fields[18]);
        
    }

    // Getters and setters for each field
    /** return the song's valence */
    public double getValence() { return valence; }
    public void setValence(double valence) { this.valence = valence; }
    
    /** return the release year */
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getAcousticness() { return acousticness; }
    public void setAcousticness(double acousticness) { this.acousticness = acousticness; }

    public List<String> getArtists() { return artists; }
    public void setArtists(List<String> artists) { this.artists = artists; }

    public double getDanceability() { return danceability; }
    public void setDanceability(double danceability) { this.danceability = danceability; }

    public int getDurationMs() { return durationMs; }
    public void setDurationMs(int durationMs) { this.durationMs = durationMs; }

    public double getEnergy() { return energy; }
    public void setEnergy(double energy) { this.energy = energy; }

    public int getExplicit() { return explicit; }
    public void setExplicit(int explicit) { this.explicit = explicit; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public double getInstrumentalness() { return instrumentalness; }
    public void setInstrumentalness(double instrumentalness) { this.instrumentalness = instrumentalness; }

    public int getKey() { return key; }
    public void setKey(int key) { this.key = key; }

    public double getLiveness() { return liveness; }
    public void setLiveness(double liveness) { this.liveness = liveness; }

    public double getLoudness() { return loudness; }
    public void setLoudness(double loudness) { this.loudness = loudness; }

    public int getMode() { return mode; }
    public void setMode(int mode) { this.mode = mode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public double getSpeechiness() { return speechiness; }
    public void setSpeechiness(double speechiness) { this.speechiness = speechiness; }

    public double getTempo() { return tempo; }
    public void setTempo(double tempo) { this.tempo = tempo; }

    /**
     * Returns a string representation of the song.
     * return string with all field values
     */
    // toString method
    @Override
    public String toString() {
        return "SongRecord{" +
                "valence=" + valence +
                ", year=" + year +
                ", acousticness=" + acousticness +
                ", artists=" + artists +
                ", danceability=" + danceability +
                ", durationMs=" + durationMs +
                ", energy=" + energy +
                ", explicit=" + explicit +
                ", id='" + id + '\'' +
                ", instrumentalness=" + instrumentalness +
                ", key=" + key +
                ", liveness=" + liveness +
                ", loudness=" + loudness +
                ", mode=" + mode +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", releaseDate=" + releaseDate +
                ", speechiness=" + speechiness +
                ", tempo=" + tempo +
                '}';
    }

    // equals method
    /**
     * Compares two SongRecord objects for equality.
     * @param o the object to compare
     * return true if all fields are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongRecord that = (SongRecord) o;
        return Double.compare(that.valence, valence) == 0 &&
                year == that.year &&
                Double.compare(that.acousticness, acousticness) == 0 &&
                Objects.equals(artists, that.artists) &&
                Double.compare(that.danceability, danceability) == 0 &&
                durationMs == that.durationMs &&
                Double.compare(that.energy, energy) == 0 &&
                explicit == that.explicit &&
                Objects.equals(id, that.id) &&
                Double.compare(that.instrumentalness, instrumentalness) == 0 &&
                key == that.key &&
                Double.compare(that.liveness, liveness) == 0 &&
                Double.compare(that.loudness, loudness) == 0 &&
                mode == that.mode &&
                Objects.equals(name, that.name) &&
                popularity == that.popularity &&
                releaseDate == that.releaseDate &&
                Double.compare(that.speechiness, speechiness) == 0 &&
                Double.compare(that.tempo, tempo) == 0;
    }
    /**
     * Generates a hash code for the song.
     * return the hash code based on the song's fields
     */
    @Override
    public int hashCode() {
        return Objects.hash(valence, year, acousticness, artists, danceability, durationMs, energy, explicit, id,
                instrumentalness, key, liveness, loudness, mode, name, popularity, releaseDate, speechiness, tempo);
    }
}
