package ScorePlay;


public class TennisGameScoring {

    public TennisGameScoring() {
    }

    public static String getPointName(int points) {
        switch (points) {
            case 0: return "love";
            case 15: return "fifteen";
            case 30: return "thirty";
            case 40: return "forty";
            default: return "";
        }
    }
    public static String convert(int player1, int player2) {
       String result = "";
       result += checkTieScore(player1, player2);
       result += checkAdvantage(player2, player1);
       result += normalScore(player1, player2);
       return result;
    }
    private static String checkTieScore(int player1, int player2) {
        if (checkTieMore40Points(player1, player2)) {
            return "deuce";
        }else return "";
    }

    private static String checkAdvantage(int player1, int player2){
        if(player1 >=40 && player2 >= 40 && player1 != player2){
            if(player1 > player2){
                if(player1-player2 == 10){
                return "advantage Player2";
                }else{return "Win player2";}

            }else if(player2-player1 == 10) {
                    return "advantage Player1";
            }else{return "Win player1";}
        }else return "";

    }

    private static String normalScore(int player1, int player2) {
        if ((player1 <= 40 &&  player2 <= 40) && !checkTieMore40Points(player1, player2)) {
            return  getPointName(player1)+"-"+ getPointName(player2);
        }else return "";
    }
    public static boolean checkTieMore40Points(int player1, int player2) {
        return (player1 == player2 && player1 >= 40);
    }
}
