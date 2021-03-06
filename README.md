<h1>Triangle Max Sum</h1>

By starting at the top of the triangle and moving to adjacent numbers on the
row below, the maximum total from top to bottom is 27.
 
<pre>
                5
               9 6
              4 6 8
             0 7 1 5
</pre>

i.e. 5 + 9 + 6 + 7 = 27.
 
Write a program in Java to find the maximum total from top to bottom in the
included file ‘triangle.txt’ - a text file containing a triangle with 100
rows.

<h2>To run</h2>
<pre>
git clone https://github.com/fletcher86/triangle-max-sum.git
cd triangle-max-sum
./gradlew clean build
java -jar ./build/libs/triangle-max-sum-1.0.jar < triangle.txt
</pre>

<h2>Additional Comments</h2>

The computed triangle sums were computed from a bottom up approach because if using a top down approach the sum may not be maximized.  For example, using a top down approach, it is possible to have sums weighted toward one side of the triangle, but a single outlier on the opposite side and bottom of the triangle that could have impacted the max sum calculation and would have been missed with a top down approach.  In order to take into account this possibility, a bottom up approach was necessary.

Sums were rolled up from the bottom up as follows.

<pre>
                5
               9 6
              4 6 8
             0 7 1 5
</pre>
<pre>
                5
               9 6
             11 13 12
</pre>
<pre>
                5
              22 19
</pre>
<pre>
               27
</pre>

The computed output for "triangle.txt" is
<pre>
Max Sum = 732506
</pre>

The computed output for "triangle0.txt" is
<pre>
Max Sum = 23
</pre>

The computed output for "triangle1.txt" is
<pre>
Max Sum = 1074
</pre>

The computed output for "triangle2.txt" is
<pre>
Max Sum = 27
</pre>
This last input file, triangle2.txt, is the same input described in the problem description above.