import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] strArray = {{"1", "2", "3"}, {"4", "5", "6"}, {"7", "8", "9"}};
        Scanner sn = new Scanner(System.in);
        int scIn = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                 System.out.print(strArray[i][j] + "   |   ");

            }
            System.out.println(" ");
            System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        }


        System.out.println("Куда поставить крестик/нолик? Введите номер ячейки ячейки");
        while (scIn<9) {
            System.out.println("Куда поставить крестик/нолик? Введите номер ячейки ячейки");
            int place = sn.nextInt();
            int k=0,l=0;
            int pointStr=0;
            int pointCol=0;
            int pointDg1=0;
            int pointDg2=0;
            int user = 0;
            String ch ="";

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (strArray[i][j].equals(Integer.toString(place))) {
                        k = i;
                        l = j;
                    }
                }
            }

            if (scIn % 2 == 0) {
                user =1;
                strArray[k][l] = "X";
                //Проверка строки
                for (int j = 0; j < 3; j++) {
                    if (strArray[k][j].equals("X")) {
                        pointStr++;
                    }
                }
            }
            else {
                user=2;
                strArray [k][l]="O";
            }

            if(user==1){
                ch="X";
            }
            else {
                ch="O";
            }
            //Проверка столбца
            for (int i = 0; i < 3;i++) {
                if (strArray[i][l].equals(ch)) {
                    pointCol++;
                }
            }

            //Проверка диагонали 1
            for (int i = 0; i < 3;i++) {
                if (strArray[i][i].equals(ch)) {
                    pointDg1++;
                }
            }
            //Проверка диагонали 2
            for (int i = 0; i < 3;i++) {
                if (strArray[i][2-i].equals(ch)) {
                    pointDg2++;
                }
            }


            if (pointStr == 3||pointCol == 3||pointDg1 == 3||pointDg2 == 3) {
                System.out.println("Игрок " + user + " выиграл");
                break;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(strArray[i][j] + "   |   ");

                }
                System.out.println(" ");
                System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
            }
            scIn++;
        }
    }
}