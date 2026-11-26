class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean turn = true;

        while (n >= remove) {
            n -= remove;
            remove--;
            turn = !turn;
        }

        return !turn;
    }
}