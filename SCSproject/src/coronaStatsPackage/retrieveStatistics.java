package coronaStatsPackage;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class retrieveStatistics {

    //                                                                          Check URL validity so we dont have to deal with MalformedURLException
    public static void isUrlValid(String url) {
        try {
            URL obj = new URL(url);
            obj.toURI();
        } catch (MalformedURLException er) {
        } catch (URISyntaxException er) {
        }
    }
    //                                                                          Retrieves and returns data from the URL
    public String getStrData(@NotNull String string) {
        String JSONStr = "";
        String url1 = "https://rki.marlon-lueckert.de/api/general";
        String url2 = "https://rki.marlon-lueckert.de/api/states";
        String url3 = "https://rki.marlon-lueckert.de/api/districts";
        isUrlValid(url1);
        isUrlValid(url2);
        isUrlValid(url3);
        try {
            final URL general = new URL("https://rki.marlon-lueckert.de/api/general\n");
            final URL states = new URL("https://rki.marlon-lueckert.de/api/states\n");
            final URL districts = new URL("https://rki.marlon-lueckert.de/api/districts\n");
            switch (string) {
                case "general":
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(general.openStream()));
                    JSONStr = br.readLine();
                    if (JSONStr != null) {
                        System.out.println(JSONStr);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
                case "states":
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(states.openStream()));
                    JSONStr = br.readLine();
                    if (JSONStr != null) {
                        System.out.println(JSONStr);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
                case "districts":
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(districts.openStream()));
                    JSONStr = br.readLine();
                    if (JSONStr != null) {
                        System.out.println(JSONStr);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        } catch (MalformedURLException error) {
            // Output expected MalformedURLExceptions.
        }

        return JSONStr;
    }
//                                                                              Create json data from string
    public JSONObject parseStrToJSON(String string) {
        String JSONStr = getStrData(string);
        JSONObject json = null;
        try {
            json = new JSONObject(JSONStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
//                                                                              Convert a long number to have proper date format
    public String convertEpochTime(long epoch) {
        Date date = new Date(epoch);
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("Berlin"));
        return format.format(date);
    }

//                                                                              Return covid-19 statistics of the world
    public String displayGeneralStats() {
        JSONObject json = parseStrToJSON("general");
        JSONObject dailyChange = json.getJSONObject("difference");
        String info = "Last update: " + json.getString("lastUpdate") + "\n"
                + "Total cases: " + json.getInt("cases") + "\n"
                + "Total cases in the last 7 days: " + json.getInt("casesPerWeek") + "\n"
                + "Cases per 100K population: " + json.getFloat("casesPer100k") + "\n"
                + "Cases in the last 7 days/100K population: " + json.getFloat("weekIncidence") + "\n"
                + "Recovered: " + json.getInt("recovered") + "\n"
                + "Deaths: " + json.getInt("deaths") + "\n";
        try {
            info += "New cases in yesterday: " + dailyChange.getInt("cases") + "\n"
                    + "New deaths in yesterday: " + dailyChange.getInt("deaths") + "\n"
                    + "New recovered cases in yesterday: " + dailyChange.getInt("recovered") + "\n";
        } catch (JSONException ex) {
        }
        return (info);
    }
//                                                                              Return covid-19 statistics of a specific German state
    public String displayStatesStats(String searchName) {
        JSONObject json = parseStrToJSON("states");
        String dateTime = convertEpochTime(json.getLong("lastUpdate"));
        JSONArray dataArray;
        dataArray = json.getJSONArray("states");
        String info1 = "";
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject obj = dataArray.getJSONObject(i);
            String name = obj.getString("name");
            if (name.equalsIgnoreCase(searchName)) {
                try {
                    info1 += "Last update: " + dateTime + "\n"
                            + "State: " + name + "\n"
                            + "Total cases: " + obj.getInt("count") + "\n"
                            + "New cases in this week per 100K population: " + obj.getInt("weekIncidence") + "\n"
                            + "Deaths: " + obj.getInt("deaths") + "\n"
                            + "Cases per 100K population: " + obj.getInt("casesPer100k");
                } catch (JSONException ex) {
                }

            }
        }
        String info = info1;
        return info;
    }
//                                                                              Return covid-19 statistics of a specific German district
    public String displayDistrictsStats(String searchName) {
        JSONObject json = parseStrToJSON("districts");
        String dateTime = json.getString("lastUpdate");
        JSONArray dataArray;
        dataArray = json.getJSONArray("districts");
        String info1 = "";
        for (int i = 0; i < dataArray.length(); i++) {
            JSONObject obj = dataArray.getJSONObject(i);
            String name = obj.getString("name");
            if (name.equalsIgnoreCase(searchName)) {
                info1 = "Last update: " + json.getString("lastUpdate") + "\n"
                        + "District: " + name + "\n"
                        + "Total cases: " + obj.getInt("count") + "\n"
                        + "New cases in this week per 100K population: " + obj.getInt("weekIncidence") + "\n"
                        + "Deaths: " + obj.getInt("deaths") + "\n"
                        + "Cases per 100K population: " + obj.getInt("casesPer100k") + "\n"
                        + "Cases per population: " + obj.getFloat("casesPerPopulation");
            }
        }
        String info = info1;
        return info;
    }
//                                                                              Return the list of names of states and districts for users to choose from
    public Object[] getNames(String string) {
        ArrayList<String> info1 = new ArrayList<>();
        switch (string) {
            case "states" -> {
                JSONObject json = parseStrToJSON("states");
                JSONArray dataArray = json.getJSONArray("states");
                //dataArray = json.getJSONArray("states");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject obj = dataArray.getJSONObject(i);
                    String name = obj.getString("name");
                    info1.add(name);
                }
            }

            case "districts" -> {
                JSONObject json = parseStrToJSON("districts");
                JSONArray dataArray = json.getJSONArray("districts");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject obj = dataArray.getJSONObject(i);
                    String name = obj.getString("name");
                    info1.add(name);
                }
            }
        }
        return info1.toArray();
    }
}
