    public int solution(int[] stones, int k) {
        int first = 1;
        int last = Arrays.stream(stones).max().getAsInt();

        while (first <= last) {
            int mid = (first + last) / 2;
            if (binary_search(mid, k, stones))
                last = mid - 1;
            else
                first = mid + 1;
        }
        return first;
    }

    boolean binary_search(int mid, int k, int[] list) {
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] - mid <= 0){
                count++;
            } else{
                count = 0;
            }
            if (count >= k)
                return true;
        }
        return false;
    }
