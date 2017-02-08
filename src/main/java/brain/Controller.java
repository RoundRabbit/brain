package brain;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import pinky.Pinky;

public class Controller {

    private static Controller me;

    public static Controller getController() {

        if (me == null) {
            me = new Controller();
        }

        return me;
    }

    private final List<Pinky> pinkys = new ArrayList<Pinky>();

    private Controller() {
        super();
    }

    /**
     * @param pinky
     * @throws Exception
     */
    public void greet(final Pinky pinky) throws Exception {

        final URL obj = new URL(pinky.getUrl());

        final HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setConnectTimeout(20000);
        con.setDoOutput(true);

        final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(("greeting=Hi " + pinky.getName() + "!").getBytes());
        wr.flush();
        wr.close();

        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        final StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        System.out.println(response.toString());
    }

    /**
     * @param pinky
     */
    public void register(final Pinky pinky) {

        this.pinkys.add(pinky);
    }
}
