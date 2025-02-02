import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        List<Book> books = new ArrayList<>();
        Queue<Book> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.end, o2.end));
        
        for (String[] time : book_time) {
            books.add(new Book(time[0], time[1]));
        }
        
        Collections.sort(books, (o1, o2) -> Integer.compare(o1.start, o2.start));
        
        for (Book now : books) {
            if (!q.isEmpty() && q.peek().end + 10 <= now.start) {
                q.poll();
            }
            
            q.add(now);
        }
        
        return q.size();
    }
    
    class Book {
        
        int start, end;
        
        public Book(String start, String end) {
            String[] st = start.split(":");
            this.start = Integer.valueOf(st[0]) * 60 + Integer.valueOf(st[1]);
            
            String[] en = end.split(":");
            this.end = Integer.valueOf(en[0]) * 60 + Integer.valueOf(en[1]);
        }
    }
}