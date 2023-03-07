public class DoubleArray {

        public void arrayTest() {                              //делаем метод для наполнения двумерного массива
            int[][] array = new int[4][6];                     //двумерный массив на 4 строки и 6 столбцы
            for (int i = 0; i < array.length; i++) {           //первый фор по строкам
                for (int j = 0; j < array[i].length; j++) {    // второй фор по столбцам
                    array[i][j] = i + j;
                }
            }

        }
// тут у нас метод для печати двумерного массива
        private void print(int[][] arr) {
            for (int row = 0; row < arr.length; row++)//Cycles through rows
            {
                for (int col = 0; col < arr[row].length; col++)//Cycles through columns
                {
                    System.out.printf("%5d", arr[row][col]); //change the %5d to however much space you want
                }
                System.out.println(); //Makes a new row
            }
        }

        }


