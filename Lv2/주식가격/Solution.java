import java.util.*;

class Solution {
    class Stock {
        int price;
        int time;

        public Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }

    public int[] solution(int[] prices) {
        Queue<Stock> queue = new LinkedList<>();

        for (int i = 0; i < prices.length; i++) {
            queue.add(new Stock(prices[i], i));
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            Stock currStock = queue.poll();
            // System.out.println(currStock.time);

            int time = 0;

            for (Stock stock : queue) {
                // System.out.printf("curr price : %d next(%d) price : %d\n", currStock.price,
                // stock.time, stock.price);

                if (currStock.price > stock.price) {
                    list.add(stock.time - currStock.time);
                    break;
                } else {
                    time++;
                }

                if (stock.time == prices.length - 1) {
                    list.add(time);
                }
            }
        }

        list.add(0);

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String... args) {
        Solution test = new Solution();

        int[] prices = { 1, 2, 3, 2, 3 };

        System.out.println(Arrays.toString(test.solution(prices)));
    }
}
