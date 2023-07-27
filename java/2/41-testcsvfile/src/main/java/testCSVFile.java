import java.io.*;

public class testCSVFile {

    public static void main(String[] args) {
        String[][] infor = new String[1000][1000];
        String order;
        int lens = 0;
        String command[] = new String[100];
        //read the file:
        int people = 0;
        try{
            File f = new File(args[0]);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = null;
            while ((line = br.readLine()) != null) {
                int i = 0;
                for (String ret : line.split(",")) {
                    infor[people][i] = ret;
                    i++;
                }
                people++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //read the order:

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            order = br.readLine();
            for (String ret: order.split(" ")) {
                command[lens] = ret;
                lens++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //address the command:

        //排序：
        int rank = 0;
        //排序好后的行：
        int[] flag = new int[people];
        String[] str = new String[5];
        for (int i = 0; i < people; i++) {
            flag[i] = people - i - 1;
        }

        if (command[2] != null) {//have order

            if ("Salary".equals(command[4])) {
                rank = 2;
                for (int i = 0; i < people; i++) {
                    for (int j = 0; j < people - i - 1; j++) {
                        if (Integer.parseInt(infor[flag[j]][rank]) > Integer.parseInt(infor[flag[j + 1]][rank])) {
                            int tmp = flag[j + 1];
                            flag[j + 1] = flag[j];
                            flag[j] = tmp;
                        }
                    }
                }
            }

            if ("Employee_id".equals(command[4])) {
                rank = 4;
                for (int i = 0; i < people; i++) {
                    for (int j = 0; j < people - i - 1; j++) {
                        if (Integer.parseInt(infor[flag[j]][rank]) > Integer.parseInt(infor[flag[j + 1]][rank])) {
                            int tmp = flag[j + 1];
                            flag[j + 1] = flag[j];
                            flag[j] = tmp;
                        }
                    }
                }

            }
        }
        int limit = 0;
        for (int i = 0; i < lens; i++) {
            if ("limit".equals(command[i])) {
                limit = Integer.parseInt(command[i + 1]);
            }
        }
        //第二个是“ * ”：
        if ("*".equals(command[1])) {
            System.out.println("Last_name    First_name    Salary    Department    Employee_id");
            if (limit != 0) {
                //limit:
                for (int i = 0; i < limit; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j != 4) {
                            System.out.print(infor[flag[people - i - 1]][j] + "    ");
                        } else {
                            System.out.print(infor[flag[people - i - 1]][j]);
                        }
                    }
                    System.out.println();
                }

            } else {//no limit
                for (int i = 0; i < people; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (j != 4) {
                            System.out.print(infor[flag[people - i - 1]][j] + "    ");
                        } else {
                            System.out.print(infor[flag[people - i - 1]][j]);
                        }
                    }
                    System.out.println();
                }
            }

        }
        //不是 “ * ”：
        else {
            int num = 0;
            for (String ret : command[1].split(",")) {
                str[num] = ret;
                num++;
            }
            int[] name = new int[num];

            for (int i = 0; i < num; i++) {
                if ("Last_name".equals(str[i])) {
                    name[i] = 0;
                }
                if ("First_name".equals(str[i])) {
                    name[i] = 1;
                }
                if ("Salary".equals(str[i])) {
                    name[i] = 2;
                }
                if ("Department".equals(str[i])) {
                    name[i] = 3;
                }
                if ("Employee_id".equals(str[i])) {
                    name[i] = 4;
                }
            }

            //print:
            for (int i = 0; i < num; i++) {
                if (i == num - 1) {
                    System.out.print(str[i]);
                } else {
                    System.out.print(str[i] + "    ");
                }
            }
            System.out.println();

            if (limit != 0) {
                // have limit
                for (int i = 0; i < limit; i++) {
                    for (int j = 0; j < num; j++) {
                        if (j != num) {
                            System.out.print(infor[flag[people - i - 1]][name[j]] + "    ");
                        } else {
                            System.out.print(infor[flag[people - i - 1]][name[j]]);
                        }
                    }
                    System.out.println();

                }
            } else {// no limit
                for (int i = 0; i < people; i++) {
                    for (int j = 0; j < num; j++) {
                        if (j != num) {
                            System.out.print(infor[flag[people - i - 1]][name[j]] + "    ");
                        } else {
                            System.out.print(infor[flag[people - i - 1]][name[j]]);
                        }
                    }
                    System.out.println();

                }
            }
        }
    }

}
