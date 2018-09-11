import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quickstart {
    /** Application name. */
    private static final String APPLICATION_NAME =
            "Google Calendar API Java Quickstart";

    /** Directory to store user credentials for this application. */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/calendar-java-quickstart");

    /** Global instance of the {@link FileDataStoreFactory}. */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /** Global instance of the HTTP transport. */
    private static HttpTransport HTTP_TRANSPORT;

    /** Global instance of the scopes required by this quickstart.
     *
     * If modifying these scopes, delete your previously saved credentials
     * at ~/.credentials/calendar-java-quickstart
     */
    private static final List<String> SCOPES =
            Arrays.asList(CalendarScopes.CALENDAR_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Creates an authorized Credential object.
     * @return an authorized Credential object.
     * @throws IOException
     */
    public static Credential authorize() throws IOException {
        // Load client secrets.
        InputStream in =
                Quickstart.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow =
                new GoogleAuthorizationCodeFlow.Builder(
                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                        .setDataStoreFactory(DATA_STORE_FACTORY)
                        .setAccessType("offline")
                        .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("user");
        System.out.println(
                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    /**
     * Build and return an authorized Calendar client service.
     * @return an authorized Calendar client service
     * @throws IOException
     */
    public static com.google.api.services.calendar.Calendar
    getCalendarService() throws IOException {
        Credential credential = authorize();
        return new com.google.api.services.calendar.Calendar.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static void main(String[] args) throws IOException {
        // Build a new authorized API client service.
        // Note: Do not confuse this class with the
        //   com.google.api.services.calendar.model.Calendar class.
        Calendar service =
                getCalendarService();

        //TODO create calendarid array

        ArrayList<String> calendarArray = new ArrayList<String>();
        calendarArray.add("primary"); // built in for email
        calendarArray.add("kamsmommy@gmail.com");//Me
        calendarArray.add("jeffshenning@gmail.com"); // Jeff
        calendarArray.add("henninggirl1@gmail.com"); // K
        calendarArray.add("henninggirl2@gmail.com"); // A
        calendarArray.add("henninggirl3@gmail.com"); // M
        calendarArray.add("t03dkgt4gvqm1tl792hcm0ql88@group.calendar.google.com"); //LHSS
        calendarArray.add("58nil80fqtf56i1cv7h96udals@group.calendar.google.com"); // Henning Family
        calendarArray.add("#contacts@group.v.calendar.google.com");  // Birthdays
        calendarArray.add("o22mk8hghlccklg0q5tipel4r8@group.calendar.google.com"); // General
        calendarArray.add("en.usa#holiday@group.v.calendar.google.com"); // US Holidays



        // List the next 10 events from the primary calendar.
        DateTime now = new DateTime(System.currentTimeMillis());
        Events events = service.events().list("primary")
                .setMaxResults(10)
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items = events.getItems();
        if (items.size() == 0) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            for (Event event : items) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                System.out.printf("%s (%s)\n", event.getSummary(), start);
            }
        }

        // **ADDITIONAL - TRYING TO ACCESS THE OTHER CALENDARS
        // List the next 10 events from the specified calendar.
        System.out.println();
        System.out.println("Printing from MY CALENDAR");
        DateTime now2 = new DateTime(System.currentTimeMillis());
        Events events2 = service.events().list("kamsmommy@gmail.com")
                .setMaxResults(10)
                .setTimeMin(now2)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();
        List<Event> items3 = events2.getItems();
        if (items3.size() == 0) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events2");
            for (Event event : items3) {
                DateTime start = event.getStart().getDateTime();
                if (start == null) {
                    start = event.getStart().getDate();
                }
                System.out.printf("%s (%s)\n", event.getSummary(), start);
            }
        }

        // List the next 10 events from the specified calendar.
        int x = 0;
        while (x != calendarArray.size()) {
            String calendar = calendarArray.get(x);
            System.out.println();
            System.out.println("Printing from " + calendar + " CALENDAR");
            DateTime now3 = new DateTime(System.currentTimeMillis());
            Events events3 = service.events().list(calendar)
                    .setMaxResults(10)
                    .setTimeMin(now3)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();
            List<Event> items4 = events3.getItems();
            if (items4.size() == 0) {
                System.out.println("No upcoming events found.");
            } else {
                System.out.println("Upcoming events3");
                for (Event event : items4) {
                    DateTime start = event.getStart().getDateTime();
                    if (start == null) {
                        start = event.getStart().getDate();
                    }
                    System.out.printf("%s (%s)\n", event.getSummary(), start);
                }
            }
            x++;
        }
    }
}