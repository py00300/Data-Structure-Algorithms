package coursera.algorithms.week.two.facebook;

public class FB2 {

// class MovingAverage {
//   Queue<Integer> numbers = new LinkedList<>();
//   int windowSize = 0;
//   int sum = 0;

//   MovingAverage(int n) {
//     this.windowSize = n;
//   }

//   void put(int item) {
//     numbers.offer(item);
//     sum += item;
//     if (numbers.size() > windowSize) {
//       int i = numbers.poll();
//       sume -= i;
//     }
//   }

//   double movingAverage() {

//     if (windowSize >= numbers.size()) {

//       return sum / numbers.size();
//     } else {

//       return sum / windowSize;
//     }
//   }
// }

// MovingAverage m = new MovingAverage(3);
// m.put(1);
// System.out.println(m.movingAverage()); // 1.0
// m.put(2);
// System.out.println(m.movingAverage()); // 1.5
// m.put(3);
// System.out.println(m.movingAverage()); // 2.0
// m.put(4);
// System.out.println(m.movingAverage()); // 3.0
// m.put(5);
// System.out.println(m.movingAverage()); // 4.0



/*2 strings are equivalent if they can be encoded / decoded via Caesar Cipher, for some shift value,
to each other. Given a list of strings of all the same length, group together equivalent strings.
      Examples:
  Equivalence:
      'abc' <=> 'bcd' <=> 'efg' <=> 'xyz' <=> 'zab'
      'acd' <=> 'bde'
  Problem statement:
  input: ['abc', 'bcd', 'abc', 'acd', 'bde', 'efg', 'cef']
  output: [['abc', 'bcd', 'efg'], ['acd', 'bde']]

      'abc' <-> 'bcd'
      'acd' <-> 'cef'*/


}
