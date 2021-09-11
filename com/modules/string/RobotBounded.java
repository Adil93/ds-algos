package string;

public class RobotBounded {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GL"));
    }

    public static boolean isRobotBounded(String instructions) {

        if (instructions == null || instructions.length() == 0)
            return false;

        int len = instructions.length();

        // instructions = instructions.repeat(4);

        int x = 0;
        int y = 0;

        int dir = 0; // North

        for (int i = 0; i < len; i++) {
            char move = instructions.charAt(i);

            if (move == 'R')
                dir = (dir + 3) % 4;
            else if (move == 'L') {
                dir = (dir + 5) % 4;
            } else {

                if (dir == 0)
                    y++;
                else if (dir == 1)
                    x++;
                else if (dir == 2)
                    y--;
                else // dir == 3
                    x--;
            }

        }

        return (x == 0 && y == 0) || (dir != 0);
    }
}
