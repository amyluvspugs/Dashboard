package classes;

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

import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.*;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Quickstart {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME =
            "Google Calendar API Java classes.Quickstart";

    /**
     * Directory to store user credentials for this application.
     */
    private static final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/calendar-java-quickstart");

    /**
     * Global instance of the {@link FileDataStoreFactory}.
     */
    private static FileDataStoreFactory DATA_STORE_FACTORY;

    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY =
            JacksonFactory.getDefaultInstance();

    /**
     * Global instance of the HTTP transport.
     */
    private static HttpTransport HTTP_TRANSPORT;

    /**
     * Global instance of the scopes required by this quickstart.
     * <p>
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
     *
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
     *
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

    public static List<CalItems> getItems() throws IOException{
        com.google.api.services.calendar.Calendar service =
                getCalendarService();

        List<CalItems> items = new ArrayList<>();
        String[] calendarId = new String[11];
        calendarId[0] = "primary"; // built in for email
        calendarId[1] = "kamsmommy@gmail.com"; // Me
        calendarId[2] = "jeffshenning@gmail.com"; // Jeff
        calendarId[3] = "henninggirl1@gmail.com"; // K
        calendarId[4] = "henninggirl2@gmail.com"; // A
        calendarId[5] = "henninggirl3@gmail.com"; // M
        calendarId[6] = "t03dkgt4gvqm1tl792hcm0ql88@group.calendar.google.com"; //LHSS
        calendarId[7] = "58nil80fqtf56i1cv7h96udals@group.calendar.google.com"; // Henning Family
        calendarId[8] = "#contacts@group.v.calendar.google.com";  // Birthdays
        calendarId[9] = "o22mk8hghlccklg0q5tipel4r8@group.calendar.google.com"; // General
        calendarId[10] = "en.usa#holiday@group.v.calendar.google.com"; // US Holidays

        // List the next 10 events from the calendar.
        for (int loop = 0; loop < calendarId.length; loop++) {

          //  DateTime now = new DateTime(System.currentTimeMillis());
          //  System.out.println("Date time: " + now);
          //  Date d = new java.util.Date();

            LocalDateTime now = LocalDateTime.now();
            LocalDateTime startofDay = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 0, 0);
           DateTime gStartofDay = new DateTime(startofDay.toEpochSecond(ZoneOffset.ofHours(-5))*1000);
            // Date today = new Date();

            System.out.println("gDate: " + gStartofDay);
            //DateTime tomorrow = new LocalDate(today);

           // System.out.println("Date startofDay: " + startofDay);

            //DateTime tomorrow = new DateTime(System.currentTimeMillis());
            //tomorrow = (now + (1000 * 60 * 60 * 24));

//
            Events events = service.events().list(calendarId[loop])
//                    .setTimeMin(now)
 //                   .setTimeMax(today)
//                    .setOrderBy("startTime")
//                    .setSingleEvents(true)
//                    .execute();

                    .setMaxResults(3)
                    //.setTimeMax(tomorrow);
                    .setTimeMin(gStartofDay)
                    .setOrderBy("startTime")
                    .setSingleEvents(true)
                    .execute();

            List<Event> itemsC = events.getItems();
            //items.add(events.getItems());

            //System.out.println("EVENTS LIST: " + events.getItems()); //prints all events and properties
            if (itemsC.size() == 0) {
                // System.out.println("No upcoming events found.");
            } else {
                //TODO figure out how to print current calendar name

                for (Event event : itemsC) {
                    String x;
                    EventDateTime y;
                    String z;
                    String a;
                    x = event.getSummary();
                    y = event.getStart();
                    z = event.getDescription();  /// want to change this to calendarID
                    a = event.getStart().toString();
                    items.add(new CalItems(x,a,z));
                }
            }
        }
        return items;
    }
}