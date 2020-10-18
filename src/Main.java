import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Main{



    int n,ammo;
    String nama,type,namasenjata,Artype,Scope;
    Scanner scanf = new Scanner(System.in);
    Vector<Weapon> vecdata = new Vector<Weapon>();
    Random random = new Random();
    Weapon obj;
    Weapon obj1;
    Weapon obj2;
    int win,lose,map,Fire,reload,press;
    int index=-1;
    String soldier;
    int game=0;

    void insert() {
        do {
            System.out.printf("Insert your solder name [ Ghost | Gaz | CaptainPrice ]: ");
            nama = scanf.nextLine();
        }while(!nama.equals("Ghost")&&!nama.equals("Gaz")&&!nama.equals("CaptainPrice"));

        do {
            System.out.printf("Type of your gun [ Rifle | Sniper ]: ");
            type = scanf.nextLine();
        }while(!type.equals("Rifle") && !type.equals("Sniper"));

        if(type.equals("Rifle")) {
            do {
                System.out.printf("Insert rifle gun [ M4a1 | Ak-47 ]: ");
                namasenjata = scanf.nextLine();
            }while(!namasenjata.equals("M4a1") && !namasenjata.equals("Ak-47"));
            if(namasenjata.equals("M4a1")) {
                Artype = "Green_ammo";
            }
            if(namasenjata.equals("Ak-47")) {
                Artype = "Yellow_ammo";
            }
            ammo = 300;
            obj1 = new Rifle(nama, type, namasenjata, ammo, Artype);
            vecdata.add(obj1);
        }

        if(type.equals("Sniper")) {
            do {
                System.out.printf("Insert Sniper gun [ Kar-98k | Locus ]: ");
                namasenjata = scanf.nextLine();
            }while(!namasenjata.equals("Kar-98k") && !namasenjata.equals("Locus"));
            if(namasenjata.equals("Kar-98k")) {
                Scope = "NONE          ";
            }
            if(namasenjata.equals("Locus")) {
                Scope = "Tactical_Scope";
            }
            ammo = 100;
            obj2 = new Sniper(nama,type, namasenjata, ammo, Scope);
            vecdata.add(obj2);
        }

    }

    void show() {
        System.out.println("+=================================================================================+");
        System.out.printf("| %-2s | %-10s  |  %-5s | %-10s | %-10s |      Scope       | %-4s |\n","N0","Name_Soldier","Type","Name_Gun","Magazine","Ammo");
        System.out.println("+=================================================================================+");
        for(int i = 0; i < vecdata.size(); i++) {
            obj = vecdata.get(i);
            System.out.printf("| %d. | %-12s  | %-6s |",i+1, obj.getNama(), obj.getType());
            if( obj instanceof Rifle) {
                System.out.printf("%-6s      | %-11s|     Empty        | %-3d  |\n",obj.getNamasenjata() ,((Rifle) obj).getArtype() ,obj.getAmmo() );
            }
            if( obj instanceof Sniper){
                System.out.printf("%-7s     |   Empty    |%-11s    | %-3d  |\n",obj.getNamasenjata() ,((Sniper) obj).getScope() ,obj.getAmmo() );
            }
        }
        System.out.println("+=================================================================================+");
    }

    void war() {
        show();
        do {
            System.out.printf("Input Soldier to war [ 1 - "+vecdata.size()+" ]: ");
            index = scanf.nextInt();scanf.nextLine();
        }while(index<1 || index >vecdata.size());

        soldier = vecdata.get(index-1).getNama();

        do {
            System.out.println("+=================================================================================+");
            System.out.println("1. Crash");
            System.out.println("2. Seatown");
            System.out.printf("Choose your battlefield [1|2]: ");
            map = scanf.nextInt();scanf.nextLine();
        }while(map<1 || map>2);

        switch(map) {
            case 1:
                clear();
                System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                System.out.println(soldier+" in to battle field");
                System.out.println("Code Name   : Soldier");
                System.out.println("Battle Field: Crash  ");
                System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                System.out.println("");

                System.out.printf("+++++++++++++++++++++++++++++++++++\n");
                System.out.printf("CRASH MAP:                         \n");
                System.out.printf("+++++++++++++++++++++++++++++++++++\n");
                System.out.printf("+   __|s|_______       |==========|\n");
                System.out.printf("+__|            |______|          |\n");
                System.out.printf("+__                 ___           |\n");
                System.out.printf("+  |    ___        |   |       s  |\n");
                System.out.printf("+  |___|   |_______|   |__________|\n");
                System.out.printf("+++++++++++++++++++++++++++++++++++\n");
                System.out.println("=== Welcome to Crash  ===");
                System.out.println("Please Standby |5 round |");
                do {
                    int choose;
                    do {
                        System.out.printf("Press 1:");
                        press = scanf.nextInt();scanf.nextLine();
                    }while(press !=1 );

                    do {
                        System.out.println("Fire or reload");
                        System.out.println("1. F");
                        System.out.println("2. R");
                        System.out.printf(">> ");
                        choose = scanf.nextInt();scanf.nextLine();
                    }while(choose <1 || choose >2);

                    if(choose == 1) {
                        Fire= vecdata.get(index-1).getAmmo() - 10;
                        vecdata.get(index-1).setAmmo(Fire);
                        System.out.println(soldier+" is taking fire");
                    }
                    else {
                        if(vecdata.get(index-1).getType() == "Rifle") {
                            reload = 300;
                            vecdata.get(index-1).setAmmo(reload);
                        }
                        else {
                            reload = 100;
                            vecdata.get(index-1).setAmmo(reload);

                        }
                        System.out.println(soldier+" is reload!");
                    }
                    int warpoint = Math.abs(random.nextInt(2)+1);
                    if(warpoint== 1) {
                        win++;
                    }
                    else {
                        lose++;
                    }
                    game++;
                }while(game !=5);

                clear();
                System.out.printf("+========+\n");
                System.out.printf("|Win : %d|\n",win);
                System.out.printf("|Lose: %d|\n",lose);
                System.out.printf("+========+\n");

                if(win > lose) {
                    System.out.println("Good job soldier!");
                }
                else {
                    System.out.println("Better next Time - Adryan Sucipto");
                }
                win  = 0;
                lose = 0;
                game = 0;
                break;

            case 2:
                clear();
                System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                System.out.println(soldier+" in to battle field");
                System.out.println("Code Name   : Soldier");
                System.out.println("Battle Field: Seatown");
                System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                System.out.println("");

                System.out.printf("+++++++++++++++++++++++++++++++++++\n");
                System.out.printf("Seatown MAP:                       \n");
                System.out.printf("+++++++++++++++++++++++++++++++++++\n");
                System.out.printf("+   ___________| ______ |=========|\n");
                System.out.printf("+__|            |______|          |\n");
                System.out.printf("+|                  ___           |\n");
                System.out.printf("+| s    ___        |___|       s  |\n");
                System.out.printf("+|_____|   |______________________|\n");
                System.out.printf("+++++++++++++++++++++++++++++++++++\n");
                System.out.println("=== Welcome to Seatown===");
                System.out.println("Please Standby |5 round |");
                do {
                    int choose;
                    do {
                        System.out.printf("Press 1:");
                        press = scanf.nextInt();scanf.nextLine();
                    }while(press !=1 );

                    do {
                        System.out.println("Fire or reload");
                        System.out.println("1. F");
                        System.out.println("2. R");
                        System.out.printf(">> ");
                        choose = scanf.nextInt();scanf.nextLine();
                    }while(choose <1 || choose >2);

                    if(choose == 1) {
                        Fire= vecdata.get(index-1).getAmmo() - 10;
                        vecdata.get(index-1).setAmmo(Fire);
                        System.out.println(soldier+" is taking fire");
                    }
                    else {
                        if(vecdata.get(index-1).getType() == "Rifle") {
                            reload = 300;
                            vecdata.get(index-1).setAmmo(reload);
                        }
                        else {
                            reload = 100;
                            vecdata.get(index-1).setAmmo(reload);
                        }
                        System.out.println(soldier+" is reload!");
                    }

                    int warpoint = Math.abs(random.nextInt(2)+1);
                    if(warpoint == 1) {
                        win++;
                    }
                    else {
                        lose++;
                    }
                    game++;
                }while(game !=5);
                System.out.printf("+========+\n");
                System.out.printf("|Win : %d|\n",win);
                System.out.printf("|Lose: %d|\n",lose);
                System.out.printf("+========+\n");
                if(win > lose) {
                    System.out.println("Good job soldier!");
                }
                else {
                    System.out.println("Better next Time - Adryan Sucipto");
                }
                win = 0;
                lose =0;
                game=0;
                break;
        }
    }

    void fired() {
        int del;
        show();
        do {
            System.out.printf("Input Soldier to fired [ 1 - "+vecdata.size()+" ]: ");
            index = scanf.nextInt();scanf.nextLine();
        }while(index<1 || index >vecdata.size());
        do {
            System.out.println("Why you want to fired him? [1 | 2]");
            System.out.println("1. Too noob!");
            System.out.println("2. Too Slow!");
            System.out.printf(">> ");
            del = scanf.nextInt();scanf.nextLine();
        }while(del<1 ||del>2);
        vecdata.remove(index-1);
        System.out.println("Good bye!");
    }

    public Main() {
        clear();
        System.out.println("War come down.....");
        System.out.println("War never end.....");
        System.out.println("This is End!......");
        System.out.printf("DDDDD    OOOOOO   TTTTTTTT   UU    UU \n");
        System.out.printf("DDDDDD  O000000O  TTTTTTTT   UU    UU \n");
        System.out.printf("DDDDDDD O000000O     TT      UU    UU \n");
        System.out.printf("DDDDDD  O000000O     TT      UUU  UUU \n");
        System.out.printf("DDDDDD  O000000O     TT      UUUUUUUU \n");
        System.out.printf("DDDDD    OOOOOO      TT      UUUUUUUU \n");
        System.out.println("Press any key to continue!");
        scanf.nextLine();
        do {
            clear();
            System.out.println(" ____________ ");
            System.out.println("|COD MADE by:|");
            System.out.println("|Lorenzo  |");
            System.out.println("|____________|");
            System.out.println("|            |");
            System.out.println("|Call of Dotu|");
            System.out.println("|____________|");
            System.out.println("|1. Insert > |");
            System.out.println("|2. Show   > |");
            System.out.println("|3. War    > |");
            System.out.println("|4. Fired  > |");
            System.out.println("|5. Exit   > |");
            System.out.println("|____________|");
            System.out.printf("Input >> ");
            n = scanf.nextInt();scanf.nextLine();

            switch(n) {
                case 1:
                    clear();
                    insert();
                    System.out.println("Press enter to continue!");
                    scanf.nextLine();
                    break;
                case 2:
                    clear();
                    if(vecdata.size() == 0) {
                        System.out.println("No Inventory in here!");
                    }
                    else {
                        show();
                    }
                    System.out.println("Press enter to continue!");
                    scanf.nextLine();
                    break;
                case 3:
                    if(vecdata.size() == 0) {
                        System.out.println("No Solder to choose!");
                    }
                    else {
                        war();
                    }
                    System.out.println("Press enter to continue!");
                    scanf.nextLine();
                    break;
                case 4:
                    if(vecdata.size() == 0) {
                        System.out.println("No Solder to choose!");
                    }
                    else {
                        fired();
                    }
                    System.out.println("Press enter to continue!");
                    scanf.nextLine();
                    break;
                case 5:
                    vecdata.removeAllElements();
                    for(int i = 0; i < 10;i++) {
                        System.out.println("Developer ");
                        System.out.println(" Lorenzo ");
                        System.out.println(" Mantap jiwa");
                        System.out.println("Design ");
                        System.out.println(" Lorenzo");
                        System.out.println(" Mantep gan");
                        System.out.println("Soldier ");
                        System.out.println(" Gaz");
                        System.out.println(" Ghost");
                        System.out.println(" Captain Price");
                        System.out.println("Map ");
                        System.out.println(" Crash");
                        System.out.println(" Seatown");
                        System.out.println("Weapon ");
                        System.out.println(" Assault Rifle");
                        System.out.println(" Sniper Rifle ");
                    }
                    System.out.println("Good bye....");
                    System.out.println("Press enter to continue!");
                    scanf.nextLine();
                    break;
            }
        }while(n!=5);
    }

    private void clear() {
        for(int i = 0; i< 35;i++) {
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}



