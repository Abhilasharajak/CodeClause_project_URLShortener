import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    private Map<String, String> urlMap;

    public URLShortener() {
        urlMap = new HashMap<>();
    }

    public String shortenURL(String originalURL) {
        String shortURL = generateShortURL();
        urlMap.put(shortURL, originalURL);
        return shortURL;
    }

    public String expandURL(String shortURL) {
        return urlMap.get(shortURL);
    }

    private String generateShortURL() {
        // Generate a random short URL using alphanumeric characters
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();
        String originalURL = "https://www.example.com";

        String shortURL = shortener.shortenURL(originalURL);
        System.out.println("Short URL: " + shortURL);

        String expandedURL = shortener.expandURL(shortURL);
        System.out.println("Expanded URL: " + expandedURL);
    }
}
