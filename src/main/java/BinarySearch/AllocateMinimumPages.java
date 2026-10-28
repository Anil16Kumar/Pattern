package BinarySearch;

public class AllocateMinimumPages {

        public static boolean isPossible(int[] books, int students, int maxPages) {

            int studentCount = 1;
            int pagesSum = 0;

            for (int pages : books) {

                if (pagesSum + pages <= maxPages) {
                    pagesSum += pages;
                } else {
                    studentCount++;
                    pagesSum = pages;

                    if (studentCount > students) {
                        return false;
                    }
                }
            }
            return true;
        }

        public static int allocateBooks(int[] books, int students) {

            int max = 0;
            int sum = 0;

            for (int pages : books) {
                max = Math.max(max, pages);
                sum += pages;
            }

            int low = max;// maximum value hi low me kyu?? books[] ke andar ka maximum value se kaam value loge,
            // to maximum value kisi bhi student ko allocate hi nahi hoga, but question says
            // saari books student me allocate honi chahiye

            int high = sum; // kisi bhi bache ko maximum kitna books de sakte hai? ek hi student saari book de do
            // (possible answer, but aaisa karne se baki ke baacho ko kuchh bhi nahi milega)
            //so, the highest possible value will be the sum of all values inside the books[].

            int ans = -1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (isPossible(books, students, mid)) {
                    ans = mid;
                    high = mid - 1; // smaller answer try
                } else {
                    low = mid + 1;
                }
            }

            return ans;
        }
    public static void main(String[] args) {

    }
}
/*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in
the i-th book. You also have an integer k representing the number of students. The task is to
allocate books to each student such that:

Each student receives at least one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
All books must be allocated.
The objective is to minimize the maximum number of pages assigned to any student. In other words,
out of all possible allocations, find the arrangement where the student who receives the most pages
still has the smallest possible maximum. If it is not possible to allocate books to all students,
return -1;

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to
each student.
Constraints:

1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i], k ≤ 10^4

* */