package at.madlmayr.kata13;

public class MineSweeper {

    private static void unhideMind(int x, int y, int[][] game, int[][] visits) {
        if (game[x][y] != 9) {
            visits[x][y] = 1;
            if (game[x][y] == 0) {
                game[x][y] = -1;
            }

            if (game[x].length > y + 1 && visits[x][y + 1] != 1) {
                unhideMind(x, y + 1, game, visits);
            }

            if (y - 1 > 0 && visits[x][y - 1] != 1) {
                unhideMind(x, y - 1, game, visits);
            }

            if (game.length > x + 1 && visits[x + 1][y] != 1) {
                unhideMind(x + 1, y, game, visits);
            }

            if (x - 1 > 0 && visits[x - 1][y] != 1) {
                unhideMind(x - 1, y, game, visits);
            }
        }
    }

    private static int[][] generateGame(int x, int y, int bombes) {
        int[][] game = new int[x][y];

        for (int bomb = 0; bomb < bombes; bomb++) {
            int randX = (int) (Math.random() * x);
            int randY = (int) (Math.random() * y);
            game[randX][randY] = 9;
        }
        return game;
    }

    private static void findMines(int x, int y, int[][] game, int[][] visits) {
        if (game[x][y] != 9) {
            visits[x][y] = 1;
            if (game[x].length > y + 1 && visits[x][y + 1] != 1) {
                if (game[x][y + 1] == 9) {
                    game[x][y]++;
                }
                findMines(x, y + 1, game, visits);
            }

            if (y - 1 > 0 && visits[x][y - 1] != 1) {
                if (game[x][y - 1] == 9) {
                    game[x][y]++;
                }
                findMines(x, y - 1, game, visits);
            }

            if (game.length > x + 1 && visits[x + 1][y] != 1) {
                if (game[x + 1][y] == 9) {
                    game[x][y]++;
                }
                findMines(x + 1, y, game, visits);
            }

            if (x - 1 > 0 && visits[x - 1][y] != 1) {
                if (game[x - 1][y] == 9) {
                    game[x][y]++;
                }
                findMines(x - 1, y, game, visits);
            }
        }
    }


    private static String printGame(int[][] game) {
        StringBuffer sb = new StringBuffer();
        for (int x = 0; x < game.length; x++) {
            for (int y = 0; y < game[x].length; y++) {
                if (game[x][y] == -1) {
                    sb.append("-").append(" ");
                } else {
                    sb.append(game[x][y]).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int[][] v = new int[x][y];
        int[][] g = generateGame(x, y, 10);

        findMines(0, 0, g, new int[x][y]);

        unhideMind(0, 0, g, new int[x][y]);

        System.out.print(printGame(g));
        System.out.println("---------");
        System.out.print(printGame(v));
    }


}
