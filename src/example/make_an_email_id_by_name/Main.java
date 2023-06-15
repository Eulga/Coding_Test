package example.make_an_email_id_by_name;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
문자열 abc 안에 들어있는 입사자들의 이름으로 이메일을 제작해야 한다.
first name 과 middle name(있다면) 의 첫 자를 떼고 last name을 붙인다 이 때 last name 의 길이가 9자 이상이라면 8자 까지만 잘라낸다.
문자열 C안에 들어있는 회사명을 붙이고 .com으로 끝낸다.

최종적으로 abc안 각각의 이름 옆에 완성된 이메일을 붙여 하나의 문자열로 만들어 반환한다.

ex)
abc = John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker
C = Example

Answer = John Doe jdoe@example.com, Peter Parker pparker@example.com, Mary Jane Watson-Parker mjwatsonpa@example.com,
James Doe jdoe2@example.com, John Elvis Doe jedoe@example.com, Jane Doe jdoe3@example.com, Penny Parker pparker2@example.com
*/


public class Main {
    public static void main(String[] args) {
        String abc = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        C = C.toLowerCase();

        List<String> aList = new ArrayList<>();
        HashMap<String, Integer> aMap = new HashMap<>();
        for(String a : abc.replaceAll("-", "").toLowerCase().split(", ")) {
            String name = "";
            String emailName = "";

            for(String c : a.split(" ")) {
                name = c;
                emailName += name.charAt(0);
            }
            if(name.length() > 8) emailName += name.substring(1, 8);

            else emailName += name.substring(1, name.length());

            aMap.put(emailName, aMap.getOrDefault(emailName, 0) + 1);

            if(aMap.get(emailName) > 1) emailName += aMap.get(emailName);
            aList.add(emailName);
        }

        String answer = "";
        int i = 0;
        for(String a : abc.split(", ")) {
            answer += a+" <" + aList.get(i++) + "@" + C + ".com>, ";
        }

        System.out.println(answer.replaceAll("(, $)", ""));
    }
}
