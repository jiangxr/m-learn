import java.util.*;
public class BowlingScores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(scores(s));
    }

    public static int scores(String s) {
        int score = 0;
        ArrayList<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            if(c != '|') {
                list.add(c);
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == 'X')
                list2.add(10);
            else if (list.get(i) == '-') {
                list2.add(0);
            }else if(list.get(i) == '/') {
                list2.add(10-list2.get(i-1));
            }else {
                list2.add(Integer.valueOf(String.valueOf(list.get(i))));
            }

        }

        int j = 1;
        for(int i = 0; i < list2.size(); i++) {
                if (list2.get(i) == 10) {
                    score = score + 10 + list2.get(i + 1) + list2.get(i + 2);
                    j++;
                } else {
                    if (list2.get(i) + list2.get(i + 1) < 10) {
                        score = score + list2.get(i) + list2.get(i + 1);
                    } else {
                        score = score + list2.get(i) + list2.get(i + 1) + list2.get(i + 2);
                    }
                    j++;
                    i++;
                }
                if(j > 10) {
                    break;
                }
        }

        return score;
    }
}
	}
}
