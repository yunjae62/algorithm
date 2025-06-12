import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] countryStudent = new int[101];
    static List<Student> students = new ArrayList<>();

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int country = stoi(st.nextToken());
            int num = stoi(st.nextToken());
            int score = stoi(st.nextToken());

            Student student = new Student(country, num, score);
            students.add(student);
        }

        Collections.sort(students);

        int rank = 0;

        for (Student student : students) {
            if (rank >= 3) {
                break;
            }

            if (countryStudent[student.country] >= 2) {
                continue;
            }

            System.out.println(student.country + " " + student.num);
            countryStudent[student.country]++;
            rank++;
        }
    }

    static class Student implements Comparable<Student> {

        int country, num, score;

        public Student(int country, int num, int score) {
            this.country = country;
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Student o) {
            return Integer.compare(o.score, this.score);
        }

        @Override
        public String toString() {
            return this.country + " " + this.num;
        }
    }
}