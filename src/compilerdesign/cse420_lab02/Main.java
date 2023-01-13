package compilerdesign.cse420_lab02;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int wrong = 0;
        for (int i = 1; i <= n; i++) {
            String s = input.next();
            if (s.contains("@")) {
                if (emailVerify(s)) {
                    System.out.println("Email, " + (i - wrong));
                } else {
                    wrong++;
                    System.out.println("Invalid Email");
                }
            } else if (webVerify(s)) {
                System.out.println("Website, " + (i - wrong));
            } else {
                wrong++;
                System.out.println("Invalid Website");
            }
        }
    }

    static boolean emailVerify(String s) {
        String[] email = s.split("@");
        //System.out.println(email[0] + "\n"+email[1]);
        char[] userName = email[0].toCharArray();
        char[] domainName = email[1].toCharArray();
        //System.out.println(userName[0]+"\n"+userName[userName.length-1]);
        boolean check1 = false, check2 = false;

        //UserName part
        if (userName[0] != 46 && userName[0] != 95 && userName[userName.length - 1] != 46 && userName[userName.length - 1] != 95) {
            for (int j = 0; j < userName.length; j++) {
                if ((userName[j] >= 65 && userName[j] <= 90) || (userName[j] >= 48 && userName[j] <= 57)
                        || (userName[j] >= 97 && userName[j] <= 122) || userName[j] == 46 || userName[j] == 95) {
                    check1 = true;
                } else {
                    check1 = false;
                    break;
                }
                //Checking '..' , '__' , '._' , '_.'
                if(j!=0){
                    if((userName[j] == 46 && userName[j-1]==46) || (userName[j] == 95 && userName[j-1] == 95) || 
                            (userName[j] == 95 && userName[j-1] == 46) ||(userName[j] == 46 && userName[j-1] == 95)){
                        check1 = false;
                        break;
                    }
                }
            }
        }
        //domain part
        if (domainName[0] != 46 && domainName[domainName.length - 1] != 46) {
            for (int j = 0; j < domainName.length; j++) {
                if ((domainName[j] >= 65 && domainName[j] <= 90) || (domainName[j] >= 97 && domainName[j] <= 122) || domainName[j] == 46) {
                    check2 = true;
                } else {
                    check2 = false;
                    break;
                } 
                //Checking '..'
                if(j!=0){
                    if(domainName[j] == 46 && domainName[j-1]==46){
                        check2 = false;
                        break;
                    }
                }
            }
        }

        if (check1 && check2) {
            return true;
        } else {
            return false;
        }
    }

    static boolean webVerify(String s) {
        String[] str1 = s.split("\\.", 2);
        char[] www = str1[0].toCharArray();
        boolean check1 = false;

        //first part check
        for (int i = 0; i < www.length; i++) {
            if (www[i] == 119 || www[i] == 87) {
                check1 = true;
            } else {
                check1 = false;
                break;
            }
        }

        String[] str2 = str1[1].split("\\.", 2);
        boolean check2 = false;
        boolean check3 = false;
        char[] name = str2[0].toCharArray();
        char[] domainName = str2[1].toCharArray();

        // Website name
        for (int j = 0; j < name.length; j++) {
            if ((name[j] >= 65 && name[j] <= 90) || (name[j] >= 48 && name[j] <= 57)
                    || (name[j] >= 97 && name[j] <= 122)) {
                check2 = true;
            } else {
                check2 = false;
                break;
            }
        }
        //Domain name
        if (domainName[0] != 46 && domainName[domainName.length - 1] != 46) {
            for (int j = 0; j < domainName.length; j++) {
                if ((domainName[j] >= 65 && domainName[j] <= 90) || (domainName[j] >= 97 && domainName[j] <= 122) || domainName[j] == 46) {
                    check3 = true;
                } else {
                    check3 = false;
                    break;
                }
                //Checking '..'
                if(j!=0){
                    if(domainName[j] == 46 && domainName[j-1]==46){
                        check3 = false;
                        break;
                    }
                }
            }
        }

        if (check1 && check2 && check3) {
            return true;
        } else {
            return false;
        }

    }
}
