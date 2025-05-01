package pro1;

import com.google.gson.Gson;
import pro1.apiDataModel.ActionsList;
import pro1.apiDataModel.DeadlineList;

import java.util.Comparator;
import java.util.stream.Collectors;

public class Main7 {
    public static void main(String[] args){System.out.println(specializationDeadlines(2025));}
    public static String specializationDeadlines(int year){
        String json = Api.getSpecializations(year);
        DeadlineList deadlines = new Gson().fromJson(json, DeadlineList.class);

        String result = deadlines.items.stream().map(a->a.date.value)
                .distinct()

                .sorted(Comparator.comparing((String a) -> Integer.parseInt(a.split("\\.")[2]))
                        .thenComparing((String a) -> Integer.parseInt(a.split("\\.")[1]))
                        .thenComparing((String a) -> Integer.parseInt(a.split("\\.")[0])))

                .collect(Collectors.joining(","));

        return result; // TODO udelej to LOL
    }

}